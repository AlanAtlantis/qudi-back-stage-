package com.qudi.bean;

/**
 * ��ƷͼƬ
 * 
 * @author AlanAtlantis
 *
 */
public class GoodsImg {

	private int picId;
	private int goodsId;// ��Ʒid
	private String picUrl;// ��ת��ַ
	private int picSort;// ˳��
	private int isMain;// �Ƿ�����ͼ
	private String createTime;// ����ʱ��

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoodsImg [picId=" + picId + ",goodsId=" + goodsId + ",picUrl=" + picUrl + ",picSort=" + picSort
				+ ",isMain=" + isMain + ",createTime=" + createTime + "]";
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public int getPicSort() {
		return picSort;
	}

	public void setPicSort(int picSort) {
		this.picSort = picSort;
	}

	public int getIsMain() {
		return isMain;
	}

	public void setIsMain(int isMain) {
		this.isMain = isMain;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
