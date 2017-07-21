<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">
  <title>选课</title>

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
    <h3 class="content_title">选课</h3>
    <table class="table table-bordered table-striped table-condensed record_table"
           id="record_table">
      <thead>
      <tr>
        <th colspan="4">课程
        <th>
      </tr>
      <tr>
        <th>名称</th>
        <th>开课老师</th>
        <th>可选</th>
        <th>已选</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <#list selectableCourses as course>
        <tr>
          <td>${course.name}</td>
          <td>${course.teacher.name}</td>
          <td>${course.num}</td>
          <td>${course.numE}</td>
          <td>
            <#if course.selected>
              <a href="#" class="btn btn-danger btn-block" data-toggle="modal" data-target="#deleteModal"
                 onclick="conveyDeleteStudentCourseId('${course.studentCourseId}')">退选</a>
            </#if>
            <#if !course.selected && course.selectable>
              <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#detailModal"
                onclick="conveySaveId('${course.id}')">选课</a>
            </#if>
          </td>
        </tr>
      </#list>

      </tbody>
    </table>

    <table class="table table-bordered table-striped table-condensed record_table"
           id="record_table">
      <thead>
      <tr>
        <th colspan="3">已选课程
        <th>
      </tr>
      <tr>
        <th>名称</th>
        <th>开课老师</th>
        <th>选课时间</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <#list selectedCourses as selectCourse >
        <tr>
          <td>${selectCourse.course.name}</td>
          <td>${selectCourse.teacher.name}</td>
          <td>${selectCourse.createTime?date}</td>
          <td>
            <a href="#" class="btn btn-danger btn-block" data-toggle="modal" data-target="#deleteModal"
               onclick="conveyDeleteStudentCourseId('${selectCourse.id}')">退选</a>
          </td>
        </tr>
      </#list>

      </tbody>
    </table>


  </div>
  <!--main_content end-->


</div>


<#include "../footer.ftl">

<!-- detail Modal -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
          aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="deleteModalLabel">确认消息</h4>
      </div>
      <div class="modal-body">
        是否选课？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal"
                onclick="submitStudentCourse()">确定</button>
      </div>
    </div>
  </div>
</div>

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
                onclick="submitDeleteStudentCourse()">确定</button>
      </div>
    </div>
  </div>
</div>

<input id="deleteStudentCourseId" style="display: none">
<input id="saveStudentId" style="display: none">
<input id="saveCourseId" style="display: none;">

<script src="/js/do/student/index.js"></script>

</body>
</html>
