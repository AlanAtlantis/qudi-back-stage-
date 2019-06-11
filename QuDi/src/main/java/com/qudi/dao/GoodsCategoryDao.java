package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.qudi.bean.GoodsCategory;



@MapperScan
public interface GoodsCategoryDao {

	List<GoodsCategory> selectGoodsCategory();

	List<GoodsCategory> selectGoodsCategoryLevel(@Param("id") int id, @Param("categoryLevel") int categoryLevel);

}
