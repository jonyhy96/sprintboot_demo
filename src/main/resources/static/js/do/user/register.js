function register(){

  $("#passwordRepeatError").html("");
  if(isNull($("#nameInput").val())){
    $("#nameInput").focus();
    return false;
  }
  if(isNull($("#passwordInput").val())){
    $("#passwordInput").focus();
    return false;
  }
  if(isNull($("#passwordRepeat").val())){
    $("#passwordRepeat").focus();
    return false;
  }
  if($("#passwordInput").val() != $("#passwordRepeat").val()){
    $("#passwordRepeatError").html("两次输入不同");
    return false;
  }

  $("#userType").val($("#userTypeInput").val());
  $("#name").val($("#nameInput").val());
  $("#password").val($("#passwordInput").val());
  $("#data").submit();
}
