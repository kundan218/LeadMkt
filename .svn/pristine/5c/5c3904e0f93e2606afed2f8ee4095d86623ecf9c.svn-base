package com.jspl.lms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.LeadSource;
import com.jspl.lms.model.ReportingDto;
import com.jspl.lms.model.UserInfo;
import com.jspl.lms.service.CommonService;
import com.jspl.lms.util.FileMeta;
import com.jspl.lms.util.FileUtility;

@Controller
public class CommonController {

	@Value("${portal.upload.basePath}")
	private String uploaddocBasePath;

	@Value("${portal.upload.maxFileLimit}")
	private String maxFileLimit;

	@Value("${portal.upload.maxFileSize}")
	private String maxFileSize;

	@Autowired
	private CommonService commonService;

	//	private Double maxFileSize;

	@RequestMapping(value = "/common/upload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		LinkedList<FileMeta> files = new LinkedList<FileMeta>();
		FileMeta fileMeta = null;
		System.out.println("hello file upload");
		// 1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		// 2. get each file
		while (itr.hasNext()) {

			// 2.1 get next MultipartFile
			mpf = request.getFile(itr.next());
			// System.out.println(mpf.getOriginalFilename() +" uploaded!
			// "+files.size());

			// 2.2 if files > 10 remove the first from the list

			//			 if (files.size() >= 10) files.pop();


			// 2.3 create new fileMeta
			fileMeta = new FileMeta();
			//			 fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileMeta.setFileType(mpf.getContentType());

			try {
				// fileMeta.setBytes(mpf.getBytes());
				// fileMeta.setBytes(new byte[100]);

				// copy file to local disk (make sure the path "e.g.
				// D:/temp/files" exists)
				// FileCopyUtils.copy(mpf.getBytes(), new
				// FileOutputStream("D:/temp/files/"+mpf.getOriginalFilename()));
				//				System.out.println("==========" + maxFileSize);
				//				System.out.println("==========" + uploaddocBasePath);
				//				System.out.println("==========" + mpf.getOriginalFilename());
				fileMeta.setOriginalFileName(mpf.getOriginalFilename());
				String fileName="";
				fileName=FileUtility.uploadFile(mpf,"dms_" + new Date().getTime(), 119999990000d,"D:\\salesInvoice", 200);
				System.out.println("---fileName-->"+fileName);
				fileMeta.setFileName(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 2.4 add to files
			files.add(fileMeta);

		}

		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8
		// Kb","fileType":"image/png"},...]
		return files;
		// return null;

	}
	@RequestMapping(value = {"/common/deleteFile","/originator/common/deleteFile"}, method = RequestMethod.POST)
	public @ResponseBody Boolean deleteFile(@RequestParam String fileName) {
		System.out.println("file Deleted");
		return FileUtility.deleteFile(uploaddocBasePath, fileName);
	}

	@RequestMapping(value={"/admin/manageSource","/rm/manageSource","/sales/manageSource"}, method = RequestMethod.GET)
	public String manageSourcePage (ModelMap map,HttpServletRequest request, HttpServletResponse response){
		return "manageSource";
	}
	@RequestMapping(value={"/admin/leadHistory","/rm/leadHistory","/sales/leadHistory","/sym/leadHistory"}, method = RequestMethod.GET)
	public String manageLeadHistory (ModelMap map,HttpServletRequest request, HttpServletResponse response){
		return "leadHistory";
	}

	@RequestMapping(value={"/executive/executiveHistory"}, method = RequestMethod.GET)
	public String manageExecutiveHistory (ModelMap map,HttpServletRequest request, HttpServletResponse response){
		return "executiveHistory";
	}

	@RequestMapping(value={"/admin/getLeadSourceStatusList"}, method = RequestMethod.GET)
	public @ResponseBody List<CommonConstant> getLeadSourceStatusList (){
		return commonService.getDataFromCommonConstant("SOURCE_STATUS");
	}

	@RequestMapping(value={"/admin/editSaveLeadSource"}, method = RequestMethod.POST)
	public @ResponseBody LeadSource editSaveLeadSource (@RequestBody LeadSource leadSource){
		UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(leadSource.getLeadSourcePkId()==null){
			leadSource.setCreatedOn(new Date());
			leadSource.setCreatedBy(user.getUserPkId());
			leadSource.setStatus(true);
		}
		return commonService.editSaveLeadSource(leadSource);
	}

	@RequestMapping(value={"/admin/getLeadSourceList","executive/getLeadSourceList"}, method = RequestMethod.GET)
	public @ResponseBody List<LeadSource> getLeadSourceList (HttpServletRequest request){	
		String roleName=null;
		if(request.isUserInRole("ADMIN")){
			roleName="ADMIN";
			return commonService.getLeadSourceList(roleName);
		}
		else if(request.isUserInRole("EXECUTIVE")){
			roleName="EXECUTIVE";
			return commonService.getLeadSourceList(roleName);
		}
		else{
			return commonService.getLeadSourceList(null);

		}

	}

	@RequestMapping(value={"/admin/deleteLeadSource/{leadSourcePkId}"}, method = RequestMethod.POST)
	public @ResponseBody boolean deleteLeadSource (@PathVariable Integer leadSourcePkId){		  
		return commonService.deleteLeadSource(leadSourcePkId);
	}

	@RequestMapping(value={"/admin/getRsmList/{regionId}","executive/getRsmList/{regionId}","/rm/getRsmList/{regionId}","/sales/getRsmList/{regionId}","/sym/getRsmList/{regionId}"}, method = RequestMethod.GET)
	public @ResponseBody List<ReportingDto> getRsmList (@PathVariable Integer regionId){
		return commonService.getRsmList(regionId);
	}
	@RequestMapping(value={"/admin/getSoList/{regionId}","executive/getSoList/{regionId}","/rm/getSoList/{regionId}","/sales/getSoList/{regionId}","/sym/getSoList/{regionId}"}, method = RequestMethod.GET)
	public @ResponseBody List<ReportingDto> getSoList (@PathVariable Integer regionId){
		return commonService.getSoList(regionId);
	}
	
	@RequestMapping(value={"/admin/getStockyardList/{regionId}","executive/getStockyardList/{regionId}","/rm/getStockyardList/{regionId}","/sales/getStockyardList/{regionId}","/sym/getStockyardList/{regionId}"}, method = RequestMethod.GET)
	public @ResponseBody List<ReportingDto> getStockyardList (@PathVariable Integer regionId){
		return commonService.getStockyardList(regionId);
	}

}


