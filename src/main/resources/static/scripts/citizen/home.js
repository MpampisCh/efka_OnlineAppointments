function logout() {
    sessionStorage.removeItem(SESSION_STORAGE_LOGIN_TOKEN_NAME);
    window.location.replace(ROOT_PATH + "/logout")
}
function populateDataTableAndUpdate(appointments) {
             let getToday = new Date();
             const day=getToday.getDate();
             const month=getToday.getMonth()+1;
             const year=getToday.getFullYear();
             const today=month+ "-"+ day + "-" + year;
             if ( $.fn.DataTable.isDataTable('#appointments') ) {
                   $('#appointments').DataTable().destroy();
              }
            $('#appointments tbody').empty();
            $("#appointments").append("<tbody>");
            jQuery.each(appointments, function(i,appointment) {
             let appointmentTime=appointment.dateTime.split(" ");
             let dappointment = Date.parse(appointmentTime[0]);
             let dtoday = Date.parse(today);

            if (dappointment<=dtoday){
               $("#appointments").append("<tr id='appointmentRow" + appointment.id + "'><td>" + appointment.id + "</td><td>" + appointment.doctor.specialty.name + "</td><td>" + appointment.dateTime + "</td><td><i id='NoClickableImage' class='fa fa-pencil-square-o' aria-hidden='true'></i></td><td><i id='NoClickableImage' class='fa fa-ban' aria-hidden='true' data-toggle='modal' data-target='#deleteModal' onclick='findRow()'></i></td></tr>");

            }
            else{
                $("#appointments").append("<tr id='appointmentRow" + appointment.id + "'><td>" + appointment.id + "</td><td>" +appointment.doctor.specialty.name + "</td><td>" + appointment.dateTime + "</td><td><i id='ClickableImageEdit' class='fa fa-pencil-square-o' aria-hidden='true' onclick='print()'></i></td><td><i id='ClickableImageCancel' class='fa fa-ban' aria-hidden='true' data-toggle='modal' data-target='#deleteModal' onclick='findRow()'></i></td></tr>");

            }

             });
           $("#appointments").append("</tbody>");

            $('#appointments').DataTable({
                   "bFilter": false,
                   "columnDefs": [
                     { "orderable": false, "targets": 3 },
                     { "orderable": false, "targets": 4 }
                           ]
                  });

}


function print(){
      $("#appointments tr").click(function() {
       let tabler=$(this).children("td").html();
       window.location.href="update.html?appointmentid="+tabler;
    });
}
var tableRow;
function findRow(){
      $("#appointments tr").click(function() {
       tableRow=$(this).children("td").html();
    });
}

function populateSpecialtyDropdownA(specialties) {
    let dropdown = $('#specialtyA');
    dropdown.prop('selectedIndex', 0);
    jQuery.each(specialties, function(i,specialty) {
     $("#specialtyA").append("<option value="+specialty.name+">"+specialty.name+"</option>");
     });

}

function populateSpecialtyDropdownS(specialties) {
    let dropdown = $('#specialtyS');
    dropdown.prop('selectedIndex', 0);
    jQuery.each(specialties, function(i,specialty) {
     $("#specialtyS").append("<option value="+specialty.name+">"+specialty.name+"</option>");
     });

}

function populateDoctorsDropdown(doctors) {
    let dropdown = $('#doctorA');
    dropdown.prop('selectedIndex', 0);
    dropdown.empty();
    $("#doctorA").append("<option value='' selected disabled>Choose Doctor</option>");
    jQuery.each(doctors, function(i,doctor) {
     $("#doctorA").append("<option value="+doctor.amka+">"+doctor.lastName+"</option>");
     });
}

function loadAppointment(id) {
    $.ajax({
        url: ROOT_PATH + "/appointment/" + id
    }).then(function(appointment) {
       $("input[name=specialtyU]").val(appointment.doctor.specialty.name);
       $("input[name=doctorU]").val(appointment.doctor.lastName);
       let appointmentDay=appointment.dateTime.split(" ");
       $("input[name=dateU]").val(appointmentDay[0]);
       $("input[name=timeU]").val(appointmentDay[1]);
       $(":input[name=briefdescriptionU]").val(appointment.description);
       $(":input[name=notesU]").val(appointment.notes);
    });
};

