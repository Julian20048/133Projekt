/**
 * view-controller for login.html
 *
 * M133: KaderVerwaltung
 *
 * @author Julian Janik
 */

/**
 * register listeners
 */
$(document).ready(function() {

    /**
     * listener for submitting the form sends the login data to the web service
     */
    $("#loginForm").submit(sendlogin);
    /**
     * listener for button (Abmelden)
     */
    $("#logoff").click(sendLogoff);

});

/**
 * sends the login-request
 *@param form the form with the username/password
 */
function sendLogin(form) {
    form.preventDefault();
    $
        .ajax({
            url: ".resource/user/login",
                dataType: "text",
            type: "POST",
            data: $("#loginForm").serialize()
    })
    .done(function(){
        window.location.href = "./bookshelf.html";
    })
        .fail(function(xhr, status, errorThrown){
            if (xhr.status == 404){
                $("#message").text("Benutzername/Passwort unbekannt");
            }else{
                $("#message").text("Es ist ein Fehler aufgetreten");
            }
        })

}

/**
 * sends the logoff-request
 */
function sendLogoff(){
    form.preventDefault();
    $
        .ajax({
            url: ".resource/user/logoff",
            dataType: "text",
            type: "DELETE",
        })
        .done(function(){
            window.location.href = "./login.html";
        })
        .fail(function(xhr, status, errorThrown){
        })

}