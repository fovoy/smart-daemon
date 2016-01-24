<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 16/1/24
  Time: 上午10:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Fovoy Smart-daemon Billing System</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
  <link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
  <script type="text/javascript">
    //登录
    function login(){
      var form = document.forms[0];
      form.action = "{pageContext.request.contextPath}/login";
      form.method = "post";
      form.submit();
    }
  </script>
</head>
<body>
<div id="loginpanelwrap">
  <div class="loginheader">
    <div class="logintitle"><a href="#">Fovoy后台系统登录</a></div>
  </div>
  <form action="/login" method="post">
    <div class="loginform">
    <div class="loginform_row">
      <label>用户名:</label>
      <input type="text" class="loginform_input" id="userName" name="userName" />
    </div>
    <div class="loginform_row">
      <label>密码:</label>
      <input type="password" class="loginform_input" id="password" name="password" />
    </div>
    <div class="loginform_row">
      <input type="submit" class="loginform_submit" value="登录"/>
    </div>
    <div class="clear"></div>
  </div>
    </form>
</div>
</body>
</html>
