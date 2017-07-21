function login(userType){
  if(isNull($("#login-name").val())){
    $("#login-name").focus();
    return false;
  }
  if(isNull($("#login-pass").val())){
    $("#login-pass").focus();
    return false;
  }
  $("#userType").val(userType);
  $("#name").val($("#login-name").val());
  $("#password").val($("#login-pass").val());
  $("#data").ajaxSubmit({
    success:function(data) {
        console.log(data);
        if(data.code == 200){
            if(userType == 0){
              location.href = "/teacher/index";
            }else{
              location.href = "/student/index";
            }
        }else{
            $("#passwordError").html("用户名或密码错误");
            $("#login-pass").focus();
        }
    }
  })
}
