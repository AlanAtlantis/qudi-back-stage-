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

import com.google.gson.JsonObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ReadExcel {

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
			/*
			 * toJson(list); map(list);
			 */
			System.out.println("");
		}
		/*
		 * } catch (Exception e) { System.out.println("已运行xlRead() : " +
		 * e.getMessage()); }
		 */
	}

	public static String toJson(List object) {
		JSONArray json = JSONArray.fromObject(object);
		System.out.println(json);
		return json.toString();
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
