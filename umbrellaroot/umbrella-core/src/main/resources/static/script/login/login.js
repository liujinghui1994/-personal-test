function doLogin(){
    var userPassword = $("#userPassword").val();
    var salt = "1a2b3c4d";
    var saltUserPassword = ""+salt.charAt(0)+salt.charAt(2) + userPassword +salt.charAt(5) + salt.charAt(4);
    saltUserPassword = md5(saltUserPassword);
    var userName = $("#userName").val();
	console.log(userName);
    $.ajax({
        url: "/login/doLogin",
        type: "GET",
        async: false,
        data:{
            userName:userName,
            userPassword: saltUserPassword
        },
        success:function(data){
            // alert(data.resultMessage);
            window.location.href="/productManage/listDefaultProducts";
        },
        error:function(data){
            // alert(data.resultMessage);
            window.location.href="/login/loginPage";
        }
    });
}

function doRegister(){
    window.location.href="/register/registerPage";
}