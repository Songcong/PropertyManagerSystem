<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.userid,.tag,.telnumber,.realname,.email,.address,.sex{
			display: none;		
		}
	</style>
  </head>
  	
  <body>
    ${message}
  	<form action="loginAction!login" method="post">
  	<label for="userinfo.username" >用户名:</label>
  	<input type="text" name="userinfo.username" />
  	<label for="userinfo.password">密码:</label>
  	<input type="text" name="userinfo.password" />
  	<input type="submit" value="提交"/>
  	<!-- <a href="<s:url action="userinfoAssign!register"/>"><input type="button"  value="注册"></a> -->
  	</form>
  </body>
</html>