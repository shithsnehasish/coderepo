package com.dell.coe.upload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dell.coe.pts.vo.ProjectTechnologyStackVO;
import com.dell.coe.pts.vo.ProjectVO;
import com.dell.coe.pts.vo.TechnologyCategoryVO;
import com.dell.coe.pts.vo.TechnologyStackVO;
import com.dell.coe.upload.util.ExcelUtil;


@Controller
public class UploadController {
	
	@RequestMapping(value = "/fileUpload.dell", method = RequestMethod.GET)
	public ModelAndView loadFileUploadPage(Model model) {
		return new ModelAndView("upload/fileUpload");
	}
	
	@RequestMapping(value = "/upload.dell")
	public String uploadExcel(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("file") MultipartFile excelFilePath) throws IOException
	{
		File file = ExcelUtil.convert(excelFilePath);
		try(FileInputStream inputStream = new FileInputStream(new File(file.getName()));)
   	 {
   		 Workbook workbook = ExcelUtil.getWorkBook(inputStream,excelFilePath.getOriginalFilename());
   		 Sheet projectInfoSheet = workbook.getSheetAt(0);
		 ProjectVO project = ExcelUtil.readProjectInfo(projectInfoSheet);
   		 Sheet techStackSheet = workbook.getSheetAt(1);
//   		 System.out.println("Tech Stack Sheet Name: " + techStackSheet.getSheetName());
		 Set<ProjectTechnologyStackVO> techStackset = ExcelUtil.readTechStack(techStackSheet);
		
		 RestTemplate restTemplateforTechnologyStack = new RestTemplate();
		 String getAllTechnologyStackUrl="http://localhost:9090/PTS/rest/technologystack/getAllTechnologyStack/";
		 Map<String,ProjectTechnologyStackVO> storeProjectTechnologyStackVOMap = new TreeMap<String, ProjectTechnologyStackVO>(String.CASE_INSENSITIVE_ORDER);
		 TechnologyStackVO[] techArray=	 (restTemplateforTechnologyStack.getForObject(getAllTechnologyStackUrl, TechnologyStackVO[].class));
		 if(null!=techArray){
			 List<TechnologyStackVO> storedTechnologyCategoryList =  Arrays.asList(techArray);
			 for(TechnologyStackVO technologyStack : storedTechnologyCategoryList){
				 ProjectTechnologyStackVO projectTechnologyStackVOObj = new ProjectTechnologyStackVO();
				 projectTechnologyStackVOObj.setTechName(technologyStack.getTechName());
				 projectTechnologyStackVOObj.setTechnologyStackId(technologyStack.getTechnologyStackId());
				 projectTechnologyStackVOObj.setTechVersion(technologyStack.getTechVersion());
				 projectTechnologyStackVOObj.setTechnologycategory(technologyStack.getTechnologycategory());
				 storeProjectTechnologyStackVOMap.put(technologyStack.getTechName()+"&"+technologyStack.getTechVersion(), projectTechnologyStackVOObj);
			 }	 
		 }
		
		 
		 Set<ProjectTechnologyStackVO> technologyStacks = new HashSet<ProjectTechnologyStackVO>();
		 for (ProjectTechnologyStackVO technologyStack : techStackset) {
			 ProjectTechnologyStackVO stack = new ProjectTechnologyStackVO();
			 if(technologyStack != null && technologyStack.getTechName() != null){
				 if((!storeProjectTechnologyStackVOMap.isEmpty()) && (istechnologyStackExist(storeProjectTechnologyStackVOMap,technologyStack)))
				 {
					 ProjectTechnologyStackVO temp = storeProjectTechnologyStackVOMap.get(technologyStack.getTechName()+"&"+technologyStack.getTechVersion());
					 if (temp != null && temp.getTechnologyStackId() != null) {
						 technologyStacks.add(temp);
					 } else {
						 System.out.println("Error: Tech Stack is null.");//TODO
					 }
				 }
				 else{
				 RestTemplate restTemplate = new RestTemplate();
				 String categoryName = technologyStack.getTechnologycategory().getCatName();
				 String retreiveCategoryByNameUrl="http://localhost:9090/PTS/rest/technologyCategoryService/retrieveTechnologyCategorybyName/"+categoryName;
				 TechnologyCategoryVO technologyCategory = restTemplate.getForObject(retreiveCategoryByNameUrl, TechnologyCategoryVO.class);				 
				 stack.setTechName(technologyStack.getTechName());
				 stack.setTechVersion(technologyStack.getTechVersion());
				 stack.setTechnologycategory(technologyCategory);
				 technologyStacks.add(stack);
				 }
			 }
		}
		 
		 project.setTechnologystack(technologyStacks);
		 RestTemplate restTemplate = new RestTemplate();
		 String createProjectUrl="http://localhost:9090/PTS/rest/project/createProject";
		 ProjectVO result = restTemplate.postForObject( createProjectUrl, project, ProjectVO.class);
		 
		/* RestTemplate template = new RestTemplate();
		 String createTechnologyStackUrl = "http://160.110.220.63:19092/PTS/technologystack/createTechnologyStack";
		 TechnologyStack stack = restTemplate.postForObject( createTechnologyStackUrl, technologyStacks, TechnologyStack.class);*/
		 System.out.println(result);
		 
   	 }catch (Exception e) {
   		 e.printStackTrace();
   		 
		}
	
		return "redirect:fileUpload.dell";
		
	}

	private boolean istechnologyStackExist(Map<String,ProjectTechnologyStackVO> storeProjectTechnologyStackVOMap, ProjectTechnologyStackVO technologyStack){
		for(String entry : storeProjectTechnologyStackVOMap.keySet()){
			if(entry.equalsIgnoreCase(technologyStack.getTechName()+"&"+technologyStack.getTechVersion())){
				//technologyStacks.add(storeProjectTechnologyStackVOMap.get(technologyStack.getTechName()+"&"+technologyStack.getTechVersion()));	 
				return true;
			}
		}
		return false;
	}
	
}
