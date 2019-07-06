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
%><base href="<%=basePath%>">
<head>
<meta charset="UTF-8">
<title>上传商品图片 </title>

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
<link href="${pageContext.request.contextPath}/css/toastr.css"
	rel="stylesheet" />
<style>
.main {
	width: 80%;
	margin: auto;
}

* {
	padding: 0;
	margin: 0;
}

.btn {
	padding: 9px 18px;
	background: #40AFFE;
	color: #FFFFFF;
	border-radius: 5px;
}

.upimg {
	position: relative;
	width: 100px;
	height: 100px;
	border-radius: 5px;
	border: dashed #999999;
	background: url(img/addimg.svg) no-repeat;
	background-position: 33px;
}

.upimg input {
	position: absolute;
	width: 100px;
	height: 100px;
	opacity: 0;
}

#showui {
	display: flex;
	justify-content: flex-start;
}

#showui li {
	width: 150px;
	height: 150px;
	position: relative;
	overflow: hidden;
	display: inline-block;
	margin-right: 5px;
}

#showui li img.showimg {
	position: absolute;
	text-align: center;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 6;
}

.showdiv {
	position: absolute;
	z-index: 9;
	bottom: 0;
	width: calc(100% - 20px);
	padding: 10px;
	display: flex;
	justify-content: space-around;
	background: rgba(0, 0, 0, .6);
}

.showdiv img {
	width: 20px;
	height: 20px;
	cursor: pointer;
}

#showui li:first-child img.left {
	opacity: .6;
	cursor: no-drop;
}

#showui li:last-child img.right {
	opacity: .6;
	cursor: no-drop;
}

.oneright {
	opacity: .6;
	cursor: no-drop !important;
}
</style>
</head>

