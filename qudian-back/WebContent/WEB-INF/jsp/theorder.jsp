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
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<title>北京玖远趣点</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">

<!-- global stylesheets -->

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
					</div>
				</div>
				<ul
					class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
					<!-- Expand-->

					<li class="nav-item dropdown">
						<ul aria-labelledby="notifications" class="dropdown-menu">

							<li><a rel="nofollow" href="#"
								class="dropdown-item nav-link">
									<div class="notification">
										<div class="notification-content">
											<i class="fa fa-upload bg-blue"></i>Server Rebooted
										</div>
										<div class="notification-time">
											<small>4 minutes ago</small>
										</div>
									</div>
							</a></li>
							<li><a rel="nofollow" href="#"
								class="dropdown-item nav-link">
									<div class="notification">
										<div class="notification-content">
											<i class="fa fa-twitter bg-skyblue"></i>You have 2 followers
										</div>
										<div class="notification-time">
											<small>10 minutes ago</small>
										</div>
									</div>
							</a></li>
							<li><a rel="nofollow" href="#"
								class="dropdown-item all-notifications text-center"> <strong>view
										all notifications </strong></a></li>
						</ul>
					</li>
					<!-- Messages                        -->
					<li class="nav-item dropdown">
						<ul aria-labelledby="messages" class="dropdown-menu">

							<li><a rel="nofollow" href="#" class="dropdown-item d-flex">
									<div class="msg-profile">
										<img src="img/avatar-3.jpg" alt="..."
											class="img-fluid rounded-circle">
									</div>
									<div class="msg-body">
										<h3 class="h5 msg-nav-h3">Ashley Wood</h3>
										<span>Sent You Message</span>
									</div>
							</a></li>
							<li><a rel="nofollow" href="#"
								class="dropdown-item all-notifications text-center"> <strong>Read
										all messages </strong></a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
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
						</ul>
					</li>

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

	<div class="page-content d-flex align-items-stretch">

		<!--***** SIDE NAVBAR *****-->
		<nav class="side-navbar">
			<div class="sidebar-header d-flex align-items-center">

				<div class="title">
					<h1 class="h4">${sysLogin.username }</h1>
				</div>
			</div>
			<hr>
			<span class="heading">Extras</span>
		<jsp:include page="include/left_nav.jsp"></jsp:include>
			<!-- <ul class="list-unstyled">
				<li><a href="sys/sysuser/theorder_jump"> <i class="icon-picture"></i>订单
				</a></li>
			</ul> -->
		</nav>

		<div class="content-inner chart-cont">

			<!--***** CONTENT *****-->



			<div class="row">

				<!--***** USER INFO *****-->
				<div class="col-md-12">
						<div class="card-header">
							<h3>
								<i class="fa fa-user-circle"></i> 订单
							</h3>	
							<br/>
							<form action="sys/sysuser/thequery_theorder" method="get">
							<input type="hidden" name="userid" id="userid" value="${userid}">
							
							    <div class="form-group">
                                        <input type="text" name="orderid" class="form-control" id="orderid"  placeholder="订单号" style="width:300px;">
                                  </div>
						         <button type="submit" class="btn btn-general btn-blue mr-2"
								id="but" style="position:absolute;right:650px;top:55px;">查询</button> 
						</form>
						</div>

					 <table class="table table-hover">
                  <thead>
                    <tr class="bg-info text-white">
                      <th>订单号</th>
                       <th>商品个数</th>
                      <th>价格</th>
                      <th>下单时间</th>
                      <th>支付方式</th>
                      <th>支付转态</th>
                      <th>支付时间</th>
                      <th>回调订单号</th>                     
                      <th>发货时间</th>
                      <th>备注</th>
                    </tr>
                  </thead>
                  <c:forEach items="${list}" var="list">
                  <tbody>
                    <tr>
                      <th scope="row"><c:out value="${list.orderid }"></c:out></th>
                      <td><c:out value="${list.num }"></c:out></td>
                      <td><c:out value="${list.pay_price }"></c:out></td>
                      <td><c:out value="${list.ordertime }"></c:out></td>
                       <td>
                       <c:choose>
                       <c:when test="${list.pay_type eq  '0' }"> 銀行卡  </c:when>
                       <c:when test="${ list.pay_type eq  '1'}">  微信 </c:when>
                        <c:otherwise> 支付寶</c:otherwise>
                       </c:choose>
                       </td>
                       <td>
                        <c:choose>
                       <c:when test="${list.status eq  '1' }"> 待支付  </c:when>
                        <c:otherwise> 已支付</c:otherwise>
                       </c:choose>
                       </td>
                       <td><c:out value="${list.paytime }"></c:out></td>
                       <td><c:out value="${list.back_order }"></c:out></td>
                      <td><c:out value="${list.delivertime }"></c:out></td>
                      <td><c:out value="${list.remarks}"></c:out></td>
                    </tr>
                  </tbody></c:forEach>
                </table>
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
	<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>

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