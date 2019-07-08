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
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

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
		// 查询信息
		MessageUtil message = goodsBargainingDaoService.queryBar(goodsId);

		if (message.getResult() == Result.SUCCEED) {
			model.addAttribute("message", message);
		} else {
			model.addAttribute("error", "议价查询失败");
		}

		return "bargainingTables";
	}

	@RequestMapping(value = "/updatebar", method = RequestMethod.GET)
	public String updatebar(Model model, @RequestParam("bargainingStatus") int bargainingStatus,
			@RequestParam("bargainingId") int bargainingId, @RequestParam("goodsId") int goodsId) {
		// 修改议价状态
		MessageUtil message = goodsBargainingDaoService.updatebar(bargainingStatus, bargainingId);
		if (message.getResult() == Result.SUCCEED) {

			model.addAttribute("update", message);
		} else {
			model.addAttribute("error", "服务器内部错误");
		}
		// 查询议价
		model.addAttribute("message", goodsBargainingDaoService.queryBar(goodsId));

		return "bargainingTables";
	}

	/**
	 *
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
		// 获取用户id
		int userId = user.getId();

		MessageUtil message = goodsListDaoService.goodsCategory(userId);

		if (message.getResult() == Result.SUCCEED) {
			model.addAttribute("message", message);
		} else {
			model.addAttribute("error", "发生错误，请重试");
		}

		return "bargaining";
	}
}