<body>






















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
							<div class="brand-text brand-big hidden-lg-down">
								玖远趣点
								<!-- <img src="img/logo-white.png" alt="Logo" class="img-fluid"> -->
							</div>
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
					<!-- Expand-->
					<!-- <li class="nav-item d-flex align-items-center full_scr_exp"><a
						class="nav-link" href="#"><img src="img/expand.png"
							onclick="toggleFullScreen(document.body)" class="img-fluid"
							alt=""></a></li> -->
					<!-- Search-->
					<!-- <li class="nav-item d-flex align-items-center"><a id="search"
						class="nav-link" href="#"><i class="icon-search"></i></a></li> -->
					<!-- Notifications-->
					<!-- <li class="nav-item dropdown"><a id="notifications"
						class="nav-link" rel="nofollow" data-target="#" href="#"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
							class="fa fa-bell-o"></i><span class="noti-numb-bg"></span><span
							class="badge">12</span></a>
						<ul aria-labelledby="notifications" class="dropdown-menu">
							<li><a rel="nofollow" href="#"
								class="dropdown-item nav-link">
									<div class="notification">
										<div class="notification-content">
											<i class="fa fa-envelope bg-red"></i>You have 6 new messages
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
											<small>4 minutes ago</small>
										</div>
									</div>
							</a></li>
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
						</ul></li> -->
					<!-- Messages                        -->
				<!-- 	<li class="nav-item dropdown"><a id="messages"
						class="nav-link logout" rel="nofollow" data-target="#" href="#"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
							class="fa fa-envelope-o"></i><span class="noti-numb-bg"></span><span
							class="badge">10</span></a>
						<ul aria-labelledby="messages" class="dropdown-menu">
							<li><a rel="nofollow" href="#" class="dropdown-item d-flex">
									<div class="msg-profile">
										<img src="img/avatar-1.jpg" alt="..."
											class="img-fluid rounded-circle">
									</div>
									<div class="msg-body">
										<h3 class="h5 msg-nav-h3">Jason Doe</h3>
										<span>Sent You Message</span>
									</div>
							</a></li>
							<li><a rel="nofollow" href="#" class="dropdown-item d-flex">
									<div class="msg-profile">
										<img src="img/avatar-2.jpg" alt="..."
											class="img-fluid rounded-circle">
									</div>
									<div class="msg-body">
										<h3 class="h5 msg-nav-h3">Frank Williams</h3>
										<span>Sent You Message</span>
									</div>
							</a></li>
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
						</ul></li> -->
					<li class="nav-item dropdown"><a id="profile"
						class="nav-link logout" data-target="#" href="#"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img
							src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"
							style="height: 30px; width: 30px;"></a>
						<ul aria-labelledby="profile" class="dropdown-menu profile">
							<li><a rel="nofollow" href="#" class="dropdown-item d-flex">
									<!-- <div class="msg-profile">
										<img src="img/avatar-1.jpg" alt="..."
											class="img-fluid rounded-circle">
									</div> -->
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
				<!-- <div class="avatar">
					<img src="img/avatar-1.jpg" alt="..."
						class="img-fluid rounded-circle">
				</div> -->
				<div class="title">
					<h1 class="h4">${sysLogin.username }</h1>
				</div>
			</div>
			<hr>


			<!-- Sidebar Navidation Menus-->
			<!-- <ul class="list-unstyled">

				<li class="active"><a href="index.html"><i
						class="icon-home"></i>Home</a></li>
				<li><a href="#apps" aria-expanded="false"
					data-toggle="collapse"> <i class="icon-interface-windows"></i>商品管理
				</a>
					<ul id="apps" class="collapse list-unstyled">
						<li><a href="sys/goodsList/tables">商品例表</a></li>
						<li><a href="sys/goodsCategory/selectGoodsCategory">商品添加</a></li>
						<li><a href="media.html">Media</a></li>
						<li><a href="invoice.html">Invoice</a></li>
					</ul></li>
			</ul> -->

			<jsp:include page="include/left_nav.jsp"></jsp:include>



		</nav>

		<div class="content-inner chart-cont">

			<!--***** CONTENT *****-->
			<div class="row">




				<div class="col-md-12">
					<div class="card form" id="form1">
						<div class="card-header">
							<h3>
								<i class="fa fa-user-circle"></i> 上传商品图片
							</h3>
						</div>
						<br>

						<div class="row">

							<table class="table table-hover">
								<thead>
									<tr class="bg-info text-white">
										<th>#</th>
										<th>图片</th>
										<th>是否为主图</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${ goodsImg.object}" varStatus="idx">
										<tr class="bg-info text-white">
											<td><%-- ${item.picId } --%>${idx.index }</td>
											<td><img alt="img" src="${item.picUrl }"></td>
											<td><c:choose>
													<c:when test="${item.isMain==1 }">是</c:when>
													<c:otherwise>否</c:otherwise>
												</c:choose></td>
											<td>

												<form action="sys/goodsImg/updateImg">
													<input type="hidden" value="${item.picId}" name="picId">
													<input type="hidden" value="${item.goodsId}" name="goodsId">
													<button type="button" onclick="update(${item.picId})"
														class="btn btn-info btn-xs">修改</button>
												</form>
												<form action="sys/goodsImg/deleteImg">
													<input type="hidden" value="${item.picId}" name="picId">
													<input type="hidden" value="${item.goodsId}" name="goodsId">
													<button type="submit" class="btn btn-info btn-xs">删除</button>
												</form>

											</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>

						<form action="sys/photoUpload" method="post"
							enctype="multipart/form-data">
							<input type="hidden" value="1" name="picId"> <input
								type="hidden" value="1" name="action"><input
								type="hidden" value="0" name="isMain"> <input
								type="hidden" name="goodsId" value="${goodsId }">
							<div class="row" id="goodsInfo">
								<div class="col-md-6">
									<div class="form-group"></div>
									<div class="form-group">
										<label for="name">商品图片上传</label>
										<div>
											<input type="file" name="file" value="选择图片"> </input>
										</div>
									</div>

								</div>

							</div>


							<button type="submit" class="btn btn-general btn-blue mr-2"
								id="but">Submit</button>
							<button type="reset" class="btn btn-general btn-white">Cancel</button>
						</form>
					</div>
				</div>




			</div>

		</div>
	</div>




	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<form action="sys/photoUpload" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="goodsId" value="${goodsId }"> <input
					type="hidden" value="2" name="action"> <input type="hidden"
					value="" name="picId" id="picId">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改</h4>
					</div>

					<div class="modal-body">

						<div class="form-group">
							<label for="txt_departmentname">选择图片</label> <input type="file"
								name="file">
						</div>
						<div class="form-group">
							<label for="txt_parentdepartment">是否为主图</label> <input
								type="radio" name="isMain" value="0" checked="checked">否
							<input type="radio" name="isMain" value="1">是
						</div>

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
						</button>
						<!-- <button type="submit" class="btn btn-primary"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
						</button> -->
						<button type="submit" class="btn btn-general btn-blue mr-2"
							id="but">Submit</button>
					</div>
				</div>
			</form>
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


	<script type="text/javascript">
		$("#btn_add").click(function() {

			$("#myModalLabel").text("新增");

			$('#myModal').modal();

		});

		function update(id) {
			$("#picId").val(id);
			$('#myModal').modal();
		}
	</script>

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

	<script type="text/javascript">
		Ext
				.onReady(function() {
					Ext
							.create(
									'Ext.form.Panel',
									{
										title : '图片上传',
										width : 600,
										bodyPadding : 10,
										frame : true,
										renderTo : Ext.getBody(),
										items : [ {
											xtype : 'filefield',
											name : 'file',
											fieldLabel : 'Photo',
											labelWidth : 50,
											msgTarget : 'side',
											fileUpload : true,
											allowBlank : false,
											blankText : "Select an image",
											emptyText : 'You can only upload a single PNG 10M or less, JPG, GIF format images',
											anchor : '100%',
											buttonText : '选择图片'
										} ],

										buttons : [ {
											text : '上传',
											handler : function() {
												var form = this.up('form')
														.getForm();
												if (form.isValid()) {
													form
															.submit({
																url : 'sys/photoUpload',
																waitMsg : '正在上传图片...',
																success : function(
																		fp, o) {
																	Ext.Msg
																			.alert(
																					'提示',
																					o.result.msg);
																}
															});
												}
											}
										} ]
									});
				});
	</script>


</body>

</html>