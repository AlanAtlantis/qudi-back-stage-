package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qudi.bean.SysUser;
import com.qudi.service.GoodsBargainingDaoService;
import com.qudi.service.GoodsListDaoService;

/**
 * 
 * @author AlanAtlantis
 *
 */
@Controller
@RequestMapping("/sys/goodsBargaining")
public class GoodsBargainingController {

	@Autowired
	private GoodsBargainingDaoService goodsBargainingDaoService;
	@Autowired
	private GoodsListDaoService goodsListDaoService;

	@RequestMapping(value = "/queryBar", method = RequestMethod.GET)
	public String queryBar(Model model, @RequestParam("goodsId") int goodsId) {

		// 调用查询议价service层
		model.addAttribute("message", goodsBargainingDaoService.queryBar(goodsId));

		return "bargainingTables";
	}

	@RequestMapping(value = "/updatebar", method = RequestMethod.GET)
	public String updatebar(Model model, @RequestParam("bargainingStatus") int bargainingStatus,
			@RequestParam("bargainingId") int bargainingId, @RequestParam("goodsId") int goodsId) {

		// 调用议价修改service层
		model.addAttribute("update", goodsBargainingDaoService.updatebar(bargainingStatus, bargainingId));
		// 调用查询议价service层
		model.addAttribute("message", goodsBargainingDaoService.queryBar(goodsId));

		return "bargainingTables";
	}

	/**
	 * 查询库存商品
	 * 
	 * @param model
	 * @param bargainingStatus
	 * @param bargainingId
	 * @return
	 */
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String inventory(Model model, HttpServletRequest request) {
		// 获取用户信息
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// 指定用户id
		int userId =1 /*user.getId()*/;

		// 调用库存查询方法service层
		model.addAttribute("message", goodsListDaoService.goodsCategory(userId));

		return "bargaining";
	}
}
