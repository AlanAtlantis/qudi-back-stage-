<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<base href="<%=basePath%>">
<title>北京玖远趣点</title>
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
	href="${pageContext.request.contextPath}/css/pages/register.css">
</head>

<body>

	<!--====================================================
                         MAIN NAVBAR
======================================================-->
	<header class="header">
		<nav class="navbar navbar-expand-lg ">
			<div class="search-box">
				<button class="dismiss">
					<i class="icon-close"></i>
				</button>
				<form id="searchForm" action="#" role="search">
					<input type="search" placeholder="Search Now" class="form-control">
				</form>
			</div>
			<div class="container-fluid ">
				<div
					class="navbar-holder d-flex align-items-center justify-content-between">
					<div class="navbar-header">
						<a href="index.html" class="navbar-brand">
							<div class="brand-text brand-big hidden-lg-down">玖远趣点</div>
							<div class="brand-text brand-small">
								<img src="img/logo-icon.png" alt="Logo" class="img-fluid">
							</div>
						</a> <a id="toggle-btn" href="#" class="menu-btn active"> <span></span>
							<span></span> <span></span>
						</a>
					</div>
				</div>
				<ul
					class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">

					<li class="nav-item dropdown"><a id="profile"
						class="nav-link logout" data-target="#" href="#"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img
							src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"
							style="height: 30px; width: 30px;"></a>
						<ul aria-labelledby="profile" class="dropdown-menu profile">
							<li><a rel="nofollow" href="#" class="dropdown-item d-flex">

									<div class="msg-body">
										<h3 class="h5">Steena Ben</h3>
										<span>steenaben@Businessbox.com</span>
									</div>
							</a>
								<hr></li>
							<li><a rel="nofollow" href="profile.html"
								class="dropdown-item">
									<div class="notification">
										<div class="notification-content">
											<i class="fa fa-user "></i>My Profile
										</div>
									</div>
							</a></li>
							<li><a rel="nofollow" href="profile.html"
								class="dropdown-item">
									<div class="notification">
										<div class="notification-content">
											<i class="fa fa-envelope-o"></i>Inbox
										</div>
									</div>
							</a></li>
							<li><a rel="nofollow" href="profile.html"
								class="dropdown-item">
									<div class="notification">
										<div class="notification-content">
											<i class="fa fa-cog"></i>Setting
										</div>
									</div>
							</a>
								<hr></li>
							<li><a rel="nofollow" href="profile.html"
								class="dropdown-item">
									<div class="notification">
										<div class="notification-content">
											<i class="fa fa-power-off"></i>Logout
										</div>
									</div>
							</a></li>
						</ul></li>
					<li class="nav-item d-flex align-items-center"><a
						id="menu-toggle-right" class="nav-link" href="#"><i
							class="fa fa-bars"></i></a></li>
					<nav id="sidebar-wrapper">
						<div class="sidebar-nav">
							<div class="tab" role="tabpanel">
								<ul class="nav nav-tabs" role="tablist">
									<li class="nav-item "><a class="nav-link active"
										href="#live" role="tab" data-toggle="tab"><i
											class="fa fa-globe"></i> Live</a></li>
									<li class="nav-item"><a class="nav-link" href="#trend"
										role="tab" data-toggle="tab"><i class="fa fa-rocket"></i>
											Trending</a></li>
								</ul>
								<div class="tab-content tabs">
									<div role="tabpanel" class="tab-pane fade show active"
										id="live">
										<h3>Connect Live</h3>
										<div class="content newsf-list">
											<ul class="list-unstyled">
												<li class="border border-primary"><a rel="nofollow "
													href="#" class=" d-flex">
														<div class="news-f-img">
															<img src="img/avatar-2.jpg" alt="..."
																class="img-fluid rounded-circle">
														</div>
														<div class="msg-body">
															<h6 class="h5 msg-nav-h6">New Innovation world</h6>
															<small>Tech soft is great innovation for...</small>
														</div>
												</a></li>
												<li class="border border-success"><a rel="nofollow"
													href="#" class=" d-flex">
														<div class="news-f-img">
															<img src="img/avatar-3.jpg" alt="..."
																class="img-fluid rounded-circle">
														</div>
														<div class="msg-body">
															<h6 class="h5 msg-nav-h6">Modified hand-cart</h6>
															<small>The idea is to incorporate easy...</small>
														</div>
												</a></li>
												<li class="border border-info"><a rel="nofollow"
													href="#" class=" d-flex">
														<div class="news-f-img">
															<img src="img/avatar-4.jpg" alt="..."
																class="img-fluid rounded-circle">
														</div>
														<div class="msg-body">
															<h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
															<small>A dot matrix printer modified at...</small>
														</div>
												</a></li>
												<li class="border border-primary"><a rel="nofollow"
													href="#" class=" d-flex">
														<div class="news-f-img">
															<img src="img/avatar-1.jpg" alt="..."
																class="img-fluid rounded-circle">
														</div>
														<div class="msg-body">
															<h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
															<small>A dot matrix printer modified at...</small>
														</div>
												</a></li>
												<li class="border border-success"><a rel="nofollow"
													href="#" class=" d-flex">
														<div class="news-f-img">
															<img src="img/avatar-2.jpg" alt="..."
																class="img-fluid rounded-circle">
														</div>
														<div class="msg-body">
															<h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
															<small>A dot matrix printer modified at...</small>
														</div>
												</a></li>
												<li class="border border-info"><a rel="nofollow"
													href="#" class=" d-flex">
														<div class="news-f-img">
															<img src="img/avatar-3.jpg" alt="..."
																class="img-fluid rounded-circle">
														</div>
														<div class="msg-body">
															<h6 class="h5 msg-nav-h6">Low cost Modern printer</h6>
															<small>A dot matrix printer modified at...</small>
														</div>
												</a></li>
											</ul>
										</div>
									</div>
									<div role="tabpanel" class="tab-pane fade" id="trend">
										<div class="card card-c2" style="box-shadow: 0 0 0;">
											<div class="header">
												<h3 class="title">Trending Items</h3>
												<p class="category">Last Campaign Performance</p>
											</div>
											<div class="content">
												<canvas class="ct-chart" id="myChart-nav" height="250"></canvas>
												<div class="footer">
													<div class="legend">
														<i class="fa fa-circle text-info"></i> Open <i
															class="fa fa-circle text-danger"></i> Bounce <i
															class="fa fa-circle text-warning"></i> Unsubscribe
													</div>
													<hr>
													<div class="stats">
														<i class="fa fa-clock-o"></i> Campaign sent 2 days ago
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
					</nav>
				</ul>
			</div>
		</nav>
	</header>

	<!--====================================================
                        PAGE CONTENT
