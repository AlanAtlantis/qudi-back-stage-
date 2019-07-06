<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<base href="<%=basePath%>">
<title>北京玖远趣点注册</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link href="${pageContext.request.contextPath}/css/toastr.css"
	rel="stylesheet" />
<!-- global stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-icon-style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.default.css"
	id="theme-stylesheet">

<!-- Core stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pages/login.css">
<!-- CSS -->
</head>
<body>

	<section class="hero-area">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 ">
					<form action="sys/sysuser/register_sysuser" method="get";>

						<div class="contact-h-cont">
							<h3 class="text-center">
								<!-- <img src="img/logo.png" class="img-fluid" alt=""> -->
								玖远趣点后台注册
							</h3>
							<br>
							<div class="form-group">
								<label for="username">Username</label> <input type="text"
									class="form-control" id="username" placeholder="Enter Username"
									name="username">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Password</label> <input
									class="form-control" type="text" placeholder="Enter Password"
									id="example-password-input" name="password">
							</div>

							<div class="form-group">
								<label for="phone">Phone</label> <input class="form-control"
									type="text" placeholder="Enter Phone" id="example-phone-input"
									name="phone" pattern="[0-9]*">
							</div>

							<div class="form-group">
								<label for="email">Email</label> <input class="form-control"
									type="text" placeholder="Enter Email" id="example-email-input"
									name="email">
							</div>

							<button class="btn btn-general btn-blue login" role="button">
								Login</button>
							<br /> <span
								style="display: block; margin-top: 12px; font-size: 7px;">注册即代表您已阅读并同意<a
								href="#">《使用协议》</a></span>
						</div>
					</form>

				</div>
			</div>
		</div>
	</section>

	<!--Global Javascript -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/tether.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/user/login.js"></script>

</body>

</html>