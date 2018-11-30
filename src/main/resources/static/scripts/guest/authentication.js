  $(document).ready(function() {
    $("#loginButton").on('click', function(event){
    event.preventDefault();
        let username = document.getElementById("userName").value;
        let password = document.getElementById("password").value;
        let e = document.getElementById("roleselection");
         let role = e.options[e.selectedIndex].value;

          let user = { userName: username ,role: role};

            if (role == "ADMIN") {
                 let prefix="A\t";
                var usernameappended=prefix.concat(username);
                }
             else if (role == "CITIZEN") {
              let prefix = "C\t";
               var usernameappended = prefix.concat(username);
               }
                 else if (role == "DOCTOR") {
                   let prefix = "D\t";
                    var usernameappended = prefix.concat(username);
                  }

                var fd = new FormData();
                 fd.append( 'username', usernameappended);
                  fd.append( 'password', password);


                      $.ajax({
                         url: ROOT_PATH + '/login',
                         data: fd,
                         processData: false,
                         contentType: false,
                         type: 'POST',
                         success: function(data) {
                         sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, JSON.stringify(user));
                         let json = JSON.parse(sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME));
                           if (json.role == "ADMIN") {
                               window.location.replace(ROOT_PATH + "/pages/admin/index.html");
                           }
                           else if (json.role == "CITIZEN") {
                               window.location.replace(ROOT_PATH + "/pages/citizen/index.html");
                           }
                           else if (json.role == "DOCTOR") {
                               window.location.replace(ROOT_PATH + "/pages/doctor/index.html");
                           }
                         },
                         statusCode: {
                           401 : function() {
                                  document.getElementById('errorAnswer').style.display = "block";
                               }
                           }
                       });

                  });


});
