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
	 * �����ƷͼƬ
	 * 
	 * @param goodsImg
	 * @return
	 */
	int addGoodsImg(GoodsImg goodsImg);

	/**
	 * ��ѯ��ƷͼƬ
	 * 
	 * @param goodsId
	 * @return
	 */
	List<GoodsImg> selectGoodsImg(@Param("goodsId") int goodsId);

	/**
	 * �޸���ƷͼƬ
	 * 
	 * @param picId
	 * @return
	 */
	int updateImg(GoodsImg goodsImg);

	/**
	 * ɾ����ƷͼƬ
	 * 
	 * @param PicId
	 * @return
	 */
	int deleteImg(@Param("picId") int PicId);

	/**
	 * �޸���ͼ
	 * 
	 * @param isMain
	 * @param picId
	 * @return
	 */
	int updateMian(@Param("isMain") int isMain, @Param("picId") int picId);

	/**
	 * ��ѯ��Ʒ��ͼ
	 * @param goodsId
	 * @return
	 */
	Integer queryIsMain(@Param("goodsId") int goodsId);

}
