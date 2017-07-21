<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">
  <title>登录</title>
  <#include "base.ftl">
  <!--loading login_style-->
  <link href="/css/login_style.css" rel="stylesheet">

  <script src="/js/jquery.form.js"></script>

  <script src="/js/do/user/login.js"></script>
</head>
<body>

<div class="login">
  <h1 class="title">
    简单选课
  </h1>
  <div class="login-screen">
    <div class="login-icon">
      <img src="/flatUI-dist/img/login/icon.png" alDt="Welcome to MS" />
    </div>

    <div class="login-form">
      <div class="form-group">
        <input type="text" class="form-control login-field" value="" placeholder="输入姓名" id="login-name" />
        <label class="login-field-icon fui-user" for="login-name" id="nameError"></label>
      </div>

      <div class="form-group">
        <input type="password" class="form-control login-field" value="" placeholder="输入密码" id="login-pass" />
        <label class="login-field-icon fui-lock" for="login-pass" id="passwordError"></label>
      </div>

      <a class="btn btn-primary btn-lg btn_login" href="#" onclick="login('1')">学生登录</a>
      <a class="btn btn-primary btn-lg btn_login" href="#" onclick="login('0')">教师登录</a>
      <a class="login-link" href="/user/register">注册</a>

    </div>
  </div>
</div>

<form id="data" action="/user/login" method="post" style="display: none">
  <input id="userType" name="userType">
  <input id="name" name="name">
  <input id="password" name="password">
</form>

<#include "footer.ftl">

</body>
</html>