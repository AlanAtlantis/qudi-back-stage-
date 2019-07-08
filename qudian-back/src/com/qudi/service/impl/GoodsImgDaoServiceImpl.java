package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qudi.bean.GoodsImg;
import com.qudi.dao.GoodsImgDao;
import com.qudi.service.GoodsImgDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

/**
 * 
 * @author AlanAtlantis
 *
 */
@Service
public class GoodsImgDaoServiceImpl implements GoodsImgDaoService {

	@Autowired
	private GoodsImgDao goodsImgDao;

	public MessageUtil addGoodsImg(GoodsImg goodsImg) {

		System.out.println("------------------------>>" + goodsImg);

		MessageUtil message = new MessageUtil();

		if (goodsImg != null) {

			if (goodsImgDao.addGoodsImg(goodsImg) > 0) {

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

	@Override
	public MessageUtil selectGoodsImg(int goodsId) {
		MessageUtil message = new MessageUtil();

		if (goodsId > 0) {
			// 查询商品图片
			List<GoodsImg> list = goodsImgDao.selectGoodsImg(goodsId);

			System.out.println("----------------->>>>>----->>>" + list);
			// 判断是否有数据
			if (list.size() > 0) {
				message.setObject(list);
				message.setResult(Result.SUCCEED);
				message.setInfo("The query is successful");
				return message;
			}
			message.setInfo("no data");
			return message;
		}

		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil updateImg(GoodsImg goodsImg) {
		MessageUtil message = new MessageUtil();
		if (goodsImg != null) {
			if (goodsImgDao.updateImg(goodsImg) > 0) {
				message.setInfo("Modify the success");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("Modify the failure");
			return message;
		}
		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil deleteImg(int picId) {
		MessageUtil message = new MessageUtil();
		if (picId > 0) {
			if (goodsImgDao.deleteImg(picId) > 0) {
				message.setInfo("Delete the success");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("delete the failure");
			return message;
		}
		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil updateMian(int isMain, int picId) {
		MessageUtil message = new MessageUtil();
		if (picId > 0) {

			// �ж��Ƿ��޸ĳɹ�
			if (goodsImgDao.updateMian(isMain, picId) > 0) {
				message.setInfo("Modify the success");
				message.setResult(Result.SUCCEED);
				return message;
			}

			message.setInfo("Modify the failure");
			return message;
		}
		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil queryIsMain(int goodsId) {
		MessageUtil message = new MessageUtil();
		if (goodsId > 0) {
			int picId = 0;
			Integer picIds = goodsImgDao.queryIsMain(goodsId);
			if (picIds != null) {
				picId = picIds;
			}

			System.out.println("------------------->>>>>----" + picId);

			message.setInfo("The query is successful");
			message.setResult(Result.SUCCEED);
			message.setObject(picId);
			return message;

		}
		message.setInfo("parameter error");
		return message;
	}

}
