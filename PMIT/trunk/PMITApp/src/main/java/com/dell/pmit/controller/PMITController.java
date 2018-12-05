package com.dell.pmit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dell.pmit.model.IssueDetail;
import com.dell.pmit.model.Login;
import com.dell.pmit.model.Project;
import com.dell.pmit.service.PMITService;
import com.dell.pmit.util.PropertiesUtil;

/**
 * @author Santosh_Kumar14
 *
 */
@Controller
public class PMITController {
	private final String UPLOAD_DIRECTORY = PropertiesUtil.getProperty("file.upload.path");
	HttpSession session;
	
	@Autowired
	private PMITService pmitService;
	
	@RequestMapping(value="/home.spring", method = RequestMethod.GET)
	public String showForm(Model model) {
		List<Project> projects = pmitService.getAllProjects();
		IssueDetail issueDetail = new  IssueDetail();
		model.addAttribute("projectList", projects);
		model.addAttribute("issueDetail", issueDetail);
		return "home";
	}
	
	@RequestMapping(value="/submitForm.spring", method = RequestMethod.POST)
	public String processForm(@RequestParam("Upload")MultipartFile file,@ModelAttribute("issueDetail")IssueDetail issueDetail,
			BindingResult result,RedirectAttributes redirectAttributes,Model model,HttpServletResponse response,HttpServletRequest request) {
		List<String> filePaths = new ArrayList<String>();
		List<IssueDetail> issueDetails = pmitService.getAllIssueDetails();
		for (IssueDetail issueDetail2 : issueDetails) {
			filePaths.add(issueDetail2.getFilePath());
		}
		String uploadPath = null;
		try {
        	if(file.getSize() != 0) {
        	File dir = new File(this.calculateDestinationDirectory(issueDetail));
        	if(!dir.exists()) {
        		dir.mkdirs();
        	}
        	File multipartFile = new File(this.calculateDestinationPath(file, issueDetail,filePaths));
        	uploadPath = multipartFile.getPath();
			file.transferTo(multipartFile);
        	}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        if(result.hasErrors()){
			return "home";
		} else {
			issueDetail.setFilePath(uploadPath);
			issueDetail.setLoggedDate(new Date());
			issueDetail = pmitService.addIssueDetail(issueDetail);
			redirectAttributes.addFlashAttribute("message","<p style='font-size: 16px;padding: 8px;color: #468847;background-color: #dff0d8;border-color: #d6e9c6;'><strong>Success !</strong> Your request have been saved successfully</p>");
		return "redirect:/home.spring";
		}             
	}
	
	private String calculateDestinationPath(MultipartFile file, IssueDetail issueDetail, List<String> filePaths) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyHH-mm-ss");
    	String newPath = this.calculateDestinationDirectory(issueDetail);
    	newPath += "\\";
    	String[] fileName = file.getOriginalFilename().split("\\.");
    	for (int i = 0; i < fileName.length; i++) {
			if(i < fileName.length-2){
				newPath += fileName[i];
				newPath += ".";
			}
			if(i == fileName.length-2) {
				newPath += fileName[i];
				newPath += dateFormat.format(new Date());
				newPath += ".";
			}
			if(i == fileName.length-1) {
				newPath += fileName[i];
			}
		}
        return newPath;
	}

	private String calculateDestinationDirectory(IssueDetail issueDetail) {
		String destinationDir = UPLOAD_DIRECTORY;
        destinationDir += "\\";
        destinationDir += issueDetail.getProject().getProjectName();
        destinationDir += "\\";
        destinationDir += issueDetail.getIssueForProject();
        return destinationDir;
	}
	
	@RequestMapping(value="/login.spring", method = RequestMethod.GET)
	public String login(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}
	
	@RequestMapping(value="/authorizeUser.spring", method = RequestMethod.POST)
	public String authorizeUser(@ModelAttribute("login")Login login, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, BindingResult result) {
		session = request.getSession();
		Login loginDB = pmitService.getLogin(login.getUserName());
		if(loginDB != null) {
			if(login.getPassword().equals(loginDB.getPassword())) {
				session.setAttribute("userId", loginDB.getLoginId());
				return "redirect:/dashboard.spring";
			} else {
				redirectAttributes.addFlashAttribute("error", "<p style='font-size: 16px;padding: 8px;color: #b94a48;background-color: #f2dede;border-color: #eed3d7;' aling='center'><strong>Error !</strong>  Password is wrong</p>");
				return "redirect:/login.spring";
			}
		} else {
			redirectAttributes.addFlashAttribute("error", "<p style='font-size: 16px;padding: 8px;color: #b94a48;background-color: #f2dede;border-color: #eed3d7;' aling='center'><strong>Error !</strong>  User does not exist. Please Contact Administrator for further details.</p>");
			return "redirect:/login.spring";
		}
	}
	
	@RequestMapping(value="/dashboard.spring", method = RequestMethod.GET)
	public String showDashboard(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			List<IssueDetail> issueDetails = pmitService.getAllIssueDetails();
			model.addAttribute("issueList", issueDetails);
			return "dashboard";
		} else {
			redirectAttributes.addFlashAttribute("error", "<p style='font-size: 16px;padding: 8px;color: #b94a48;background-color: #f2dede;border-color: #eed3d7;' aling='center'><strong>Warning !</strong>  Please login first to access the page</p>");
			return "redirect:/login.spring";
		}
	}
	
	private static final int BUFFER_SIZE = 4096;     
    @RequestMapping(value="/download.spring",method = RequestMethod.GET)
    public void doDownload(@RequestParam("path")String filePath,HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        ServletContext context = request.getSession().getServletContext();
        File downloadFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outStream.close();
    }
    
    @RequestMapping(value="/logout.spring", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		session = request.getSession();		
		session.invalidate();
		return "redirect:/login.spring";
    }
}