

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="list-unstyled">

	<li class="active"><a href="sys/goodsList/tables"><i
			class="icon-home"></i>Home</a></li>
	<li><a href="#apps" aria-expanded="false" data-toggle="collapse">
			<i class="icon-interface-windows"></i>商品管理
	</a>
		<ul id="apps" class="collapse list-unstyled">
			<li><a href="sys/goodsList/tables">商品例表</a></li>
			<li><a href="sys/goodsCategory/selectGoodsCategory">商品添加</a></li>
			<li><a href="sys/goodsList/updateDataList">商品修改</a></li>
		</ul></li>
	<li class="active"><a href="sys/goodsBargaining/inventory"><i
			class="icon-home"></i>议价管理</a></li>
	<li><a href="sys/sysuser/theorder_jump"> <i
			class="icon-picture"></i>订单管理
	</a></li>
	<li><a href="#sysuser" aria-expanded="false" data-toggle="collapse">
			<i class="icon-interface-windows"></i>用戶管理
	</a>
		<ul id="sysuser" class="collapse list-unstyled">
					<li><a href="sys/sysuser/userinfo_sysuser">用戶个人信息</a></li>
			<li><a href="sys/sysuser/update_jump">用戶修改</a></li>
		</ul></li>
</ul>