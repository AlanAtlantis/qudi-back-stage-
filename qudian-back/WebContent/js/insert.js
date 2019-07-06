$(document).ready(function() {

	// // 获取地址栏参数id
	// var id = new RegExp("(^|&)id=([^&]*)(&|$)");
	// var r = window.location.search.substr(1).match(id);
	// console.log(unescape(r[2]));
	// var ids = unescape(r[2]);
	//
	// var categoryLevel = new RegExp(
	// "(^|&)categoryLevel=([^&]*)(&|$)");
	// var rs = window.location.search.substr(1).match(
	// categoryLevel);
	// var categoryLevels = parseInt(unescape(rs[2])) + 1;
	//
	// console.log(unescape(rs[2]));
	//
	// $
	// .ajax({
	// type : "GET",
	// dataType : "json",
	// url : "/goodsCategory/selectGoodsCategoryLevel?id="
	// + ids
	// + "&categoryLevel="
	// + categoryLevels,
	// success : function(data) {
	// console.log(data);
	// if (data.result == "SUCCEED") {
	// console.log(data);
	//
	// if (data.object != null) {
	// for ( var i in data.object) {
	//
	// $("#goods-info")
	// .append(
	// "<div class='form-group'><label for='name'>"
	// + data.object[i].categoryName
	// + "</label> <input type='text'class='form-control' id='name"
	// + i
	// + "' aria-describedby='emailHelp'></div>");
	//
	// }
	// }
	//
	// } else {
	// toastr.error(data.info);
	// }
	// }
	// })

})

$("#but").click(function() {

	var id = new RegExp("(^|&)id=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(id);
	var categoryId = unescape(r[2]);
	var userId = 1;
	var goodsName = $("#goodsName").val();
	var goodsAs = $("#goodsAs").val();
	var goodsLabel = $("#goodsLabel").val();
	var goodsPrice = $("#goodsPrice").val();
	var goodsSource = $("#goodsSource").val();
	var goodsDesc = $("#goodsDesc").val();

	var data = {
		"userId" : userId,
		"categoryId" : categoryId,
		"goodsName" : goodsName,
		"goodsAs" : goodsAs,
		"goodsLabel" : goodsLabel,
		"goodsPrice" : goodsPrice,
		"goodsSource" : goodsSource,
		"goodsDesc" : goodsDesc
	}

	/*
	 * var data = { "goodsId" : 0, "categoryId" : categoryId, "goodsName" :
	 * goodsName, "goodsAs" : goodsAs, "goodsLabel" : goodsLabel, "goodsDesc" :
	 * goodsDesc, "goodsPrice" : goodsPrice, "goodsDiscount" : 0, "goodsSource" :
	 * goodsSource, "userId" : userId, "goodsStatus" : 1, "createTime" : "" }
	 */

	console.log(data);
	$.ajax({
		type : "POST",
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(data),
		url : "/goodsList/add",
		success : function(data) {
			if (data.result == "SUCCEED") {
				console.log(data);

			} else {
				toastr.error(data.info);
			}
		}
	})
})
