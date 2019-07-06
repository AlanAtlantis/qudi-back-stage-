package com.qudi.service;

import com.qudi.util.MessageUtil;

/**
 * 
 * @author AlanAtlantis
 *
 */
public interface GoodsBargainingDaoService {

	MessageUtil queryBar(int goodsId);

	MessageUtil updatebar(int bargainingStatus, int bargainingId);

}
