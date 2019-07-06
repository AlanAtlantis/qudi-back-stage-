function confirm() {
	var falg = categoryId();

	
	return falg;
}

function categoryId() {
	var exampleSelect1 = $("#categoryId").val();
	
	if (exampleSelect1.length > 0) {
		$("#info-qudi").remove();

		$(".form-group")
				.appendChild(
						"<div class='alert alert-warning' id='info-qudi'>警告！请选择商品类型</div>");
		return false;
	}
	return true;
}