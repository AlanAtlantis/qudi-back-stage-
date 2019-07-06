package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qudi.service.GoodsCategoryDaoService;
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

	@RequestMapping(value = "/selectGoodsCategory", method = RequestMethod.GET)
	public String selectGoodsCategory(Model model) {

		model.addAttribute("object", goodsCategoryDaoService.selectGoodsCategory());

		return "insert1";
	}

	@RequestMapping(value = "/selectGoodsCategoryLevel", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectGoodsCategoryLevel(@RequestParam("id") int id,
			@RequestParam("categoryLevel") int categoryLevel) {
		return goodsCategoryDaoService.selectGoodsCategoryLevel(id, categoryLevel);
	}

	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addPage(Model model, @RequestParam("categoryId") int categoryId) {

		System.out.println("categoryId-------->>>>>>>>" + categoryId);

		model.addAttribute("categoryId", categoryId);

		return "insert";
	}

}
