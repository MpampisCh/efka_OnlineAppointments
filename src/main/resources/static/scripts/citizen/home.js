function logout() {
    sessionStorage.removeItem(SESSION_STORAGE_LOGIN_TOKEN_NAME);
    window.location.replace(ROOT_PATH + "/logout")
}

function populateDataTableAndUpdate(books) {

            $("#books").append("<tbody>");
            jQuery.each(books, function(i,book) {
            if (book.title=="The Grapes of Wrath"){
               $("#books").append("<tr id='bookRow" + book.id + "'><td>" + book.id + "</td><td>" + book.title + "</td><td>" + book.isbn + "</td><td><i id='NoClickableImage' class='fa fa-pencil-square-o' aria-hidden='true'></i></td><td><i id='ClickableImage' class='fa fa-trash' aria-hidden='true' data-toggle='modal' data-target='#deleteModal' onclick='findRow()'></i></td></tr>");

            }
            else{
                $("#books").append("<tr id='bookRow" + book.id + "'><td>" + book.id + "</td><td>" + book.title + "</td><td>" + book.isbn + "</td><td><i id='ClickableImage' class='fa fa-pencil-square-o' aria-hidden='true' onclick='print()'></i></td><td><i id='ClickableImage' class='fa fa-trash' aria-hidden='true' data-toggle='modal' data-target='#deleteModal' onclick='findRow()'></i></td></tr>");

            }

             });
             $("#books").append("</tbody>");

             $('#books').DataTable({
                    //"bFilter": false,
                     "columnDefs": [
                      { "orderable": false, "targets": 3 },
                      { "orderable": false, "targets": 4 }
                        ]
                     });

}

function print(){
      $("#books tr").click(function() {
       let tabler=$(this).children("td").html();
       window.location.href="update.html?bookid="+tabler;
    });
}
var tableRow;
function findRow(){
      $("#books tr").click(function() {
       tableRow=$(this).children("td").html();
    });
}

function details(){
      $.ajax({
           url: ROOT_PATH + "/appointments"
       }).then(function(books) {
           populateDataTableAndUpdate(books);
       });
}
function populateSpecialtyDropdown(specialties) {
    let dropdown = $('#specialtyA');
    dropdown.prop('selectedIndex', 0);
    jQuery.each(specialties, function(i,specialty) {
     $("#specialtyA").append("<option value="+specialty.name+">"+specialty.name+"</option>");
     });

}

function populateDoctorsDropdown(doctors) {
    let dropdown = $('#doctorA');
    dropdown.empty();
    dropdown.prop('selectedIndex', 0);
    jQuery.each(doctors, function(i,doctor) {
     $("#doctorA").append("<option value="+doctor.amka+">"+doctor.lastName+"</option>");
     });
}

function loadBook(id) {
    $.ajax({
        url: ROOT_PATH + "/appointments/" + id
    }).then(function(book) {
       $("input[name=id]").val(book.id);
       $("input[name=specialty]").val(book.title);
       $("input[name=doctor]").val(book.isbn);
    });
};

$(document).ready(function() {
   let json = JSON.parse(sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME));
   let userw=json.userName;
   document.getElementById("welcome").innerHTML = "You are connected as " + userw;
   $.ajax({
        url: ROOT_PATH + "/appointments"
    }).then(function(books) {
        populateDataTableAndUpdate(books);
    });

    $.ajax({
               url:ROOT_PATH + '/specialties',
               dataType : 'json',
               contentType: 'application/json',
           }).then(function(specialties) {
               populateSpecialtyDropdown(specialties);
       });

    $("#doctorA").on('click', function(event){
     let specialtyName=$("#specialtyA").val();
     $.ajax({
            url:ROOT_PATH + '/specialty/'+ specialtyName+'/doctors',
            dataType : 'json',
            contentType: 'application/json',
           }).then(function(doctors) {
               populateDoctorsDropdown(doctors);
       });
     });

    $("#saveButton").on('click', function(event){
        event.preventDefault();
        let url = new URL(document.URL);
        var c = url.searchParams.get("bookid");
        let newTitle=$("input[name=specialty]").val();
        let newIsbn=$("input[name=doctor]").val();
        let updatedata = {
              "title" :  newTitle,
              "isbn" :  newIsbn
            };
         $.ajax({
             url:  ROOT_PATH + '/appointment/'+ c,
             type : 'PUT',
             data: JSON.stringify(updatedata),
             dataType : 'json',
             contentType: 'application/json',
             success: function(data){
               $("#updateModal").modal();
                },
                 statusCode: {
                     401 : function() {
                         alert("Invalid data!");
                     }
                 }
             });

    });



  $("#cancelButton").on('click', function(event){
       window.location.href="index.html";
  });

 $("#createAppointmentButton").on('click', function(event){
        event.preventDefault();
        let specialtyA=$( "#specialtyA" ).val();
        let doctorA=$( "#doctorA" ).val();
        let dateA=$("input[name=date]").val();
        let timeA=$("input[name=time]").val();
        let dateTime=dateA.concat(" ",timeA);
        let description=$("#briefdescription").val();
        let notes=$("#notes").val();
        let dataAppointment = {
              // "specialty":  specialtyA,

              "doctor":   {
                  "amka": doctorA
              },
              "dateTime": dateTime,
              "description": description,
              "notes": notes
            };
         $.ajax({
             url:  ROOT_PATH + '/newAppointment',
             type : 'POST',
             data: JSON.stringify(dataAppointment),
             dataType : 'json',
             contentType: 'application/json',
             success: function(data){
               alert("Ok");
               $('#makeAppointmentModal').modal('hide');
               $("#books").DataTable().draw();
                },
                 statusCode: {
                     401 : function() {
                         alert("Invalid data!");
                     }
                 }
             });
 });

    $("#deleteButton").on('click', function(event){
        event.preventDefault();
        $.ajax({
            url: ROOT_PATH + "/appointment/" + tableRow,
            type : "DELETE",
            dataType : 'json',
            contentType: 'application/json',
                success : function(result) {
                    $("#books").DataTable().row("#bookRow"+tableRow).remove().draw();
                    $("input[name=id]").val("");
                    $("input[name=title]").val("");
                    $("input[name=isbn]").val("");
                },
                error: function(xhr, resp, text) {
                    console.log(xhr, resp, text);
                    alert("Could not delete book!");
                 }
         })

    });
});
