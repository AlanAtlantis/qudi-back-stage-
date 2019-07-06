package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsList;

/**
 * 
 * @author AlanAtlantis
 *
 */
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

	/**
	 * 查询用户所有商品列表
	 * 
	 * @param userId
	 * @return
	 */
	List<GoodsList> selectGoodsList(@Param("userId") int userId);

	/**
	 * 商品上架与下架
	 * 
	 * @param status
	 * @return
	 */
	int goodsShelves(@Param("status") int status, @Param("goodsId") int goodsId);

	/**
	 * 商品信息修改
	 * 
	 * @param goodsList
	 * @return
	 */
	int updateGoods(GoodsList goodsList);

	/**
	 * 根据商品id查询商品
	 * 
	 * @param goodsId
	 * @return
	 */
	GoodsList selectGoodsId(@Param("goodsId") int goodsId);

	/**
	 * 查询库存商品
	 * 
	 * @return
	 */
	List<GoodsList> goodsCategory(@Param("userId") int userId);
}
