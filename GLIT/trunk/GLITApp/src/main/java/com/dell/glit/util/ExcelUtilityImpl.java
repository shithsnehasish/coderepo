package com.dell.glit.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExcelUtilityImpl implements ExcelUtility {

	private final Log logger = LogFactory.getLog(getClass());
	
	public List<XSSFSheet> getSheetList(XSSFWorkbook workbook) {
		// TODO Auto-generated method stub
		List<XSSFSheet> sheetList = null;
		try {
			int sheetCount = workbook.getNumberOfSheets();
			sheetList = new ArrayList<XSSFSheet>();
			for (int index = 0; index < sheetCount; index++) {
				sheetList.add(workbook.getSheetAt(index));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheetList;
	}

	public List<String> getSheetColumn(XSSFSheet sheet) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, String>> getSheetColumnData(XSSFSheet sheet) {
		// TODO Auto-generated method stub
		return null;
	}

	public XSSFWorkbook getWorkbook(InputStream file) {
		// TODO Auto-generated method stub
		try {
			return new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ExcelDTO getFormDTOFromExcelSheetsList(InputStream file) {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = getWorkbook(file);
		// Get first/desired sheet from the workbook
		List<XSSFSheet> sheetList = getSheetList(workbook);

		ExcelDTO excelDTO = new ExcelDTO();
		List<FormDTO> formList = new ArrayList<FormDTO>();
		FormDTO formDTO = null;
		List<String> fieldNames = null;
		List<Map<String, String>> listOfValue = null;
		Map<String, String> valueList = null;
		Map<String, String> errorMap = new HashMap<String, String>();
		for (XSSFSheet sheet : sheetList) {
			// System.out.println("===SHEET-NAME==>" + sheet.getSheetName());
			if (checkFormName(sheet.getSheetName())) {
				formDTO = new FormDTO();
				formDTO.setFormName(sheet.getSheetName());
				Row row = sheet.getRow(0);
				if (row != null) {
					logger.info("=========COLUMN INFOMRATION IS NOT NULL===========");
					// System.out.println(row.getFirstCellNum() + "=====" +
					// row.getLastCellNum());
					fieldNames = new ArrayList<String>();
					for (int cn = 0; cn < row.getLastCellNum(); cn++) {
						Cell c = row.getCell(cn);
						// System.out.println(c.getStringCellValue());
						if (c.CELL_TYPE_NUMERIC == c.getCellType()
								&& StringUtils.isNotBlank(Integer.toString((int) c.getNumericCellValue()))) {
							// System.out.println("=====CELL-VALUE==>" + (int)
							// c.getNumericCellValue());
							fieldNames.add(Integer.toString((int) c.getNumericCellValue()));
						} else if (c.CELL_TYPE_STRING == c.getCellType()
								&& StringUtils.isNotBlank(c.getStringCellValue())) {
							fieldNames.add(c.getStringCellValue());
						}
					}
					logger.info("==========fieldNames==========" + fieldNames.size());
					if(fieldNames!=null && fieldNames.size()==0){
						logger.info("=========COLUMN-LIST INFOMRATION IS ====>NULL<===========");
						errorMap.put(sheet.getSheetName(), "Based on specification, this name does not fall in Form Name criteria");
					}
				} else {
					// System.out.println("ROW IS NULL");
					fieldNames = null;
					logger.info("=========COLUMN INFOMRATION IS ====>NULL<===========");
					errorMap.put(sheet.getSheetName(), "Based on specification, this name does not fall in Form Name criteria");
				}
				formDTO.setFieldsName(fieldNames);
				// System.out.println("===SHEET==DATA=ROW==COUNT===>" +
				// sheet.getLastRowNum());
				listOfValue = new ArrayList<Map<String, String>>();
				for (int cn = 1; cn <= sheet.getLastRowNum(); cn++) {

					Row row2 = sheet.getRow(cn);
					// System.out.println("==ROW==>" + row2.getLastCellNum());
					if (row2 != null) {
						valueList = new HashMap<String, String>();
						for (short cm = 0; cm < row2.getLastCellNum(); cm++) {
							Cell c1 = row2.getCell(cm);
							if (c1 != null) {
								if (c1.CELL_TYPE_NUMERIC == c1.getCellType()) {
									// System.out.println("=====CELL-VALUE==>" +
									// (int) c1.getNumericCellValue());
									valueList.put(row.getCell(cm).getStringCellValue(),
											Integer.toString((int) c1.getNumericCellValue()));
								}
								if (c1.CELL_TYPE_STRING == c1.getCellType()) {
									// System.out.println("=====CELL-VALUE==>" +
									// c1.getStringCellValue());
									valueList.put(row.getCell(cm).getStringCellValue(), c1.getStringCellValue());
								}
							} else {
								// System.out.println("ROW IS NULL");
							}
						}
						listOfValue.add(valueList);
					} else {
						// System.out.println("ROW IS NULL");
					}
				}
				formDTO.setFieldsData(listOfValue);
				formList.add(formDTO);
			} else {
//				System.out.println("===============ITS NOT A FORM===========>" + sheet.getSheetName());
				errorMap.put(sheet.getSheetName(), "Based on specification, this name does not fall in Form Name criteria");
			}
		}
		excelDTO.setFormList(formList);
		excelDTO.setErrorList(errorMap);
		return excelDTO;
	}

	private boolean checkFormName(String formName) {
		String[] val = formName.split("-");
		if (val.length > 1 && val[1].equals("Form")) {
			return true;
		} else {
			return false;
		}
	}

}