======================================================-->
	<div class="page-content d-flex align-items-stretch">

		<!--***** SIDE NAVBAR *****-->
		<nav class="side-navbar">
			<div class="sidebar-header d-flex align-items-center">

				<div class="title">
					<h1 class="h4">${sysLogin.username }</h1>
				</div>
			</div>
			<hr>

			<jsp:include page="include/left_nav.jsp"></jsp:include>
			<span class="heading">Extras</span>
			<ul class="list-unstyled">
				<li><a href="#"> <i class="icon-picture"></i>Demo
				</a></li>
			</ul>
		</nav>

		<div class="content-inner chart-cont">

			<!--***** CONTENT *****-->



			<div class="row">

				<!--***** USER INFO *****-->
				<div class="col-md-12">
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>
								<i class="fa fa-user-circle"></i> 上传商品
							</h3>
						</div>
						<br>
						<form action="sys/goodsCategory/addPage" id="add1"
							onsubmit="return confirm();">
							<div class="row" id="goodsInfo">
								<div class="col-md-6">
									<div class="form-group">
										<label for="name">请选择上传商品类型</label> <select
											class="form-control" id="categoryId" name="categoryId">

											<c:forEach var="item" items="${object.object}">
												<option value="${item.categoryId}">${item.categoryName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="name">请选择商品上传的店铺</label> <select
											class="form-control" id="shopId" name="shopId">

											<c:forEach var="item" items="${shop.object}">
												<option value="${item.shopId}">${item.shopName}</option>
											</c:forEach>
										</select>
									</div>

								</div>

							</div>


							<button type="submit" class="btn btn-general btn-blue mr-2"
								id="but">确定</button>
							<button type="reset" class="btn btn-general btn-white">取消</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!--Global Javascript -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/tether.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/front.js"></script>
	<script src="${pageContext.request.contextPath}/js/front.js"></script>
	<script src="${pageContext.request.contextPath}/js/add.js"></script>




	<!--Core Javascript -->
	<script>
		new Chart(document.getElementById("myChart-nav").getContext('2d'), {
			type : 'doughnut',
			data : {
				labels : [ "M", "T", "W", "T", "F", "S", "S" ],
				datasets : [ {
					backgroundColor : [ "#2ecc71", "#3498db", "#95a5a6",
							"#9b59b6", "#f1c40f", "#e74c3c", "#34495e" ],
					data : [ 12, 19, 3, 17, 28, 24, 7 ]
				} ]
			},
			options : {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : ''
				}
			}
		});
	</script>
</body>

</html>