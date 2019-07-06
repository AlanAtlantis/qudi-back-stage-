package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsBargaining;

/**
 * 
 * @author AlanAtlantis
 *
 */
public interface GoodsBargainingDao {

	/**
	 * ��ѯ�����Ϣ
	 * 
	 * @param goodsId
	 * @return
	 */
	List<GoodsBargaining> queryBar(@Param("goodsId") int goodsId);

	/**
	 * �޸����״̬
	 * 
	 * @param bargainingStatus
	 * @param bargainingId
	 * @return
	 */
	int updatebar(@Param("bargainingStatus") int bargainingStatus, @Param("bargainingId") int bargainingId);

}
