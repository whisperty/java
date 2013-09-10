package com.bachk.ssys.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class AppUtil {

	public static void addHeaderCell(HSSFWorkbook workbook, HSSFRow row, short column, String header) {
		HSSFCell cell = row.createCell(column);
		cell.setCellStyle(getHeaderStyle(workbook));
		HSSFRichTextString text = new HSSFRichTextString(header);
		cell.setCellValue(text);
	}
	
	public static void addValueCell(HSSFWorkbook workbook, HSSFRow row, short column, String value) {
		HSSFCell cell = row.createCell(column);
		HSSFRichTextString text = new HSSFRichTextString(value);
		cell.setCellValue(text);
	}
	
	public static void addValueCell(HSSFWorkbook workbook, HSSFRow row, short column, Double value) {
		HSSFCell cell = row.createCell(column);
		cell.setCellValue(value);
	}
	
	public static HSSFCellStyle getHeaderStyle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setFontName("Arial");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setWrapText(true);
		headerStyle.setFont(font);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
		return headerStyle;
	}
	
	public static boolean isZero(double value){
		if (Math.abs(value) < 0.0001){
			return true;
		}
		return false;
	}
	
}
