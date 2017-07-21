<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">
  <title>开课</title>
<#include "../base.ftl">
  <link href="/css/printManagement_style.css" rel="stylesheet"/>
  <script src="/js/do/teacher/saveCourse.js"></script>
  <script src="/js/jquery.form.js"></script>

</head>
<body>
<div class="container">

<#include "../header.ftl">
  <div class="row">
    <div class="col-xs-12">
    <#include "../teacher_nav.ftl" >
    </div>
  </div> <!-- /row -->

  <!--main_content start-->
  <div class="main_content">
    <h3 class="content_title">开课
    </h3>
    <div class="add_form form-horizontal" id="add_form">
      <div class="form-group">

        <div class="col-sm-6">
          <label class="col-sm-3">课程名称：</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" placeholder="名称" id="nameInput"/>
          </div>
        </div>

        <div class="col-sm-6">
          <label class="col-sm-3">课程容量：</label>
          <div class="col-sm-9">
            <input type="number" class="form-control" placeholder="容量" id="numInput"/>
          </div>
        </div>

      </div>
      <div class="form-group">
        <div class="col-sm-12">
          <div class="col-sm-9"></div>
          <div class="col-sm-3">
            <a href="#" class="btn btn-primary btn-block" onclick="submitSaveCourse()">提交</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--main_content end-->

  <form action="/course" method="post" id="data" style="display: none">
    <input name="name" id="name">
    <input name="num" id="num">
  </form>


</div>




</body>
</html>