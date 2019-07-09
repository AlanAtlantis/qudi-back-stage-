package com.qudi.bean;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * ��Ʒ��Ϣ
 * 
 * @author AlanAtlantis
 *
 */
public class GoodsList {

	private int goodsId;//
	private int categoryId;// 分类id
	private String goodsName;// 商品名称
	private String goodsAs;// 关键字
	private String goodsLabel;// 标签
	private String goodsDesc;// 详情
	private BigDecimal goodsPrice;// 价格
	private double goodsDiscount; // 折扣
	private String goodsSource;// 发货来源
	private int userId;// 用户id
	private int goodsStatus;// 状态״̬
	private String createTime;// 创建时间

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoodsList [goodsId=" + goodsId + ",categoryId=" + categoryId + ",goodsName=" + goodsName + ",goodsAs="
				+ goodsAs + ",goodsLabel=" + goodsLabel + ",goodsDesc=" + goodsDesc + ",goodsPrice=" + goodsPrice
				+ ",goodsDiscount=" + goodsDiscount + ",goodsSource=" + goodsSource + ",userId=" + userId
				+ ",goodsStatus=" + goodsStatus + ",createTime=" + createTime + "]";
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsAs() {
		return goodsAs;
	}

	public void setGoodsAs(String goodsAs) {
		this.goodsAs = goodsAs;
	}

	public String getGoodsLabel() {
		return goodsLabel;
	}

	public void setGoodsLabel(String goodsLabel) {
		this.goodsLabel = goodsLabel;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public double getGoodsDiscount() {
		return goodsDiscount;
	}

	public void setGoodsDiscount(double goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}

	public String getGoodsSource() {
		return goodsSource;
	}

	public void setGoodsSource(String goodsSource) {
		this.goodsSource = goodsSource;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
