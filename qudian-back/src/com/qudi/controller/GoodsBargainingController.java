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

		// ���ò�ѯ���service��
		model.addAttribute("message", goodsBargainingDaoService.queryBar(goodsId));

		return "bargainingTables";
	}

	@RequestMapping(value = "/updatebar", method = RequestMethod.GET)
	public String updatebar(Model model, @RequestParam("bargainingStatus") int bargainingStatus,
			@RequestParam("bargainingId") int bargainingId, @RequestParam("goodsId") int goodsId) {

		// ��������޸�service��
		model.addAttribute("update", goodsBargainingDaoService.updatebar(bargainingStatus, bargainingId));
		// ���ò�ѯ���service��
		model.addAttribute("message", goodsBargainingDaoService.queryBar(goodsId));

		return "bargainingTables";
	}

	/**
	 * ��ѯ�����Ʒ
	 * 
	 * @param model
	 * @param bargainingStatus
	 * @param bargainingId
	 * @return
	 */
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String inventory(Model model, HttpServletRequest request) {
		// ��ȡ�û���Ϣ
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// ָ���û�id
		int userId =1 /*user.getId()*/;

		// ���ÿ���ѯ����service��
		model.addAttribute("message", goodsListDaoService.goodsCategory(userId));

		return "bargaining";
	}
}
