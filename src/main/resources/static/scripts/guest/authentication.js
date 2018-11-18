
function login(usernameElement, passwordElement,roleElement) {
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";
    let role = roleElement && roleElement ? roleElement : "";
    let user = { userName: username ,role: role};


    if (role=="ADMIN"){
        let prefix="A\t";
      var usernameappended=prefix.concat(username);
      }
     else if (role=="CITIZEN"){
        let prefix="C\t";
        var usernameappended=prefix.concat(username);
      }
     else if (role=="DOCTOR"){
        let prefix="D\t";
        var usernameappended=prefix.concat(username);
      }

    var fd = new FormData();
    fd.append( 'username', usernameappended);
    fd.append( 'password', password);
    fd.append( 'role', role);

    $.ajax({
       url: ROOT_PATH + '/login',
       data: fd,
       processData: false,
       contentType: false,
       type: 'POST',
       success: function(data){
       sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, JSON.stringify(user));
       let json = JSON.parse(sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME));
         if (json.role=="ADMIN"){
             window.location.replace(ROOT_PATH + "/pages/admin/index.html");
         }
         else if (json.role=="CITIZEN"){
             window.location.replace(ROOT_PATH + "/pages/citizen/index.html");
         }
         else if (json.role=="DOCTOR"){
             window.location.replace(ROOT_PATH + "/pages/doctor/index.html");
         }
       },
       statusCode: {
         401 : function() {
                 alert("Invalid username or password!");
             }
         }
     });

}

function register(firstnamelement,lastnameElement,amkaElement,phoneElement,emailElement,usernameElement,passwordElement) {
    let firstname = firstnamelement && firstnamelement.value ? firstnamelement.value : "";
    let lastname = lastnameElement && lastnameElement.value ? lastnameElement.value : "";
    let amka = amkaElement && amkaElement.value ? amkaElement.value : "";
    let phone = phoneElement && phoneElement.value ? phoneElement.value : "";
    let email = emailElement && emailElement.value ? emailElement.value : "";
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";

    var fd = new FormData();
    fd.append( 'firstname', firstname);
    fd.append( 'lastname', lastname);
    fd.append( 'amka', amka);
    fd.append( 'phone', phone);
    fd.append( 'email', email);
    fd.append( 'username', username);
    fd.append( 'password', password);


    $.ajax({
        url: ROOT_PATH + '/register',
        data: fd,
        processData: false,
        contentType: false,
        type: 'POST',
        success: function(data){
            alert("The registration completed successfully!");
            window.location.replace(ROOT_PATH + "/index.html");
        },
        statusCode: {
            401 : function() {
                alert("Invalid information!");
            }
        }
    });

}
