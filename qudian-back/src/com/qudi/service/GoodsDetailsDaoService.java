package com.qudi.service;

import com.qudi.util.MessageUtil;

public interface GoodsDetailsDaoService {

	MessageUtil addDetails(String detailsDescribe, int goodsId);

	MessageUtil querydetails(int goodsId);

	MessageUtil updatedetails(String detailsDescribe, int goodsId);

}
