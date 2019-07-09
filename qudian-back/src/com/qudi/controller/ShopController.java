package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qudi.bean.Shop;
import com.qudi.bean.SysUser;
import com.qudi.service.ShopDaoService;

@Controller
@RequestMapping("/sys/shop")
public class ShopController {

	@Autowired
	private ShopDaoService shopDaoService;

	@RequestMapping(value = "/selectShoplist", method = RequestMethod.GET)
	public String selectShopList(Model model, HttpServletRequest request) {
		// 获取登录用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		model.addAttribute("shop", shopDaoService.selectShopList(user.getId()));

		return "shopTables";
	}

	@RequestMapping(value = "/selectShop", method = RequestMethod.GET)
	public String selectShop(Model model, @RequestParam("shopId") int shopId) {

		model.addAttribute("shop", shopDaoService.selectShop(shopId));

		return "shopTables";
	}

	@RequestMapping(value = "/addShop", method = RequestMethod.GET)
	public String addShop(Model model, HttpServletRequest request, @RequestParam("shopName") String shopName) {

		System.out.println("------------" + shopName);

		Shop shop = new Shop();

		shop.setShopName(shopName);

		// 获取登录用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		shop.setUserId(user.getId());

		model.addAttribute("message", shopDaoService.addShop(shop));

		model.addAttribute("shop", shopDaoService.selectShopList(user.getId()));

		return "shopTables";
	}

	@RequestMapping(value = "/updateShop", method = RequestMethod.GET)
	public String updateShop(Model model, HttpServletRequest request, @RequestParam("shopName") String shopName,
			@RequestParam("userId") int userId, @RequestParam("shopId") int shopId) {

		Shop shop = new Shop();

		shop.setShopName(shopName);
		shop.setUserId(userId);
		shop.setShopId(shopId);

		System.out.println("------------" + shop);

		model.addAttribute("message", shopDaoService.updateShop(shop));

		// 获取登录用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		model.addAttribute("shop", shopDaoService.selectShopList(user.getId()));

		return "shopTables";
	}

	@RequestMapping(value = "/deleteShop", method = RequestMethod.GET)
	public String deleteShop(Model model, HttpServletRequest request, @RequestParam("shopId") int shopId) {

		model.addAttribute("message", shopDaoService.deleteShop(shopId));

		// 获取登录用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		model.addAttribute("shop", shopDaoService.selectShopList(user.getId()));

		return "shopTables";
	}

	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addPage() {

		return "addShop";
	}

	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public String updatePage(Model model, @RequestParam("shopId") int shopId) {

		System.out.println("------------->>>" + shopId);

		model.addAttribute("shop", shopDaoService.selectShop(shopId));
		return "updateShop";
	}

}
