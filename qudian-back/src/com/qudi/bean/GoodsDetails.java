package com.qudi.bean;
/**
 * 
 * @author AlanAtlantis
 *
 */
public class GoodsDetails {

	private int detailsId;// ������id
	private String detailsDescribe;// ��Ʒ����
	private int goodsId;// ��Ʒid
	private String createTime;// ����ʱ��

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
