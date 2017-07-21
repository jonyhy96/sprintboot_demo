function submitSaveCourse() {
  if(isNull($("#nameInput").val())){
      $("#nameInput").focus();
      return false;
  }
  if(isNull($("#numInput").val())){
    $("#numInput").focus();
    return false;
  }

  $("#name").val($("#nameInput").val());
  $("#num").val($("#numInput").val());
  $("#data").ajaxSubmit({
    success:function(data) {
      if(data.code == 200){
        location.href = "/teacher/index";
      }else{
        alert(data.message);
      }
    },
    error:function() {
      alert("请求出错");
    }
  });
}