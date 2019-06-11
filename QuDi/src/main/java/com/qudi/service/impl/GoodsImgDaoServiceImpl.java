package com.qudi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.GoodsImg;
import com.qudi.dao.GoodsImgDao;
import com.qudi.service.GoodsImgDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("goodsImgDaoService")
public class GoodsImgDaoServiceImpl implements GoodsImgDaoService {

	@Autowired
	private GoodsImgDao dao;

	public MessageUtil addGoodsImg(GoodsImg goodsImg) {

		MessageUtil message = new MessageUtil();

		if (goodsImg != null) {

			if (dao.addGoodsImg(goodsImg) > 0) {

				message.setInfo("successfully added");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("addition failed");
			return message;
		}

		message.setInfo("parameter error");
		return message;
	}

}
