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
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>图片上传</legend>
		<h2>只能上传单张10M以下的 PNG、JPG、GIF 格式的图片</h2>
		<form action="sys/photoUpload" method="post"
			enctype="multipart/form-data">
			<input type="text" name="goodsId" value="1"> 选择文件:<input
				type="file" name="file"> 选择文件:<input type="file" name="file">
			<input type="submit" value="上传">

		</form>
	</fieldset>

	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
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