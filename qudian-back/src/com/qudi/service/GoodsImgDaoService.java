package com.qudi.service;

import com.qudi.bean.GoodsImg;
import com.qudi.util.MessageUtil;
/**
 * 
 * @author AlanAtlantis
 *
 */
public interface GoodsImgDaoService {

	MessageUtil addGoodsImg(GoodsImg goodsImg);

	MessageUtil selectGoodsImg(int goodsId);

	MessageUtil updateImg(GoodsImg goodsImg);

	MessageUtil deleteImg(int picId);
	
	MessageUtil updateMian(int isMain,int picId);
	
	MessageUtil queryIsMain(int goodsId);

}
