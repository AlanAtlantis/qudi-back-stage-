$(document).ready(function() {

	$.ajax({
		type : "GET",
		dataType : "json",
		url : "/goodsCategory/selectGoodsCategory",
		success : function(data) {
			if (data.result == "SUCCEED") {
				console.log(data);

			} else {
				toastr.error(data.info);
			}
		}
	})

})