function logout() {
    sessionStorage.removeItem(SESSION_STORAGE_LOGIN_TOKEN_NAME);
    window.location.replace(ROOT_PATH + "/logout")
}
function populateDataTable(appointments) {
             if ( $.fn.DataTable.isDataTable('#appointments') ) {
                   $('#appointments').DataTable().destroy();
              }
            $('#appointments tbody').empty();
            $("#appointments").append("<tbody>");
            jQuery.each(appointments, function(i,appointment) {
                $("#appointments").append("<tr id='appointmentRow" + appointment.id + "'><td>" + appointment.id + "</td><td>" +appointment.dateTime + "</td><td>" + appointment.description + "</td><td><i id='ClickableImage' class='fa fa-info-circle' aria-hidden='true' data-toggle='modal' data-target='#viewAppointmentModal' onclick='findRow()'></i></td></tr>");

             });
           $("#appointments").append("</tbody>");

            $('#appointments').DataTable({
                   "bFilter": false,
                   "columnDefs": [
                     { "orderable": false, "targets": 3 },
                           ]
                  });

}

var tableRow;
function findRow(){
      $("#appointments tr").click(function() {
       tableRow=$(this).children("td").html();
       loadAppointment(tableRow);
    });
}

function loadAppointment(id) {
       let appointment=$.grep(appointmentsTable, function(e){ return e.id == id; });
       let appointmentDay=appointment[0].dateTime.split(" ");
       $("input[name=date]").val(appointmentDay[0]);
       $("input[name=time]").val(appointmentDay[1]);
       $(":input[name=briefdescription]").val(appointment[0].description);
       $(":input[name=notes]").val(appointment[0].notes);
       $("input[name=fname]").val(appointment[0].client.firstName);
       $("input[name=lname]").val(appointment[0].client.lastName);
       $("input[name=amka]").val(appointment[0].client.amka);
       $("input[name=phone]").val(appointment[0].client.phone);
       $("input[name=email]").val(appointment[0].client.email);
}

var appointmentsTable;
$(document).ready(function() {
   let json = JSON.parse(sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME));
   let userw=json.userName;
   document.getElementById("welcome").innerHTML = "You are connected as " + userw;
   $.ajax({
        url: ROOT_PATH + "/appointment/all/doctor"
    }).then(function(appointments) {
        appointmentsTable=appointments;
        populateDataTable(appointments);
    });

  $("#searchAppointmentButton").on('click', function(event){
          event.preventDefault();
          let descriptionToSearch=$("#briefdescriptionS").val();
          let datesToSearch=$("input[name=dates]").val().split(" ");
          let startds = datesToSearch[0];
          let endds = datesToSearch[2];
           $.ajax({
               url:  ROOT_PATH + '/appointment/all/date-desc?description='+descriptionToSearch+'&startdate='+startds+" 00:00"+'&enddate='+endds+" 24:00",
               success: function(data){
                appointmentsTable=data;
                 $('#SearchModal').modal('hide');
                 populateDataTable(data);
                  },
                   statusCode: {
                       401 : function() {
                           alert("Invalid data!");
                       }
                   }
               });
   });


});