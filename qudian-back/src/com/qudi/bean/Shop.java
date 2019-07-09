package com.qudi.bean;

public class Shop {

	private int shopId;
	private String shopName;// 名称
	private int shopStatus;// 状态
	private int shopLevel;// 等级
	private String createTime;// 创建时间
	private String examineTime;// 审核时间
	private int userId;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Shop [shopId=" + shopId + ",shopName=" + shopName + ",shopStatus=" + shopStatus + ",userId=" + userId
				+ ",shopLevel=" + shopLevel + ",createTime=" + createTime + ",createTime=" + createTime + "]";
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(int shopStatus) {
		this.shopStatus = shopStatus;
	}

	public int getShopLevel() {
		return shopLevel;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setShopLevel(int shopLevel) {
		this.shopLevel = shopLevel;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getExamineTime() {
		return examineTime;
	}

	public void setExamineTime(String examineTime) {
		this.examineTime = examineTime;
	}

}
