package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qudi.bean.GoodsList;
import com.qudi.dao.GoodsListDao;
import com.qudi.service.GoodsListDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

/**
 * 
 * @author AlanAtlantis
 *
 */
@Service
public class GoodsListDaoServiceImpl implements GoodsListDaoService {

	@Autowired
	private GoodsListDao goodsListDao;

	public MessageUtil add(GoodsList goods, int shopId) {
		MessageUtil message = new MessageUtil();
		if (goods != null) {

			if (goodsListDao.add(goods) > 0) {
				goodsListDao.addShop2Goods(shopId, goods.getGoodsId());
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

	@Override
	public MessageUtil selectGoodsList(int userId) {
		MessageUtil message = new MessageUtil();

		if (userId > 0) {

			List<GoodsList> list = goodsListDao.selectGoodsList(userId);

			if (list.size() > 0) {
				message.setObject(list);
				message.setInfo("The query is successful");
				message.setResult(Result.SUCCEED);
				return message;

			}
			message.setInfo("no data");
			return message;
		}

		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil goodsShelves(int status, int goodsId) {
		MessageUtil message = new MessageUtil();

		if (status > 0) {

			// 修改商品状态并判断是否修改成功
			if (goodsListDao.goodsShelves(status, goodsId) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("goods status modified successfully");
				return message;
			}

			message.setInfo("Failure, internal error");
			return message;
		}

		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil updateGoods(GoodsList goodsList) {
		MessageUtil message = new MessageUtil();
		if (goodsList != null) {
			// 修改商品信息并判断是否修改成功
			if (goodsListDao.updateGoods(goodsList) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("Modify the success");
				return message;

			}
			message.setInfo("Modify the failure");
			return message;
		}

		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil selectGoodsId(int goodsId) {
		MessageUtil message = new MessageUtil();
		if (goodsId > 0) {
			// 根据商品id查询商品信息
			GoodsList goods = goodsListDao.selectGoodsId(goodsId);
			if (goods != null) {
				message.setObject(goods);
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
	public MessageUtil goodsCategory(int userId) {
		MessageUtil message = new MessageUtil();
		// 根据用户id查询商品分类
		List<GoodsList> goods = goodsListDao.goodsCategory(userId);
		if (goods.size() > 0) {
			message.setObject(goods);
			message.setResult(Result.SUCCEED);
			message.setInfo("The query is successful");
			return message;
		}
		message.setInfo("no data");
		return message;

	}

}
