package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.service.GoodsCategoryDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/goodsCategory")
public class GoodsCategoryContr {

	@Autowired
	private GoodsCategoryDaoService goodsCategoryDaoService;

	@RequestMapping(value = "/selectGoodsCategory", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectGoodsCategory() {
		return goodsCategoryDaoService.selectGoodsCategory();
	}

	@RequestMapping(value = "/selectGoodsCategoryLevel", method = RequestMethod.GET)
	public @ResponseBody MessageUtil selectGoodsCategoryLevel(@RequestParam("id") int id,
			@RequestParam("categoryLevel") int categoryLevel) {
		return goodsCategoryDaoService.selectGoodsCategoryLevel(id, categoryLevel);
	}

}
