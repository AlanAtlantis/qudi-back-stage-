package com.qudi.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

	private static final String slat = "&6^53#&qudi&@#*&";

	/**
	 * MD5º”√‹
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) {
		String base = str + "/" + slat;
		String MD5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return MD5;
	}
	
	
	public static void main(String [] arg) {
		
		System.out.println(getMD5("123456"));

	}

}
