package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsDetails;

/**
 * 
 * @author AlanAtlantis
 *
 */
public interface GoodsDetailsDao {

	/**
	 * 添加商品描述
	 * 
	 * @param detailsDescribe
	 * @param goodsId
	 * @return
	 */
	int addDetails(@Param("detailsDescribe") String detailsDescribe, @Param("goodsId") int goodsId);

	/**
	 * 查询商品描述
	 * 
	 * @param goodsId
	 * @return
	 */
	List<GoodsDetails> querydetails(@Param("goodsId") int goodsId);

	/**
	 * 修改商品描述
	 * 
	 * @param detailsDescribe
	 * @param goodsId
	 * @return
	 */
	int updatedetails(@Param("detailsDescribe") String detailsDescribe, @Param("goodsId") int goodsId);

	/**
	 * 删除商品
	 * 
	 * @param goodsId
	 * @return
	 */
	int delete(@Param("goodsId") int goodsId);

}
