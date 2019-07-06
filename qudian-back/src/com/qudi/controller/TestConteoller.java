package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qudi.service.GoodsCategoryDaoService;
/**
 * 
 * @author AlanAtlantis
 *
 */
@Controller
@RequestMapping("/sys")
public class TestConteoller {

	@Autowired
	private GoodsCategoryDaoService goodsCategoryDaoService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {

		System.out.println(goodsCategoryDaoService.selectGoodsCategory());
		System.out.println("-------°∑°∑°∑°∑°∑°∑°∑aaaaaaa-≤‚ ‘");
		model.addAttribute("num", "sroigrjgniu3rh  hhaaoeirg");
		return "hello";
	}

}
