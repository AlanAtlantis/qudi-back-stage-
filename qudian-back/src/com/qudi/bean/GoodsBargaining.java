package com.qudi.bean;

import java.math.BigInteger;

/**
 * �����Ϣ
 * 
 * @author AlanAtlantis
 *
 */
public class GoodsBargaining {

	private int bargainingId;// ��۱�id
	private Long bargainingPrice;// ��Ʒ�۸�
	private int priceType;// �۸�����
	private int userId;// �û�id
	private int goodsId;// ��Ʒid
	private String bargainingRemark;// ��ע
	private int bargainingStatus;// ״̬
	private String createTime;// ����ʱ��

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoodsBargaining [bargainingId=" + bargainingId + ",bargainingPrice=" + bargainingPrice + ",priceType="
				+ priceType + ",userId=" + userId + ",goodsId=" + goodsId + ",bargainingRemark=" + bargainingRemark
				+ ",bargainingStatus=" + bargainingStatus + ",createTime=" + createTime + "]";
	}

	public int getBargainingId() {
		return bargainingId;
	}

	public void setBargainingId(int bargainingId) {
		this.bargainingId = bargainingId;
	}

	public Long getBargainingPrice() {
		return bargainingPrice;
	}

	public void setBargainingPrice(Long bargainingPrice) {
		this.bargainingPrice = bargainingPrice;
	}

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getBargainingRemark() {
		return bargainingRemark;
	}

	public void setBargainingRemark(String bargainingRemark) {
		this.bargainingRemark = bargainingRemark;
	}

	public int getBargainingStatus() {
		return bargainingStatus;
	}

	public void setBargainingStatus(int bargainingStatus) {
		this.bargainingStatus = bargainingStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
