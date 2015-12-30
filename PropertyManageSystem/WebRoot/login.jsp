<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>物业管理系统登录</title>
    
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
	
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <link rel="stylesheet" type="text/css" href="css/body.css"/> 
  </head>
  	
  <body>
   ${message}
<div class="container">
	<section id="content">
		<form action="loginAction!login" method="post">
			<h1>用户登录</h1>
			<div>
				<input type="text" placeholder="用户名" required="" id="username" name="userinfo.username" />
			</div>
			<div>
				<input type="password" placeholder="密码" required="" id="password" name="userinfo.password" />
			</div>
			<div>			
			<span>	<input type="text" placeholder="验证码" required="" id="codeinput" name="code" style="width:60%;" /></span>									
			<span><img id="code" style="height:30px; width:20%;" /></span>    
			<span><a id="check" class="glyphicon glyphicon-remove" ></a>	</span>	
			</div>			
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo"></span>			</div> 
			<div>
				<!-- <input type="submit" value="Log in" /> -->
				<span><input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/></span>
				
				<span><input type="reset" value="取消" class="btn btn-primary" id="js-btn-login"/></span>
				
				<!-- <a href="#">Register</a> -->
			</div>
		</form><!-- form -->
		 <div class="button">			
			<a href="#">忘记密码</a>
		</div> <!-- button -->
	</section><!-- content -->
</div>
<!-- container -->  	
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
