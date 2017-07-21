function conveyDeleteStudentCourseId(id){
  $("#deleteStudentCourseId").val(id);
}

function conveySaveId(courseId){
  $("#saveCourseId").val(courseId);
}

function submitDeleteStudentCourse(){
  $.ajax({
    url:"/studentCourse/"+$("#deleteStudentCourseId").val(),
    type:'DELETE',
    success:function(data){
      if(data.code == 200){
        location.href = "/student/index";
      }else{
        alert(data,message);
      }
    },
    error:function(){alert("请求出错")}
  })
}

function submitStudentCourse(){
  $.ajax({
    url:"/studentCourse",
    type:'POST',
    data:{
      courseId : $("#saveCourseId").val()
    },
    success:function(data){
      if(data.code == 200){
        location.href = "/student/index";
      }else{
        alert(data.message);
      }
    },
    error:function(){alert("请求出错")}
  })
}