$(document).ready(function() {
    var input = $('.validate-input .input100');

   $("#loginButton").on('click', function(event){
   event.preventDefault();
             var check = true;

                    for (var i=0; i<input.length; i++) {
                        if (validate(input[i]) == false){
                            showValidate(input[i]);
                            check = false;
                        }
                    }
                    if (check == true) {
                        login();
                    }
    });

    $('.validate-form .input100').each(function() {
         $(this).focus(function() {
         hideValidate(this);
         document.getElementById('errorAnswer').style.display = "none";
         });
    });

               function validate (input) {
                   if($(input).attr('type') == 'password'){
                    if($(input).val().length<4){
                        return false;
                        }
                   }
                   else if ($(input).attr('name') == 'roleSelection') {
                        let e = document.getElementById("roleselection");
                        let role = e.options[e.selectedIndex].value;
                        if (role == 'Select Role') {
                            return false;
                        }
                   }
                   else {
                       if ($(input).val().trim() == '') {
                           return false;
                       }
                   }
               }

               function showValidate(input) {
                   var thisAlert = $(input).parent();
                   $(thisAlert).addClass('alert-validate');
               }

               function hideValidate(input) {
                   var thisAlert = $(input).parent();
                   $(thisAlert).removeClass('alert-validate');
               }

               function login() {
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

               }

});
