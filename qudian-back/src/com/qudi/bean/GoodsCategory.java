package com.qudi.bean;

/**
 * ��Ʒ����
 * 
 * @author AlanAtlantis
 *
 */
public class GoodsCategory {

	private int categoryId;
	private String categoryName;// ��������
	private int pid;// ����id
	private int categoryLevel;// �㼶
	private int categorySort;// ����
	private int categoryStatus;// ״̬
	private String createTime;// ����ʱ��

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoodsCategory [categoryId=" + categoryId + ",categoryName=" + categoryName + ",pid=" + pid
				+ ",categoryLevel=" + categoryLevel + ",categorySort=" + categorySort + ",categoryStatus="
				+ categoryStatus + ",createTime=" + createTime + "]";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public int getCategorySort() {
		return categorySort;
	}

	public void setCategorySort(int categorySort) {
		this.categorySort = categorySort;
	}

	public int getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(int categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
