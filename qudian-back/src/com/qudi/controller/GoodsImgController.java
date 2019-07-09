package com.qudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qudi.bean.GoodsImg;
import com.qudi.service.GoodsImgDaoService;
/**
 * 
 * @author AlanAtlantis
 *
 */
@Controller
@RequestMapping("/sys/goodsImg")
public class GoodsImgController {
	@Autowired
	private GoodsImgDaoService goodsImgDaoService;

	@RequestMapping(value = "/selectGoodsImg", method = RequestMethod.GET)
	public String selectGoodsImg(@RequestParam("goodsId") int goodsId, Model model) {
		// 商品图片查询
		model.addAttribute("goodsImg", goodsImgDaoService.selectGoodsImg(goodsId));
		return "goodsUploadImg";
	}

	@RequestMapping(value = "/updateImg", method = RequestMethod.GET)
	public String updateImg(GoodsImg goodsImg, Model model, @RequestParam("goodsId") int goodsId) {
		model.addAttribute("goodsId", goodsId);
		// 修改商品图片
		model.addAttribute("message", goodsImgDaoService.updateImg(goodsImg));
		model.addAttribute("goodsImg", goodsImgDaoService.selectGoodsImg(goodsId));
		return "uploadImg";
	}

	@RequestMapping(value = "/deleteImg", method = RequestMethod.GET)
	public String deleteImg(@RequestParam("picId") int picId, Model model, @RequestParam("goodsId") int goodsId) {
		model.addAttribute("goodsId", goodsId);
		// 删除图片
		model.addAttribute("message", goodsImgDaoService.deleteImg(picId));
		model.addAttribute("goodsImg", goodsImgDaoService.selectGoodsImg(goodsId));
		return "uploadImg";

	}

	/**
	 * 测试方法
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		
		// model.addAttribute("message", goodsImgDaoService.deleteImg(picId));
		GoodsImg goodsIng = new GoodsImg();
		goodsIng.setGoodsId(1);
		goodsIng.setIsMain(1);
		goodsIng.setPicSort(1);
		goodsIng.setPicUrl("aa");
		goodsImgDaoService.addGoodsImg(goodsIng);
		return "goodsUploadImg";

	}

}
