package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsImg;
/**
 * 
 * @author AlanAtlantis
 *
 */
public interface GoodsImgDao {

	/**
	 * 添加商品图片
	 * 
	 * @param goodsImg
	 * @return
	 */
	int addGoodsImg(GoodsImg goodsImg);

	/**
	 * 查询商品图片
	 * 
	 * @param goodsId
	 * @return
	 */
	List<GoodsImg> selectGoodsImg(@Param("goodsId") int goodsId);

	/**
	 * 修改商品图片
	 * 
	 * @param picId
	 * @return
	 */
	int updateImg(GoodsImg goodsImg);

	/**
	 * 删除商品图片
	 * 
	 * @param PicId
	 * @return
	 */
	int deleteImg(@Param("picId") int PicId);

	/**
	 * 修改主图
	 * 
	 * @param isMain
	 * @param picId
	 * @return
	 */
	int updateMian(@Param("isMain") int isMain, @Param("picId") int picId);

	/**
	 * 查询商品主图
	 * @param goodsId
	 * @return
	 */
	Integer queryIsMain(@Param("goodsId") int goodsId);

}
