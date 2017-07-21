<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">
  <title>注册</title>
  <#include "base.ftl">
  <link href="/css/printManagement_style.css" rel="stylesheet"/>
  <script src="/js/do/user/register.js"></script>

</head>
<body>
<div class="container">
  <!--main_content start-->
  <div class="main_content">
    <h3 class="content_title">注册
    </h3>
    <div class="add_form form-horizontal" id="add_form">
      <div class="form-group">

        <div class="col-sm-6">
          <label class="col-sm-3">用户类型：</label>
          <div class="col-sm-9">
            <select class="form-control" id="userTypeInput">
              <option value="1" name="userType" selected>学生</option>
              <option value="0" name="userType">教师</option>
            </select>
          </div>
        </div>

        <div class="col-sm-6">
          <label class="col-sm-3">用户名：</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" placeholder="用户名" id="nameInput"/>
          </div>
        </div>

      </div>
      <div class="form-group">
        <div class="col-sm-6">
          <label class="col-sm-3">密码：</label>
          <div class="col-sm-9">
            <input type="password" class="form-control" id="passwordInput"/>
          </div>
        </div>
        <div class="col-sm-6">
          <label class="col-sm-3">确认密码：</label>
          <div class="col-sm-9">
            <input type="password" class="form-control" id="passwordRepeat"/>
            <span id="passwordRepeatError" style="color: red" ></span>
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-12">
          <div class="col-sm-9"></div>
          <div class="col-sm-3">
            <a href="#" class="btn btn-primary btn-block" onclick="register()">注册</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--main_content end-->

  <form action="/user/register" method="post" id="data" style="display: none">
    <input name="userType" id="userType">
    <input name="name" id="name">
    <input name="password" id="password">
  </form>


</div>




</body>
</html>