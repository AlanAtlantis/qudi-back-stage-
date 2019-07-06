package com.qudi.bean;
/**
 * 
 * @author AlanAtlantis
 *
 */
public class GoodsDetails {

	private int detailsId;// 描述表id
	private String detailsDescribe;// 商品描述
	private int goodsId;// 商品id
	private String createTime;// 创建时间

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoodsDetails [detailsId=" + detailsId + ",detailsDescribe=" + detailsDescribe + ",goodsId=" + goodsId
				+ ",createTime=" + createTime + "]";
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

	public String getDetailsDescribe() {
		return detailsDescribe;
	}

	public void setDetailsDescribe(String detailsDescribe) {
		this.detailsDescribe = detailsDescribe;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
