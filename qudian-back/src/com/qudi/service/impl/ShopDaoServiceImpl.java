package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qudi.bean.Shop;
import com.qudi.dao.ShopDao;
import com.qudi.service.ShopDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Service
public class ShopDaoServiceImpl implements ShopDaoService {

	@Autowired
	private ShopDao shopDao;

	@Override
	public MessageUtil selectShopList(int userId) {
		MessageUtil message = new MessageUtil();
		// 查询店铺
		List<Shop> list = shopDao.selectShopList(userId);

		if (list.size() > 0) {
			message.setResult(Result.SUCCEED);
			message.setObject(list);
			return message;
		}
		message.setInfo("暂无数据");
		return message;
	}

	@Override
	public MessageUtil selectShop(int shopId) {
		MessageUtil message = new MessageUtil();
		if (shopId > 0) {
			Shop shop = shopDao.selectShop(shopId);
			if (shop != null) {
				message.setResult(Result.SUCCEED);
				message.setObject(shop);
				return message;
			}
			message.setInfo("查询失败");
			return message;
		}
		message.setInfo("参数错误");
		return message;
	}

	@Override
	public MessageUtil addShop(Shop shop) {
		MessageUtil message = new MessageUtil();

		if (shop != null) {
			if (shop.getShopName() != null) {
				if (shopDao.addShop(shop) > 0) {
					message.setResult(Result.SUCCEED);
					message.setInfo("添加成功");
					return message;
				}
				message.setInfo("添加失败");
				return message;
			}
			message.setInfo("店铺名称为空");
			return message;
		}
		message.setInfo("添加失败，参数错误");
		return message;
	}

	@Override
	public MessageUtil updateShop(Shop shop) {
		MessageUtil message = new MessageUtil();
		if (shop != null) {
			if (shopDao.updateShop(shop) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("修改成功");
				return message;
			}
			message.setInfo("修改失败");
			return message;
		}
		message.setInfo("参数错误");
		return message;
	}

	@Override
	public MessageUtil deleteShop(int shopId) {
		MessageUtil message = new MessageUtil();
		if (shopId > 0) {
			if (shopDao.deleteShop(shopId) > 0) {
				message.setInfo("删除成功");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("删除失败");
			return message;
		}
		message.setInfo("参数错误");
		return message;
	}

}
