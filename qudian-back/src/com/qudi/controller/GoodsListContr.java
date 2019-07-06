package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qudi.bean.GoodsList;
import com.qudi.bean.SysUser;
import com.qudi.service.GoodsCategoryDaoService;
import com.qudi.service.GoodsDetailsDaoService;
import com.qudi.service.GoodsImgDaoService;
import com.qudi.service.GoodsListDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

/**
 * 
 * @author AlanAtlantis
 *
 */
@Controller
@RequestMapping("/sys/goodsList")
public class GoodsListContr {

	@Autowired
	private GoodsListDaoService goodsListService;
	@Autowired
	private GoodsCategoryDaoService goodsCategoryDaoService;
	@Autowired
	private GoodsImgDaoService goodsImgDaoService;
	@Autowired
	private GoodsDetailsDaoService goodsDetailsDaoService;

	/**
	 * 添加商品
	 * 
	 * @param model
	 * @param goods
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, GoodsList goods, HttpServletRequest request,
			@RequestParam("detailsDescribe") String detailsDescribe) {
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		// 用户id
		goods.setUserId(user.getId());

		MessageUtil message = goodsListService.add(goods);
		System.out.println("------------------------>>>>>>>id:" + goods.getGoodsId());
		goodsDetailsDaoService.addDetails(detailsDescribe, goods.getGoodsId());
		// 判断是否添加成功
		if (Result.SUCCEED == message.getResult()) {
			model.addAttribute("message", goodsListService.selectGoodsList(1));
			return "tables";
		}

		return "insert";
	}

	/**
	 * 显示商品列表
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String selectGoodsList(Model model, HttpServletRequest request) {
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// 暂时指定用户，
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "tables";
	}

	/**
	 * 修改商品状态
	 * 
	 * @param status
	 * @param goodsId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goodsShelves", method = RequestMethod.GET)
	public String goodsShelves(@RequestParam("status") int status, @RequestParam("goodsId") int goodsId, Model model,
			HttpServletRequest request) {

		System.out.println("----------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>.----------------------");

		model.addAttribute("message", goodsListService.goodsShelves(status, goodsId));
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		// 调用查询方法
		// selectGoodsList(model, request);
		return "tables";

	}

	/**
	 * 修改商品
	 * 
	 * @param goodsList
	 * @param model
	 * @param request
	 */
	@RequestMapping(value = "/updateGoods", method = RequestMethod.GET)
	public String updateGoods(GoodsList goodsList, Model model, HttpServletRequest request,
			@RequestParam("detailsDescribe") String detailsDescribe) {

		System.out.println("-------------------->>>>>detailsDescribe:" + detailsDescribe);
		model.addAttribute("message", goodsListService.updateGoods(goodsList));
		// 查询商品描述
		Object object = goodsDetailsDaoService.querydetails(goodsList.getGoodsId()).getObject();
		System.out.println("------------->>>>>>>>object:" + object);
		// 判断是否有商品描述，若无商品描述则添加商品描述
		if (object == null) {
			goodsDetailsDaoService.addDetails(detailsDescribe, goodsList.getGoodsId());
		} else {
			// 修改商品描述
			goodsDetailsDaoService.updatedetails(detailsDescribe, goodsList.getGoodsId());
		}
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// 暂时指定用户，
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "updataTables";
	}

	/**
	 * 商品修改数据查询
	 * 
	 * @param goodsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public String updatePage(@RequestParam("goodsId") int goodsId, Model model) {
		// goodsListService.selectGoodsId(goodsId);
		// 保存查询的数据
		/*
		 * JSONObject json = new JSONObject(); json.put("goodsList",
		 * goodsListService.selectGoodsId(goodsId).getObject());
		 * json.put("goodsCategory",
		 * goodsCategoryDaoService.selectGoodsCategory().getObject());
		 * model.addAttribute("json", json);
		 */
		// 查询商品描述
		model.addAttribute("goodaDetails", goodsDetailsDaoService.querydetails(goodsId));
		model.addAttribute("goodsCategory", goodsCategoryDaoService.selectGoodsCategory().getObject());
		model.addAttribute("goodsList", goodsListService.selectGoodsId(goodsId).getObject());
		return "update";
	}

	/**
	 * 商品修改查询
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateDataList", method = RequestMethod.GET)
	public String updateDataList(Model model, HttpServletRequest request) {
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// 暂时指定用户，
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "updataTables";
	}

	@RequestMapping(value = "/uploadPage", method = RequestMethod.GET)
	public String uploadPage(@RequestParam("goodsId") int goodsId, Model model) {
		model.addAttribute("goodsId", goodsId);
		// 查询商品图片信息
		model.addAttribute("goodsImg", goodsImgDaoService.selectGoodsImg(goodsId));
		return "uploadImg";
	}

}
