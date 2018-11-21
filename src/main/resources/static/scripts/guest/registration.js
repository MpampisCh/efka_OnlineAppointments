function register(firstnameElement,lastnameElement,amkaElement,phoneElement,emailElement,usernameElement,passwordElement) {
    let firstname = firstnameElement && firstnameElement.value ? firstnameElement.value : "";
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