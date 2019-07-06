package com.qudi.service;

import org.springframework.stereotype.Service;

import com.qudi.util.MessageUtil;
/**
 * 
 * @author AlanAtlantis
 *
 */
public interface GoodsCategoryDaoService {

	MessageUtil selectGoodsCategory();

	MessageUtil selectGoodsCategoryLevel(int id, int categoryLevel);

}
