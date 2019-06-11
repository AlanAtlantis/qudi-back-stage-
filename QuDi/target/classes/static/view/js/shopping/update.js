$(document)
		.ready(
				function() {
					// 获取地址栏参数id
					var reg = new RegExp("(^|&)id=([^&]*)(&|$)");
					var r = window.location.search.substr(1).match(reg);

					console.log(unescape(r[2]));

					var url = "/commodity/queryCommodity?id=" + unescape(r[2]);
					console.log(url);

					$
							.ajax({
								type : "GET",
								dataType : "json",
								url : "/commodity/queryCommodity?id="
										+ unescape(r[2]),
								success : function(data) {
									if (data.result == "SUCCEED") {
										console.log(data);

										$("#shoppingName")
												.val(data.object.name);
										$("#quantity")
												.val(data.object.quantity);
										$("#exampleTextarea").val(
												data.object.describe);

										if (data.object.price != null) {
											for ( var i in data.object.price) {
												var str = "<tr><td>"
														+ data.object.price[i].id
														+ "</td><td>"
														+ data.object.price[i].sectionMax
														+ "</td><td>"
														+ data.object.price[i].sectionMin
														+ "</td><td>"
														+ data.object.price[i].price
														+ "</td><td><button type='button' class='btn btn-warning btn-sm' onclick='deletesPr("
														+ data.object.price[i].id
														+ ")'>删除</button></td></tr>";
												$("#price").append(str);
											}
										}

										if (data.object.specifications != null) {
											for ( var i in data.object.specifications) {
												var str = "<tr><td>"
														+ data.object.specifications[i].id
														+ "</td><td>"
														+ data.object.specifications[i].color
														+ "</td><td>"
														+ data.object.specifications[i].model
														+ "</td><td>"
														+ data.object.specifications[i].picture
														+ "</td><td><button type='button' class='btn btn-warning btn-sm' onclick='deletesSp("
														+ data.object.specifications[i].id
														+ ")'>删除</button></td></tr>";
												$("#specifications")
														.append(str);
											}
										}

									} else {
										toastr.error(data.info);
									}
								}
							})
				})

// 删除价格
function deletesPr(id) {
	if (confirm("确定要删除？")) {
		$.ajax({
			type : "GET",
			dataType : "json",
			url : "/commodity/deletePrice?id=" + id,
			success : function(data) {
				if (data.result = "SUCCEED") {
					toastr.success(data.info);
				} else {
					toastr.error(data.info);
				}
			}
		})

	}
}

// 删除商品规格
function deletesSp(id) {
	if (confirm("确定要删除？")) {
		$.ajax({
			type : "GET",
			dataType : "json",
			url : "/commodity/deleteSpecifications?id=" + id,
			success : function(data) {
				if (data.result = "SUCCEED") {
					toastr.success(data.info);
				} else {
					toastr.error(data.info);
				}
			}
		})

	}
}

function update(){
	
}