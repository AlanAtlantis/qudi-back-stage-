package com.qudi.dao;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsList;

public interface GoodsListDao {

	/**
	 * 添加商品
	 * 
	 * @param goods
	 * @return
	 */
	int add(GoodsList goods);

	/**
	 * 添加商品与店铺的关系
	 * 
	 * @return
	 */
	int addShop2Goods(@Param("shopId") int shopId, @Param("goodsId") int goodsId);

}
