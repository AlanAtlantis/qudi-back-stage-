function deletes(id){
	if(confirm("确定要删除？")){
	$.ajax({
		type : "GET",
		dataType : "json",
		url : "/commodity/deleteCommodity?id="+id,
		success:function(data){
			if(data.result="SUCCEED"){
				toastr.success(data.info);
			}else{
				toastr.error(data.info);
			}
		}
		})
	
	}
}