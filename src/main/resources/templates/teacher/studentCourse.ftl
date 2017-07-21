<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">
  <title>我的课程</title>

<#include "../base.ftl" >

  <!--loading importRecord_style-->
  <link href="/css/importRecord_style.css" rel="stylesheet"/>



<body>
<div class="container">

<#include "../header.ftl">
  <div class="row">
    <div class="col-xs-12">
    <#include "../student_nav.ftl" >
    </div>
  </div> <!-- /row -->

  <!--main_content start-->
  <div class="main_content">
    <h3 class="content_title">选课情况</h3>
    <table class="table table-bordered table-striped table-condensed record_table"
           id="record_table">
      <thead>
      <tr>
        <th colspan="2">已选学生
        <th>
      </tr>
      <tr>
        <th>名称</th>
        <th>学生姓名</th>
        <th>选课时间</th>
      </tr>
      </thead>
      <tbody>
      <#list studentCourses as selectCourse >
      <tr>
        <td>${selectCourse.course.name}</td>
        <td>${selectCourse.student.name}</td>
        <td>${selectCourse.createTime?date}</td>
      </tr>
      </#list>

      </tbody>
    </table>


  </div>
  <!--main_content end-->


</div>


<#include "../footer.ftl">

<!-- delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
          aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="deleteModalLabel">确认消息</h4>
      </div>
      <div class="modal-body">
        是否退选？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal"
                onclick="submitDeleteCourse()">确定</button>
      </div>
    </div>
  </div>
</div>

<input id="deleteCourseId" style="display: none">

</body>
</html>
