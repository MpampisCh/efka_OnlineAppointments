if (sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME)) {
    let json = JSON.parse(sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME));
    if (json.role == "DOCTOR") {
        window.location.replace(ROOT_PATH + "/pages/doctor/index.html");
    }
}
