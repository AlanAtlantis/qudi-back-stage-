package com.qudi.util;

/**
 * 返回信息
 * 
 * @author AlanAtlantis
 *
 */
public class MessageUtil {

	private Object object;//返回参数

	private String info;//返回信息

	private Result result=Result.FAILED;//返回状态

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MessageUtil [object=" + object + ",info=" + info + ",result=" + result + "]";
	}
}