$(document).ready(function() {
   let json = JSON.parse(sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME));
   let userw=json.userName;
   document.getElementById("welcome").innerHTML = "You are connected as " + userw;
   $.ajax({
        url: ROOT_PATH + "/appointment/all/client"
    }).then(function(appointments) {
        populateDataTableAndUpdate(appointments);
    });

    $.ajax({
               url:ROOT_PATH + '/specialty/all',
               dataType : 'json',
               contentType: 'application/json',
           }).then(function(specialties) {
               populateSpecialtyDropdownA(specialties);
               populateSpecialtyDropdownS(specialties);
       });

     $('#specialtyA').change(function(){
                let specialtyName=$("#specialtyA").val();
                $.ajax({
                       url:ROOT_PATH + '/doc/all/spec/'+ specialtyName,
                       dataType : 'json',
                       contentType: 'application/json',
                      }).then(function(doctors) {
                          populateDoctorsDropdown(doctors);
                  });
          });

    $("#saveButton").on('click', function(event){
        event.preventDefault();
        let url = new URL(document.URL);
        var c = url.searchParams.get("appointmentid");
        let dayU=$("input[name=dateU]").val();
        let timeU=$("input[name=timeU]").val();
        let newdate=dayU.concat(" ",timeU);
        let newdescription=$(":input[name=briefdescriptionU]").val();
        let newnotes=$(":input[name=notesU]").val();
        let updatedata = {
              "dateTime": newdate,
              "description": newdescription,
              "notes": newnotes
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

  $("#searchAppointmentButton").on('click', function(event){
          event.preventDefault();
          let specialtyToSearch=$("#specialtyS").val();
          let datesToSearch=$("input[name=dates]").val().split(" ");
          let startds = datesToSearch[0];
          let endds = datesToSearch[2];
           $.ajax({
               url:  ROOT_PATH + '/appointment/all/date-specialty?specialty='+specialtyToSearch+'&startdate='+startds+" 00:00"+'&enddate='+endds+" 24:00",
               success: function(data){
                 $('#SearchModal').modal('hide');
                 populateDataTableAndUpdate(data);
                  },
                   statusCode: {
                       401 : function() {
                           alert("Invalid data!");
                       }
                   }
               });
   });

 $("#createAppointmentButton").on('click', function(event){
        event.preventDefault();
        let doctorA=$( "#doctorA" ).val();
        let dateA=$("input[name=date]").val();
        let timeA=$("input[name=time]").val();
        let dateTime=dateA.concat(" ",timeA);
        let description=$("#briefdescription").val();
        let notes=$("#notes").val();
        let dataAppointment = {
              "doctor":   {
                  "amka": doctorA
              },
              "dateTime": dateTime,
              "description": description,
              "notes": notes
            };
         $.ajax({
             url:  ROOT_PATH + '/appointment/new',
             type : 'POST',
             data: JSON.stringify(dataAppointment),
             dataType : 'json',
             contentType: 'application/json',
             success: function(data){
               alert("Ok");
               $('#makeAppointmentModal').modal('hide');
               let t=$("#appointments").DataTable();
              t.row.add( [data.id,data.doctor.specialty.name, data.dateTime,"<i id='ClickableImageEdit' class='fa fa-pencil-square-o' aria-hidden='true' onclick='print()'></i>","<i id='ClickableImageCancel' class='fa fa-ban' aria-hidden='true' data-toggle='modal' data-target='#deleteModal' onclick='findRow()'></i>"] ).node().id="appointmentRow"+data.id;
              t.draw();
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
                    $("#appointments").DataTable().row("#appointmentRow"+tableRow).remove().draw();

                },
                error: function(xhr, resp, text) {
                    console.log(xhr, resp, text);
                    alert("Could not delete appointment!");
                 }
         })

    });
});
