<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
		href="../GLITApp/css/header.css">
		<script type="text/javascript" language="javascript"
		src="../GLITApp/js/bootstrap.js"></script>
		<style type="text/css">
		a:focus {background: #fff;}
		</style>
</head>
<body>
<!--
<div>
<div align="right"><img alt="Logged In User" src="GLITAPP../../img/user.png">Welcome, ${username} 
<br/> <a href="login.spring">Logout</a></div>
</div>
-->
<!--start-header-->
			<div class="header">
				<div class="wrap">
				<!--start-logo-->
				<div class="logo">
					<a href="client.spring"><img src="images/logo.png" title="logo" /></a>
				</div>
				<!--end-logo-->
				<!--start-top-nav-->
				<div class="top-nav">
					<div class="dropdown">
  <a id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#" style="text-decoration: none;">
   <img src="images/user.png" title="logo" /> Welcome , ${username} &nbsp; <span class="caret"></span>
  </a>


  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
  <li>&nbsp;<a href="login.spring">Logout</a></li>
  </ul>
</div>
				</div>
				<div class="clear"> </div>
				<!--end-top-nav-->
			
			</div>
			<!--end-header-->
</body>
</html>