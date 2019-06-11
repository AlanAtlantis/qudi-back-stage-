package com.qudi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MakeOrderNum
 * @CreateTime 2015年9月13日 下午4:51:02
 * @author : mayi
 * @Description: 订单号生成工具,生成非重复订单号,理论上限1毫秒1000个,可扩展
 **/
public class MakeOrderNum {
	/**
	 * 锁对象,可以为任意对象
	 */
	private static Object lockObj = "lockerOrder";
	/**
	 * 订单号生成计数器
	 */
	private static long orderNumCount = 0L;
	/**
	 * 每毫秒生成订单号数量最大值
	 */
	private static int maxPerMSECSize = 999;

	/**
	 * 生成非重复订单号,理论上限1毫秒1000个,可扩展
	 * 
	 * @param tname 测试用
	 */
	public static String makeOrderNum(String tname) {
		// 最终生成的订单号
		String finOrderNum = "";
		try {
			synchronized (lockObj) {
				// 取系统当前时间作为订单号变量前半部分,精确到毫秒
				long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
				// 计数器到最大值归零,可扩展更大,目前1毫秒处理峰值1000个,1秒100万
				if (orderNumCount > maxPerMSECSize) {
					orderNumCount = 0L;
				}
				// 组装订单号
				if (orderNumCount < 10) {
					finOrderNum = nowLong + "00" + orderNumCount;
				}
				if (orderNumCount > 9 && orderNumCount < 100) {
					finOrderNum = nowLong + "0" + orderNumCount;
				}
				if (orderNumCount > 99) {
					finOrderNum = nowLong + "" + orderNumCount;
				}
				orderNumCount++;
				// System.out.println(finOrderNum + "--" + Thread.currentThread().getName() +
				// "::" + tname);
				// Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finOrderNum;
	}

	public static String makeOrderNums() {
		// 最终生成的订单号
		String finOrderNum = "";
		try {
			synchronized (lockObj) {
				// 取系统当前时间作为订单号变量前半部分,精确到毫秒
				long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
				// 计数器到最大值归零,可扩展更大,目前1毫秒处理峰值1000个,1秒100万
				if (orderNumCount > maxPerMSECSize) {
					orderNumCount = 0L;
				}
				// 组装订单号
				if (orderNumCount < 10) {
					finOrderNum = nowLong + "00" + orderNumCount;
				}
				if (orderNumCount > 9 && orderNumCount < 100) {
					finOrderNum = nowLong + "0" + orderNumCount;
				}
				if (orderNumCount > 99) {
					finOrderNum = nowLong + "" + orderNumCount;
				}
				orderNumCount++;
				// System.out.println(finOrderNum + "--" + Thread.currentThread().getName() +
				// "::" + tname);
				// Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finOrderNum;
	}

	public static void main(String[] args) {
		// 测试多线程调用订单号生成工具
		try {
			for (int i = 0; i < 200; i++) {
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						MakeOrderNum makeOrder = new MakeOrderNum();
						makeOrder.makeOrderNum("a");
					}
				}, "at" + i);
				t1.start();
				Thread t2 = new Thread(new Runnable() {
					public void run() {
						MakeOrderNum makeOrder = new MakeOrderNum();
						makeOrder.makeOrderNum("b");
					}
				}, "bt" + i);
				t2.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
