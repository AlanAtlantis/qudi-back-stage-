$(document)
		.ready(
				function() {
					$
							.ajax({
								type : "GET",
								dataType : "json",
								url : "/commodity/queryUserCommodtiyList",
								success : function(data) {
									console.log(data);
									if (data.result == "SUCCEED") {

										console.log(data.object);
										console.log(data.object.length);
										if (data.object != null) {
											var o = 0;
											for ( var i in data.object) {

												var colors = [ "table-warning",
														"table-success",
														"table-danger",
														"table-info" ];

												color = "";

												console.log("colors:"
														+ colors.length);

												for (var num = 0; num < colors.length; num++) {
													console.log(i % 2);
													if (i % 2 != 0) {
														color = "class='"
																+ colors[o]
																+ "'";
														if (o == colors.length) {
															o = 0;
														} else {
															o++;
														}
													}
												}
												console.log("color:" + color);
												str = "<tr "
														+ color
														+ "><th scope='row'>"
														+ data.object[i].id
														+ "</th><td>"
														+ data.object[i].name
														+ "</td><td>"
														+ data.object[i].describe
														+ "</td><td><button type='button' class='btn btn-primary btn-sm' onclick='update("
														+ data.object[i].id
														+ ")'>修改</button>"
														+ "<button type='button' class='btn btn-warning btn-sm' onclick='deletes("
														+ data.object[i].id
														+ ")'>删除</button><button type='button' class='btn btn-info btn-sm' onclick='commodity("
														+ data.object[i].id
														+ ")'>详情</button></td>";

												$("tbody").append(str);
											}
										}

									} else {
										toastr.error(data.info);
									}
								}
							})
				});

function commodity(id) {

	$.ajax({
		type : "GET",
		dataType : "json",
		url : "/commodity/queryCommodity?id=" + id,
		success : function(data) {
			if (data.result == "SUCCEED") {
				console.log(data);

			} else {
				toastr.error(data.info);
			}
		}
	})
}

function insert(id) {
	
	var data
	$.ajax({
		type : "GET",
		dataType : "json",
		data : data,
		url : "/commodity/insertCommodity",
		success : function(data) {
			if (data.result == "SUCCEED") {
				console.log(data);

			} else {
				toastr.error(data.info);
			}
		}
	})
}

function update(id) {
	
	window.location.href = "/page/update.html?id=" + id;
}