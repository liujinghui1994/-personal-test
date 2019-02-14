function doLogin(){
    window.location.href="/login/loginPage";
}

function doRegister(){
    // action="/register/saveRegisterDetail"
    // window.location.href="/login/loginPage";
    var userPassword = $("#userPassword").val();
    var salt = "1a2b3c4d";
    var saltUserPassword = ""+salt.charAt(0)+salt.charAt(2) + userPassword +salt.charAt(5) + salt.charAt(4);
    saltUserPassword = md5(saltUserPassword);

    $.ajax({
        url: "/register/saveRegisterDetail",
        type: "POST",
        data:{
            userName:$("#userName").val(),
            userEmail:$("#userEmail").val(),
            userMobile:$("#userMobile").val(),
            userPassword: saltUserPassword
        },
        success:function(data){
            alert(data.resultMessage);
            window.location.href="/login/loginPage";
        },
        error:function(data){
            alert(data.resultMessage);
        }
    });
}
