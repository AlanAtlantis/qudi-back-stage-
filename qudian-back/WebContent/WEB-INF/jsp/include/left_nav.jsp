

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
			<!-- <li><a href="media.html">Media</a></li>
						<li><a href="invoice.html">Invoice</a></li> -->
		</ul></li>
	<li class="active"><a href="sys/goodsBargaining/inventory"><i
			class="icon-home"></i>议价商品管理</a></li>
	<li><a href="sys/sysuser/update_jump"> <i class="icon-picture"></i>用户信息修改
	</a></li>
	<li><a href="sys/sysuser/theorder_jump"> <i
			class="icon-picture"></i>订单
	</a></li>
	<li><a href="sys/shop/selectShoplist"> <i class="icon-picture"></i>店铺管理
	</a></li>
</ul>