package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qudi.bean.GoodsBargaining;
import com.qudi.dao.GoodsBargainingDao;
import com.qudi.service.GoodsBargainingDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Service
public class GoodsBargainingDaoServiceImpl implements GoodsBargainingDaoService {

	@Autowired
	private GoodsBargainingDao goodsBargainingDao;

	@Override
	public MessageUtil queryBar(int goodsId) {
		MessageUtil message = new MessageUtil();
		if (goodsId > 0) {
			// 根据商品id查询议价信息
			List<GoodsBargaining> list = goodsBargainingDao.queryBar(goodsId);
			// 判断是否有数据
			if (list.size() > 0) {
				message.setInfo("The query is successful");
				message.setResult(Result.SUCCEED);
				message.setObject(list);
				return message;
			}
			message.setInfo("no data");

			return message;
		}
		message.setInfo("parameter error");

		return message;
	}

	@Override
	public MessageUtil updatebar(int bargainingStatus, int bargainingId) {
		MessageUtil message = new MessageUtil();
		if (bargainingId > 0) {
			// 修改议价信息并判断是否修改成功
			if (goodsBargainingDao.updatebar(bargainingStatus, bargainingId) > 0) {
				message.setInfo("modify successfully");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("fail to modify");

			return message;
		}
		message.setInfo("parameter error");

		return message;
	}

}
