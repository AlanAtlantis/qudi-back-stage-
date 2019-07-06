package com.qudi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadFromFile {

	public static void readFile(String name, String aa) throws IOException {
		File file = new File(name);

		InputStream in = null;

		System.out.println("以字节为单位读取文件内容，一次读一个字节");

		in = new FileInputStream(file);

		OutputStream out = new FileOutputStream(aa);

		int tempbyte;

		while ((tempbyte = in.read()) != -1) {
			out.write(tempbyte);
		}

		in.close();
		out.close();
	}

	public static void readFiles(String name, String aa) throws IOException {

		// 一次读取多个字节,用于存储字节
		byte[] tempbyte = new byte[1024];
		// 读取图片文件
		InputStream in = new FileInputStream(name);
		// 写入到目标文件中
		OutputStream out = new FileOutputStream(aa);
		int len = 0;
		// 图片循环读取到tempbyte中
		while ((len = in.read(tempbyte)) != -1) {
			// 写入
			out.write(tempbyte, 0, len);
		}

		in.close();
		out.close();
	}

	public static void deleteFile(String name) {
		File file = new File(name);
		if (file.exists())
			file.delete();
	}

	public static void main(String[] args) {
		/*
		 * try { readFiles("C:/aaaa.jpg", "C://ff.jpg"); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		deleteFile("c:/ff.jpg");
	}
}
