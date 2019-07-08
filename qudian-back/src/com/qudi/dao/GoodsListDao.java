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
	 * 添加商品与用户关系
	 * 
	 * @return
	 */
	int addShop2Goods(@Param("shopId") int shopId, @Param("goodsId") int goodsId);

	/**
	 * 查询商品集合
	 * 
	 * @param userId
	 * @return
	 */
	List<GoodsList> selectGoodsList(@Param("userId") int userId);

	/**
	 * 修改商品状态
	 * 
	 * @param status
	 * @return
	 */
	int goodsShelves(@Param("status") int status, @Param("goodsId") int goodsId);

	/**
	 * 修改商品
	 * 
	 * @param goodsList
	 * @return
	 */
	int updateGoods(GoodsList goodsList);

	/**
	 * 查询商品
	 * 
	 * @param goodsId
	 * @return
	 */
	GoodsList selectGoodsId(@Param("goodsId") int goodsId);

	/**
	 * 
	 * 查询指定
	 * 
	 * @return
	 */
	List<GoodsList> goodsCategory(@Param("userId") int userId);
}
