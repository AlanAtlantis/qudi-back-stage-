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
	 * �����Ʒ
	 * 
	 * @param model
	 * @param goods
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, GoodsList goods, HttpServletRequest request,
			@RequestParam("detailsDescribe") String detailsDescribe) {
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		goods.setUserId(user.getId());

		MessageUtil message = goodsListService.add(goods);
		System.out.println("------------------------>>>>>>>id:" + goods.getGoodsId());
		goodsDetailsDaoService.addDetails(detailsDescribe, goods.getGoodsId());
		if (Result.SUCCEED == message.getResult()) {
			model.addAttribute("message", goodsListService.selectGoodsList(1));
			return "tables";
		}

		return "insert";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String selectGoodsList(Model model, HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "tables";
	}

	/**
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
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		// selectGoodsList(model, request);
		return "tables";

	}

	/**
	 * �޸���Ʒ
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
		// ��ѯ��Ʒ����
		Object object = goodsDetailsDaoService.querydetails(goodsList.getGoodsId()).getObject();
		System.out.println("------------->>>>>>>>object:" + object);
		// �ж��Ƿ�����Ʒ������������Ʒ�����������Ʒ����
		if (object == null) {
			goodsDetailsDaoService.addDetails(detailsDescribe, goodsList.getGoodsId());
		} else {
			// �޸���Ʒ����
			goodsDetailsDaoService.updatedetails(detailsDescribe, goodsList.getGoodsId());
		}
		// ��ȡ�û���Ϣ
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// ��ʱָ���û���
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "updataTables";
	}

	/**
	 * ��Ʒ�޸����ݲ�ѯ
	 * 
	 * @param goodsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public String updatePage(@RequestParam("goodsId") int goodsId, Model model) {
		// goodsListService.selectGoodsId(goodsId);
		// �����ѯ������
		/*
		 * JSONObject json = new JSONObject(); json.put("goodsList",
		 * goodsListService.selectGoodsId(goodsId).getObject());
		 * json.put("goodsCategory",
		 * goodsCategoryDaoService.selectGoodsCategory().getObject());
		 * model.addAttribute("json", json);
		 */
		// ��ѯ��Ʒ����
		model.addAttribute("goodaDetails", goodsDetailsDaoService.querydetails(goodsId));
		model.addAttribute("goodsCategory", goodsCategoryDaoService.selectGoodsCategory().getObject());
		model.addAttribute("goodsList", goodsListService.selectGoodsId(goodsId).getObject());
		return "update";
	}

	/**
	 * ��Ʒ�޸Ĳ�ѯ
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateDataList", method = RequestMethod.GET)
	public String updateDataList(Model model, HttpServletRequest request) {
		// ��ȡ�û���Ϣ
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		// ��ʱָ���û���
		int userId = user.getId();
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		return "updataTables";
	}

	@RequestMapping(value = "/uploadPage", method = RequestMethod.GET)
	public String uploadPage(@RequestParam("goodsId") int goodsId, Model model) {
		model.addAttribute("goodsId", goodsId);
		// ��ѯ��ƷͼƬ��Ϣ
		model.addAttribute("goodsImg", goodsImgDaoService.selectGoodsImg(goodsId));
		return "uploadImg";
	}

}
