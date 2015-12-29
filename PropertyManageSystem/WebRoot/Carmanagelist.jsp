<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Carmanagelist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/js/jquery-1.11.3.mim.js" />
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/js/jquery.min.js" />
	
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/list.css">
	<link rel="stylesheet" href="css/responsive-tables.min.css" type="text/css">
	
	<script type="text/javascript" src="js/jquery-1.11.0.min.js" ></script>
	
  </head>
  
  <body>
  <script type="text/javascript" src="js/Prop.js"></script>
    <a href="carmanageAssign!add">增加</a>
    ${cvm.list}
  </body>
</html>
