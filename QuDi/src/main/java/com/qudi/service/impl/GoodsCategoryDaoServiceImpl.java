package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.GoodsCategory;
import com.qudi.dao.GoodsCategoryDao;
import com.qudi.service.GoodsCategoryDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("goodsCategoryDaoService")
public class GoodsCategoryDaoServiceImpl implements GoodsCategoryDaoService {

	@Autowired
	private GoodsCategoryDao goodsCategoryDao;

	public MessageUtil selectGoodsCategory() {

		MessageUtil message = new MessageUtil();
		message.setObject(goodsCategoryDao.selectGoodsCategory());
		message.setResult(Result.SUCCEED);
		System.out.println(message.getObject());

		return message;
	}

	public MessageUtil selectGoodsCategoryLevel(int id, int categoryLevel) {
		MessageUtil message = new MessageUtil();

		System.out.println("-*----->>>>" + id + "/t/t" + categoryLevel);

		if (id > 0 && categoryLevel > 0) {
			List<GoodsCategory> list = goodsCategoryDao.selectGoodsCategoryLevel(id, categoryLevel);

			if (list.size() > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("Data query successful");
				message.setObject(list);
				return message;
			}
			message.setInfo("no data");
			return message;
		}
		message.setInfo("parameter error");
		return message;
	}

}
