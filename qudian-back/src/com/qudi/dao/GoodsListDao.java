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
	 * �����Ʒ
	 * 
	 * @param goods
	 * @return
	 */
	int add(GoodsList goods);

	/**
	 * �����Ʒ����̵Ĺ�ϵ
	 * 
	 * @return
	 */
	int addShop2Goods(@Param("shopId") int shopId, @Param("goodsId") int goodsId);

	/**
	 * ��ѯ�û�������Ʒ�б�
	 * 
	 * @param userId
	 * @return
	 */
	List<GoodsList> selectGoodsList(@Param("userId") int userId);

	/**
	 * ��Ʒ�ϼ����¼�
	 * 
	 * @param status
	 * @return
	 */
	int goodsShelves(@Param("status") int status, @Param("goodsId") int goodsId);

	/**
	 * ��Ʒ��Ϣ�޸�
	 * 
	 * @param goodsList
	 * @return
	 */
	int updateGoods(GoodsList goodsList);

	/**
	 * ������Ʒid��ѯ��Ʒ
	 * 
	 * @param goodsId
	 * @return
	 */
	GoodsList selectGoodsId(@Param("goodsId") int goodsId);

	/**
	 * ��ѯ�����Ʒ
	 * 
	 * @return
	 */
	List<GoodsList> goodsCategory(@Param("userId") int userId);
}
