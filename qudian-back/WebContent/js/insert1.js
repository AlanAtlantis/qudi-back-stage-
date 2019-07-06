$(document).ready(
		function() {

			$.ajax({
				type : "GET",
				dataType : "json",
				url : "/goodsCategory/selectGoodsCategory",
				success : function(data) {
					if (data.result == "SUCCEED") {
						console.log(data);
						if (data.object != null) {
							for ( var i in data.object) {
								$("#exampleSelect1").append(
										"<option value='id="
												+ data.object[i].categoryId
												+ "&categoryLevel="
												+ data.object[i].categoryLevel
												+ "'>"
												+ data.object[i].categoryName
												+ "</option>");
							}

						}

					} else {
						toastr.error(data.info);
					}
				}
			})

		})

$("#but").click(function() {
	/*
	 * // 获取地址栏参数id var id = new RegExp("(^|&)id=([^&]*)(&|$)"); var r =
	 * window.location.search.substr(1).match(id); console.log(unescape(r[2]));
	 * 
	 * var categoryLevel = new RegExp("(^|&)categoryLevel=([^&]*)(&|$)"); var rs =
	 * window.location.search.substr(1).match(categoryLevel);
	 * console.log(unescape(rs[2]));
	 */

	var str = $("#exampleSelect1").val();

	if (str.length > 0) {

		window.location.href = "/view/insert.html?" + str;
	}

})