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
			@RequestParam("detailsDescribe") String detailsDescribe, @RequestParam("shopId") int shopId) {
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		// 用户id
		goods.setUserId(user.getId());

		MessageUtil message = goodsListService.add(goods, shopId);
		System.out.println("------------------------>>>>>>>id:" + goods.getGoodsId());
		goodsDetailsDaoService.addDetails(detailsDescribe, goods.getGoodsId());
		// 判断
		if (Result.SUCCEED == message.getResult()) {
			model.addAttribute("message", goodsListService.selectGoodsList(1));
			return "tables";
		}

		return "insert";
	}

	/**
	 * 查询信息
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String selectGoodsList(Model model, HttpServletRequest request) {
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// 用户id获取
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "tables";
	}

	/**
	 * ̬修改商品状态
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

		// selectGoodsList(model, request);
		return "tables";

	}

	/**
	 * 修改商品信息
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
		// 查询商品描述信息
		Object object = goodsDetailsDaoService.querydetails(goodsList.getGoodsId()).getObject();
		System.out.println("------------->>>>>>>>object:" + object);
		//
		if (object == null) {
			goodsDetailsDaoService.addDetails(detailsDescribe, goodsList.getGoodsId());
		} else {
			//
			goodsDetailsDaoService.updatedetails(detailsDescribe, goodsList.getGoodsId());
		}
		//
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		//
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "updataTables";
	}

	/**
	 * 商品修改页
	 * 
	 * @param goodsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public String updatePage(@RequestParam("goodsId") int goodsId, Model model) {

		// 查询商品描述信息
		model.addAttribute("goodaDetails", goodsDetailsDaoService.querydetails(goodsId));
		// 查询商品类别
		model.addAttribute("goodsCategory", goodsCategoryDaoService.selectGoodsCategory().getObject());
		// 根据id查询商品
		model.addAttribute("goodsList", goodsListService.selectGoodsId(goodsId).getObject());
		return "update";
	}

	/**
	 * 修改商品描述
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateDataList", method = RequestMethod.GET)
	public String updateDataList(Model model, HttpServletRequest request) {
		// 获取登录用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// 获取用户id
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "updataTables";
	}

	@RequestMapping(value = "/uploadPage", method = RequestMethod.GET)
	public String uploadPage(@RequestParam("goodsId") int goodsId, Model model) {
		model.addAttribute("goodsId", goodsId);
		// 查询商品图片
		model.addAttribute("goodsImg", goodsImgDaoService.selectGoodsImg(goodsId));
		return "uploadImg";
	}

}
