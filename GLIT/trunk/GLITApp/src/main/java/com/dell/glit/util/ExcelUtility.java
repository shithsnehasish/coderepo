package com.dell.glit.util;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelUtility {

	public XSSFWorkbook getWorkbook(InputStream file);
	public List<XSSFSheet> getSheetList(XSSFWorkbook workbook);
	public List<String> getSheetColumn(XSSFSheet sheet);
	public List<Map<String, String>> getSheetColumnData(XSSFSheet sheet);
	public ExcelDTO getFormDTOFromExcelSheetsList(InputStream file);
}
