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
	 * �����Ʒ����
	 * 
	 * @param detailsDescribe
	 * @param goodsId
	 * @return
	 */
	int addDetails(@Param("detailsDescribe") String detailsDescribe, @Param("goodsId") int goodsId);

	/**
	 * ��ѯ��Ʒ����
	 * 
	 * @param goodsId
	 * @return
	 */
	List<GoodsDetails> querydetails(@Param("goodsId") int goodsId);

	/**
	 * �޸���Ʒ����
	 * 
	 * @param detailsDescribe
	 * @param goodsId
	 * @return
	 */
	int updatedetails(@Param("detailsDescribe") String detailsDescribe, @Param("goodsId") int goodsId);

	/**
	 * ɾ����Ʒ
	 * 
	 * @param goodsId
	 * @return
	 */
	int delete(@Param("goodsId") int goodsId);

}
