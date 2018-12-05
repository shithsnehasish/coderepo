/**
 * 
 */
package com.dell.coe.upload.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import com.dell.coe.pts.vo.ProjectTechnologyStackVO;
import com.dell.coe.pts.vo.ProjectVO;
import com.dell.coe.pts.vo.TechnologyCategoryVO;



/**
 * @author SNEHASISH_SHITH
 *
 */
public class ExcelUtil {


	public static ProjectVO readProjectInfo(Sheet projectInfoSheet) throws IOException {
    	
			List<String> projectInfo = new ArrayList<>();
    		 Iterator<Row> iterator = projectInfoSheet.iterator();
    		 
    		 ProjectVO project = new ProjectVO();
    		 while (iterator.hasNext()) {
    		        Row nextRow = iterator.next();
    		        if(nextRow.getRowNum()==0 || nextRow.getRowNum()==1 || nextRow.getRowNum()==2){
 		        	   continue; //just skip the rows if row number is 0 or 1 or 2
 		        	  }
    		        Iterator<Cell> cellIterator = nextRow.cellIterator();
    		 
    		        while (cellIterator.hasNext()) {
    		            Cell nextCell = cellIterator.next();
    		            //int columnIndex = nextCell.getColumnIndex();
    		            if(nextCell.getColumnIndex() == 2)
    		            projectInfo.add((String) getCellValue(nextCell));
    		 
    		           /* switch (2) {
    		            case 1:
    		                break;
    		            case 2:
    		            	project.setProjectManager((String) getCellValue(nextCell));
    		                break;
    		            case 2:
    		            	 projectInfo.add((String) getCellValue(nextCell));
    		                break;
    		            }*/
    		        }
    		    }
    		 if(projectInfo!=null)
    		 {
    			project.setProjName((String) projectInfo.get(0));
    			project.setProjType((String) projectInfo.get(2));
    		 }
    		 
    		 return project;
	}
	
	public static Set<ProjectTechnologyStackVO> readTechStack(Sheet techStackSheet) throws IOException {
		Set<ProjectTechnologyStackVO> techStacks = new HashSet<ProjectTechnologyStackVO>();
    	
    		 Iterator<Row> iterator = techStackSheet.iterator();
    		 
    		 while (iterator.hasNext()) {
    		        Row nextRow = iterator.next();
    		        if(nextRow.getRowNum()==0 || nextRow.getRowNum()==1 || nextRow.getRowNum()==2){
    		        	   continue; //just skip the rows if row number is 0 or 1
    		        	  }
    		        Iterator<Cell> cellIterator = nextRow.cellIterator();
    		        ProjectTechnologyStackVO techStack = new ProjectTechnologyStackVO();
    		 
    		        while (cellIterator.hasNext()) {
    		            Cell nextCell = cellIterator.next();
    		            int columnIndex = nextCell.getColumnIndex();
    		            if(getCellValue(nextCell) !=null)
    		            {
    		            	switch (columnIndex) {
    		            	case 1:
    		            		TechnologyCategoryVO technologyCategory = new TechnologyCategoryVO();
    		            		technologyCategory.setCatName(((String) getCellValue(nextCell)));
    		            		techStack.setTechnologycategory(technologyCategory);
    		            		break;
    		            	case 2:
    		            		techStack.setTechName((String) getCellValue(nextCell));
    		            		break;
    		            	case 3:
    		            		String version = getCellValue(nextCell)+"";
    		            		techStack.setTechVersion(version.replaceAll(" ", ""));
    		            		break;
    		            	}
    		            }
    		        }
    		        if(techStack!=null&&techStack.getTechName()!=null)
    		        {
    		        	techStacks.add(techStack);
    		        }
    		    }
			return techStacks;
	}
	
	
	

	public static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();
     
        case Cell.CELL_TYPE_BOOLEAN:
            return cell.getBooleanCellValue();
     
        case Cell.CELL_TYPE_NUMERIC:
            return cell.getNumericCellValue();
        }
     
        return null;
    }
    public static Workbook getWorkBook(FileInputStream inputStream, String excelFilePath) throws IOException {
		
		
        Workbook workbook = null;
        
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
     
        return workbook;
        	
    }

    public static File convert(MultipartFile file) throws IOException
    {    
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile(); 
        FileOutputStream fos = new FileOutputStream(convFile); 
        fos.write(file.getBytes());
        fos.close(); 
        return convFile;
    }

}
