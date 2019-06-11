package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.bean.GoodsList;
import com.qudi.service.GoodsListDaoService;
import com.qudi.util.MessageUtil;

@RestController
@SpringBootApplication
@RequestMapping("/goodsList")
public class GoodsListContr {

	@Autowired
	private GoodsListDaoService goodsListService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody MessageUtil add(@RequestBody GoodsList goods) {
		System.out.println("------>>>>>>>>>........>>>>>>>"+goods);
		return goodsListService.add(goods);
	}

}
