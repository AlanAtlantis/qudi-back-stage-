<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<base href="<%=basePath%>">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">

<title>北京玖远趣点登录</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
<link href="${pageContext.request.contextPath}/css/toastr.css" rel="stylesheet" />
<!-- global stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-icon-style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css"
	id="theme-stylesheet">

<!-- Core stylesheets -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages/login.css">
<!-- CSS -->
</head>

<body>

	<section class="hero-area">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 ">
					<div class="contact-h-cont">
						<h3 class="text-center">
							玖远趣点后台登录
						</h3>
						<br>
						 <form action="sys/sysuser/login_sysuser" method="get"> 
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" id="username" placeholder="Enter Username" name="username">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password</label> <input
								class="form-control" type="password"
								placeholder="Enter Password" id="example-password-input" name="password">
						</div>
						<button class="btn btn-general btn-blue login" role="button">
						Login
						</button>
					</form> 
				<span style="float:right;margin-top:-30px; " ><a href="#">注册</a></span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!--Global Javascript -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/tether.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
</body>

</html>