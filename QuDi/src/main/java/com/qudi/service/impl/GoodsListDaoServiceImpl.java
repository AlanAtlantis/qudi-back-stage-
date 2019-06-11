package com.qudi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.GoodsList;
import com.qudi.dao.GoodsListDao;
import com.qudi.service.GoodsListDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("goodsListService")
public class GoodsListDaoServiceImpl implements GoodsListDaoService {

	@Autowired
	private GoodsListDao dao;

	public MessageUtil add(GoodsList goods) {
		MessageUtil message = new MessageUtil();
		if (goods != null) {

			if (dao.add(goods) > 0) {
				dao.addShop2Goods(1, goods.getGoodsId());
				message.setInfo("successfully added");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("fail to add");
			return message;
		}
		message.setInfo("parameter error");
		return message;
	}

}
