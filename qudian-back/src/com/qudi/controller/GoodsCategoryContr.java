package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qudi.bean.SysUser;
import com.qudi.service.GoodsCategoryDaoService;
import com.qudi.service.ShopDaoService;
import com.qudi.util.MessageUtil;

/**
 * 
 * @author AlanAtlantis
 *
 */
@Controller
@RequestMapping("/sys/goodsCategory")
public class GoodsCategoryContr {

	@Autowired
	private GoodsCategoryDaoService goodsCategoryDaoService;
	@Autowired
	private ShopDaoService shopDaoService;

	@RequestMapping(value = "/selectGoodsCategory", method = RequestMethod.GET)
	public String selectGoodsCategory(Model model, HttpServletRequest request) {

		model.addAttribute("object", goodsCategoryDaoService.selectGoodsCategory());

		// 获取登录用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		model.addAttribute("shop", shopDaoService.selectShopList(user.getId()));

		return "insert1";
	}

	@RequestMapping(value = "/selectGoodsCategoryLevel", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectGoodsCategoryLevel(@RequestParam("id") int id,
			@RequestParam("categoryLevel") int categoryLevel) {
		return goodsCategoryDaoService.selectGoodsCategoryLevel(id, categoryLevel);
	}

	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addPage(Model model, @RequestParam("categoryId") int categoryId, @RequestParam("shopId") int shopId) {

		System.out.println("categoryId-------->>>>>>>>" + categoryId + "\t\t\t" + shopId);

		model.addAttribute("categoryId", categoryId);
		model.addAttribute("shopId", shopId);

		return "insert";
	}

}
