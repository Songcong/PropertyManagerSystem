<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		
	-->
<title>物业管理系统后台管理</title>
<link rel="stylesheet" href="css/index.css" type="text/css"
	media="screen" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tendina.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>

</head>
<body>

	<div class="layout_top_header">
		<div style="float: left">
			<span
				style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">物业管理系统后台</span>
		</div>
		<div id="ad_setting" class="ad_setting">
			<a class="ad_setting_a" href="javascript:; "> <i
				class="icon-user glyph-icon" style="font-size: 20px"></i> <span>管理员</span>
				<i class="icon-chevron-down glyph-icon"></i>
			</a>
			<ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
				
				
				<li class="ad_setting_ul_li"><i class="icon-user glyph-icon"></i>
					<a href="userinfoAssign!edit?userid=<%= session.getAttribute("userid") %>" target="menuFrame">个人中心 </a></li>
				<li class="ad_setting_ul_li"><a href="javascript:;"><i
						class="icon-cog glyph-icon"></i> 设置 </a></li>
				<li class="ad_setting_ul_li"><i class="icon-signout glyph-icon"></i><span
					class="font-bold"> <a href="loginAction!logout">退出</a></span></li>
			</ul>
		</div>
	</div>


	<div class="layout_left_menu">
		<ul id="menu">
			<li class="childUlLi"><a href="main.html" target="menuFrame"><i
					class="glyph-icon icon-home"></i>小区成员管理</a>
				<ul>
					<li><a href="userinfoAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>管理员管理</a></li>
					<li><a href="staffinfoAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>职员管理</a></li>
					<li><a href="occupationAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>职位管理</a></li>
				</ul></li>
			<li class="childUlLi"><a href="user.html" target="menuFrame">
					<i class="glyph-icon icon-reorder"></i>小区收费管理
			</a>
				<ul>
					<li><a href="expensetypeAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>收费种类管理</a></li>
					<li><a href="expdetailAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>收费明细管理</a></li>
					<li><a href="carAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>车辆登记管理</a></li>
					<li><a href="carmanageAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>停车管理</a></li>
					<li><a href="stallAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>车位管理</a></li>
				</ul></li>
			<li class="childUlLi"><a href="role.html" target="menuFrame">
					<i class="glyph-icon icon-reorder"></i>小区岗位管理
			</a>
				<ul>
					<li><a href="jobtypeAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>岗位类型管理</a></li>
				</ul></li>
			<li class="childUlLi"><a href="#"> <i
					class="glyph-icon icon-reorder"></i>小区公用设备管理
			</a>
				<ul>
					<li><a href="publicUtilityManageAssign!list"
						target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>公共设备管理</a></li>
					<li><a href="utilityDetailAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>设备详细信息管理</a></li>
					<li><a href="utilityDamageAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>公用设备损坏管理</a></li>
				</ul></li>
			<li class="childUlLi"><a href="role.html" target="menuFrame">
					<i class="glyph-icon icon-reorder"></i>小区物业业绩管理
			</a>
				<ul>
					<li><a href="trackRecordAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>业绩管理</a></li>
				</ul></li>

			<li class="childUlLi"><a href="#"> <i
					class="glyph-icon icon-reorder"></i>小区房屋管理
			</a>
				<ul>
					<li><a href="houseManageAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>房屋管理</a></li>
					<li><a href="houseOwnerManageAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>房屋业主管理</a></li>

				</ul></li>
			<li class="childUlLi"><a href="#"> <i
					class="glyph-icon icon-reorder"></i>小区其他管理
			</a>
				<ul>
					<li><a href="foreignManageAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>外来人口管理</a></li>
					<li><a href="fitmentAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>房屋装修管理</a></li>
					<li><a href="serviceAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>物业维修管理</a></li>
					<li><a href="chartAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>与业主交谈管理</a></li>
					<li><a href="offorestAssign!list" target="menuFrame"><i
							class="glyph-icon icon-chevron-right"></i>小区绿化管理</a></li>
				</ul></li>

		</ul>
	</div>
	<!--菜单-->
	<div id="layout_right_content" class="layout_right_content">

		<div class="route_bg">
			<a href="#">主页</a><i class="glyph-icon icon-chevron-right"></i> <a
				href="#">菜单管理</a>
		</div>
		<div class="mian_content">
			<div id="page_content">
				<iframe id="menuFrame" name="menuFrame" src="main.html"
					style="overflow:visible;" scrolling="yes" frameborder="no"
					width="100%" height="100%"></iframe>
			</div>
		</div>
	</div>
	<div class="layout_footer">
		<p>Copyright © 2015 - 济南大学计卓1201</p>
	</div>
	<script type="text/javascript">
	   $(document).ready(function(){
	   		if(<%=session.getAttribute("username") %>==null){
	   			window.location.href="login.jsp"
	   		}
	   		
	   })
	</script>
</body>
</html>
