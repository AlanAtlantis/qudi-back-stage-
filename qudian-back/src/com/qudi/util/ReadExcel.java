package com.qudi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.qudi.bean.GoodsList;
import com.qudi.bean.SysUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ReadExcel {

	@Test
	public static void main(String[] args) {
		// readExcel(new File("F:\\exam\\manager-exam\\WebContent\\document\\aa.xls"));
		try {
			getValues("c:\\aa1.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getValues(String filePath) throws IOException {
		String values = null;
		// try {
		InputStream is = new FileInputStream(filePath);
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = new XSSFWorkbook(is);
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.getSheetAt(0);
		// 定义 row、cell
		XSSFRow row;
		String cell;
		System.out.println(sheet.getPhysicalNumberOfRows());
		// 循环输出表格中的内容
		for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
			// 获取表的行
			row = sheet.getRow(i);
			List list = new ArrayList();
			// System.out.println(row.getPhysicalNumberOfCells());
			for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
				// 通过 row.getCell(j).toString() 获取单元格内容，
				if (row.getCell(j) != null) {
					cell = row.getCell(j).toString();
					list.add(cell);
					// System.out.println(cell);
					System.out.print(cell + "\t");
				}

			}
			toJson(list);
			System.out.println("");
		}
		/*
		 * } catch (Exception e) { System.out.println("已运行xlRead() : " +
		 * e.getMessage()); }
		 */
	}

	public static String toJson(List list) {
		JSONObject json = new JSONObject();
		json.put("goodsName", "");
		json.put("goodsAs", "");
		json.put("goodsLabel", "");
		json.put("goodsPrice", "");
		json.put("goodsSource", "");
		json.put("goodsDesc", "");
		json.put("categoryId", "");

		JSONObject json1 = new JSONObject();
		json1.put("detailsDescribe", "");
		json1.put("shop", "");

		Iterator<String> iterator = json.keys();
		Iterator<String> iterator1 = json1.keys();

		if (list.size() > 1) {
			for (int i = 0; i < list.size(); i++) {
				// 获取商品基本信息
				while (iterator.hasNext()) {
					String key = iterator.next();
					String value = json.getString(key);
					if (value.length() <= 0) {
						json.put(key, list.get(i));
						break;
					}

				}

			}

			// 获取店铺信息以及商品描述
			while (iterator1.hasNext()) {
				String key = iterator1.next();
				String value = json1.getString(key);
				System.out.println("value" + value);
				if (value.length() <= 0) {
					json1.put(key, list.get(list.size() - 2));
					break;
				}

			}
			GoodsList user = new GoodsList();
			GoodsList u = (GoodsList) JSONObject.toBean(json, user.getClass());

			System.out.println("\n" + u + "\n" + json1);
		}

		return "";
	}

	public static void map(List list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsName", null);
		map.put("goodsAs", null);
		map.put("goodsLabel", null);
		map.put("goodsPrice", null);
		map.put("goodsSource", null);
		map.put("goodsDesc", null);
		map.put("categoryId", null);

		for (int i = 0; i < list.size(); i++) {

			for (String str : map.keySet()) {
				if (map.get(str) != null) {
					break;
				}
				map.put(str, list.get(i));
			}
		}

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("detailsDescribe", null);
		map1.put("shop", null);
		System.out.println(map.toString());
	}

	public static List readExcel(File file) {
		List list = new ArrayList();

		try {
			// 读取文件
			// FileInputStream fis = new FileInputStream(file);
			// 创建输入流读取excel
			InputStream is = new FileInputStream(file);

			POIFSFileSystem fs = new POIFSFileSystem(is);

			HSSFWorkbook wb = new HSSFWorkbook(fs);

			// 获取sheet
			HSSFSheet sheet = wb.getSheetAt(0);

			System.out.println("输出sheet:" + sheet);

			// 总行数
			int rowNum = sheet.getPhysicalNumberOfRows();

			System.out.println("行数row：" + rowNum);

			// 获取第一行
			int sheetCount = wb.getNumberOfSheets();

			System.out.println("第一行：" + sheetCount);

			for (int i = 0; i < sheetCount; i++) {
				sheet = wb.getSheetAt(i);

				rowNum = sheet.getPhysicalNumberOfRows();
				int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();

				for (int j = 0; i < rowNum; j++) {
					HSSFRow row = sheet.getRow(j);
					System.out.println("行：" + row);
					for (short k = 0; k < cellNum; k++) {
						HSSFCell cell = row.getCell(k);
						System.out.println("cell:" + cell);
						if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							System.out.println(cell.getStringCellValue());
						} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							System.out.println(cell.getNumericCellValue());
						} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
							System.out.println(cell.getBooleanCellValue());
						} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
							System.out.println("NULL");
						} else {
							System.out.println(cell.getDateCellValue());
						}

					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
