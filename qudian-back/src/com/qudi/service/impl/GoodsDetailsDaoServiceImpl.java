package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qudi.bean.GoodsDetails;
import com.qudi.dao.GoodsDetailsDao;
import com.qudi.service.GoodsDetailsDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Service
public class GoodsDetailsDaoServiceImpl implements GoodsDetailsDaoService {
	@Autowired
	private GoodsDetailsDao goodsDetailsDao;

	@Override
	public MessageUtil addDetails(String detailsDescribe, int goodsId) {
		MessageUtil message = new MessageUtil();
		if (detailsDescribe != null && goodsId > 0) {
			if (goodsDetailsDao.addDetails(detailsDescribe, goodsId) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("Add a success");
				return message;
			}
			message.setInfo("Add failure");
			return message;
		}
		message.setInfo("Parameter error");
		return message;
	}

	@Override
	public MessageUtil querydetails(int goodsId) {
		MessageUtil message = new MessageUtil();
		if (goodsId > 0) {
			// 查询商品详情信息
			List<GoodsDetails> list = goodsDetailsDao.querydetails(goodsId);
			if (list.size() > 0) {
				message.setInfo("The query is successful");
				message.setObject(list);
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("no data");
			return message;
		}
		message.setInfo("Parameter error");
		return message;
	}

	@Override
	public MessageUtil updatedetails(String detailsDescribe, int goodsId) {
		MessageUtil message = new MessageUtil();

		System.out.println("--------------->>>>>detailsDescribe:" + detailsDescribe + "\t\t\tgoodsId:" + goodsId);

		if (detailsDescribe != null && goodsId > 0) {
			if (goodsDetailsDao.updatedetails(detailsDescribe, goodsId) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("Modify the success");
				return message;
			}
			message.setInfo("Modify the failure");
			return message;
		}
		message.setInfo("Parameter error");

		return message;
	}

}
