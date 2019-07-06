<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" isErrorPage="true"
errorPage="WEB-INF/jsp/error/error.jsp"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">

<title>Bootstrap Admin Template</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">

<!-- global stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-icon-style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.default.css"
	id="theme-stylesheet">

<!-- Core stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pages/404.css">
</head>

<body>

	<!--====================================================
                        PAGE CONTENT
======================================================-->
	<section class="hero-area">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 ">
					<div class="block text-center">
						<h1 class="animated wow fadeInLeft" data-wow-delay="0.3s"
							data-wow-duration=".2s">error!</h1>
						<p class="animated wow fadeInRight" data-wow-delay="0.5s"
							data-wow-duration=".5s">Oops! something wrong.</p>
						<div class="animated wow fadeInUp text-center"
							data-wow-delay="0.7s" data-wow-duration=".7s">
							<span> <a class="btn btn-general btn-blue" href="/qudian-back"
								role="button">Go to Home</a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!--Global Javascript -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/tether.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>

</html>