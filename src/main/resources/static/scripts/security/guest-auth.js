if (sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME)) {
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
}
