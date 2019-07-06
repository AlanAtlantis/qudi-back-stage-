package com.qudi.service;

import com.qudi.bean.GoodsList;
import com.qudi.util.MessageUtil;

/**
 * 
 * @author AlanAtlantis
 *
 */
public interface GoodsListDaoService {

	MessageUtil add(GoodsList goods,int shopId);

	MessageUtil selectGoodsList(int userId);

	MessageUtil goodsShelves(int status, int goodsId);

	MessageUtil updateGoods(GoodsList goodsList);

	MessageUtil selectGoodsId(int goodsId);

	MessageUtil goodsCategory(int userId);

}
