package com.qudi.service;


import com.qudi.bean.Shop;
import com.qudi.util.MessageUtil;

public interface ShopDaoService {

	MessageUtil selectShopList(int userId);

	MessageUtil selectShop(int shopId);

	MessageUtil addShop(Shop shop);

	MessageUtil updateShop(Shop shop);

	MessageUtil deleteShop(int shopId);

}
