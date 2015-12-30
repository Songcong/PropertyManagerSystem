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
	
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/js/jquery-1.11.3.mim.js" />
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/js/jquery.min.js" />
	<script type="text/javascript" src="js/jquery-1.11.0.min.js" ></script>
  </head>
  	
  <body>
    ${message}
  	<form action="loginAction!login" method="post">
  	<label for="userinfo.username" >用户名:</label>
  	<input type="text" name="userinfo.username" />
  	<label for="userinfo.password">密码:</label>
  	<input type="text" name="userinfo.password" />
  	<img id="code" ></img><label for="code">验证码</label><input type="text" name="code" id="codeinput" />
  	<a id="check" class="glyphicon glyphicon-remove"></a>
  	<input type="submit" value="提交"/>
  	<!-- <a href="<s:url action="userinfoAssign!register"/>"><input type="button"  value="注册"></a> -->
  	</form>
  	
  	<script type="text/javascript">
  		function code(){
  			var timenow = new Date().getTime(); 
  			$('img').attr('src','codeAction!code?d='+timenow)
  			}
  		
  		
  		
  		$(document).ready(function(){
  			code();
  			
  			$('#code').click(function(){
  				//alert('test')
  				
  				code();
  				
  			})
  			$('#codeinput').change(function(){
  			
  				var code=$('#codeinput').val()
  				$.post(  
              
                "codeAction!check",        //服务器要接受的url  
                 {"code":code},  //传递的参数       
                  
               function cbf(data){ //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
                  
                   var check=  data.check;
                   if(check=="ok")
                   {
                   		$('#check').removeClass("glyphicon-remove").addClass("glyphicon-ok")
                   }
                   else{
                   		$('#check').removeClass("glyphicon-ok").addClass("glyphicon-remove")
                   }
                }, 'json'); 
  			})
  			
  		})
  		
  	</script>
  </body>
</html>
