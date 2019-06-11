package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.GoodsCategory;

public interface GoodsCategoryDao {

	List<GoodsCategory> selectGoodsCategory();

	List<GoodsCategory> selectGoodsCategoryLevel(@Param("id") int id, @Param("categoryLevel") int categoryLevel);

}
