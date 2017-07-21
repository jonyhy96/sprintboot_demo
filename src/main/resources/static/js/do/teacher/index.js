function conveyDeleteCourseId(id) {
  $("#deleteCourseId").val(id);
}

function submitDeleteCourse() {
  $.ajax({
    url: "/course/" + $("#deleteCourseId").val(), type: 'DELETE', success: function(data) {
      if (data.code == 200) {
        location.href = "/teacher/index";
      } else {
        alert(data.message);
      }
    }, error: function() {
      alert("请求出错");
    }
  })
}