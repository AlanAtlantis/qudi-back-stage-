package com.qudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Shop;

public interface ShopDao {

	List<Shop> selectShopList(@Param("userId") int userId);

	Shop selectShop(@Param("shopId") int shopId);

	int addShop(Shop shop);

	int updateShop(Shop shop);

	int deleteShop(@Param("shopId") int shopId);

}
