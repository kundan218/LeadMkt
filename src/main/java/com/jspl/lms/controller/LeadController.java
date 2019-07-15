package com.jspl.lms.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.Country;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadMaterialMap;
import com.jspl.lms.model.Location;
import com.jspl.lms.model.Material;
import com.jspl.lms.model.Region;
import com.jspl.lms.model.State;
import com.jspl.lms.model.User;
import com.jspl.lms.model.UserInfo;
import com.jspl.lms.service.BulkUploadServiceLead;
import com.jspl.lms.service.CommonService;
import com.jspl.lms.service.LeadService;
import com.jspl.lms.service.MailAlertService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	@Autowired
	private CommonService commonService;
	@Autowired
	private MailAlertService mailAlertService;
	@Autowired
	private  BulkUploadServiceLead bulkUploadServiceLead;

	@RequestMapping(value="executive/saveLead",method=RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LeadManage saveLead(@RequestBody LeadManage leadManage){

		UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserPkId();
		User currentUser =new User();
		currentUser.setUserPkId(userId);
		Integer rsmId=null;
		List<LeadMaterialMap> leadMaterialMapList=new ArrayList<LeadMaterialMap>();

		Integer regionId=null;

		BigDecimal totalQuantity=BigDecimal.ZERO;

		if(leadManage.getLeadManagePkId()==null && leadManage.getLeadStatus().getCommonConstantPkId()==22){
			leadManage.setDeleted(true);			
			regionId=leadManage.getRegionFkId().getRegionPkId();
			rsmId=leadService.getAssignedRsm(regionId);
			User rsm=new User();
			rsm.setUserPkId(rsmId);
			leadManage.setRsmAssignFkId(rsm);
			leadManage.setRsmAssignDate(new Date());
			leadManage.setCreatedBy(currentUser);
			leadMaterialMapList=leadManage.getLeadMaterialMaps();
			for(LeadMaterialMap leadMaterialMap:leadMaterialMapList){
				totalQuantity=totalQuantity.add(leadMaterialMap.getQuantity());
			}			
			leadManage.setTotalQuantity( totalQuantity);			
			leadService.saveLead(leadManage);
			try {
				mailAlertService.sendMailToAssignLeadByRSM(leadManage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(leadManage.getLeadManagePkId()==null && leadManage.getLeadStatus().getCommonConstantPkId()==26){
			leadManage.setDeleted(true);
			

			try{
				regionId=leadManage.getRegionFkId().getRegionPkId();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			rsmId=leadService.getAssignedRsm(regionId);
			User rsm=new User();
			rsm.setUserPkId(rsmId);
			leadManage.setRsmAssignFkId(rsm);
			leadManage.setCreatedBy(currentUser);
			leadMaterialMapList=leadManage.getLeadMaterialMaps();
			for(LeadMaterialMap leadMaterialMap:leadMaterialMapList){
				totalQuantity=totalQuantity.add(leadMaterialMap.getQuantity());
			}			
			leadManage.setTotalQuantity( totalQuantity);			
			leadService.saveLead(leadManage);
		}
		else if(leadManage.getLeadManagePkId()!=null)
		{
			try{
				leadMaterialMapList=leadManage.getLeadMaterialMaps();
				for(LeadMaterialMap leadMaterialMap:leadMaterialMapList){
					totalQuantity=totalQuantity.add(leadMaterialMap.getQuantity());
				}			
				leadManage.setTotalQuantity( totalQuantity);
				regionId=leadManage.getRegionFkId().getRegionPkId();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			rsmId=leadService.getAssignedRsm(regionId);
			User rsm=new User();
			rsm.setUserPkId(rsmId);
			leadManage.setRsmAssignFkId(rsm);			
			leadService.saveLead(leadManage);
		}

		return leadManage;
	}

	@RequestMapping(value = "executive/getCountry",method=RequestMethod.GET)
	public @ResponseBody List<Country> getCountry() {
		List<Country> country =leadService.getCountry();
		return country;

	}

	@RequestMapping(value="executive/getState",method=RequestMethod.GET)
	public @ResponseBody List<State> getState() {
		List<State> state=leadService.getState();
		return state;
	}

	@RequestMapping(value="executive/getDistrict/{stateFkId}",method=RequestMethod.GET)
	public @ResponseBody List<Location> getDistrict(@PathVariable Integer stateFkId) {
		List<Location> district=leadService.getDistrict(stateFkId);
		return district;
	}

	@RequestMapping(value={"executive/getRegion","admin/getRegion","rm/getRegion","sales/getRegion","sym/getRegion"},method=RequestMethod.GET)
	public @ResponseBody List<Region> getRegion() {
		List<Region> region=leadService.getRegion();
		return region;
	}

	@RequestMapping(value="executive/getLeadType",method=RequestMethod.GET)
	public @ResponseBody List<CommonConstant> getLeadType() {
		return commonService.getDataFromCommonConstant("LEAD_TYPE");
	}

	@RequestMapping(value="executive/getSbuList",method=RequestMethod.GET)
	public @ResponseBody List<CommonConstant> getSbu() {
		return commonService.getDataFromCommonConstant("SBU_TYPE");
	}

	@RequestMapping(value="executive/getMaterial/{sbuFkId}",method=RequestMethod.GET)
	public @ResponseBody List<Material> getMaterialList(@PathVariable Integer sbuFkId) {
		List<Material> sbu=leadService.getMaterial(sbuFkId);
		return sbu;
	}

	@RequestMapping(value={"admin/getLeadDetails/{leadManagePkId}","/rm/getLeadDetails/{leadManagePkId}","/sales/getLeadDetails/{leadManagePkId}","/executive/getLeadDetails/{leadManagePkId}","/sym/getLeadDetails/{leadManagePkId}"},method=RequestMethod.GET)
	public @ResponseBody LeadManage getLeadDetails(@PathVariable Integer leadManagePkId) {
		return leadService.getLeadDetails(leadManagePkId);
	}

	@RequestMapping(value={"/rm/leadCancelByRsm/{leadManagePkId}/{status}/{comment}","/sales/leadCancelByRsm/{leadManagePkId}/{status}/{comment}","/admin/leadCancelByRsm/{leadManagePkId}/{status}/{comment}","/sym/leadCancelByRsm/{leadManagePkId}/{status}/{comment}"}, method=RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean updateLeadStatus(@PathVariable Integer leadManagePkId,@PathVariable("status") Integer status, @PathVariable("comment") String comment,HttpServletRequest request){
		Boolean flag =false;
		try{
			String role=null;		
			if(request.isUserInRole("REGIONAL_MANAGER")){
				role="REGIONAL_MANAGER";
				leadService.cancelLead(leadManagePkId,status,comment);
				LeadManage leadManage=leadService.getLeadDetails(leadManagePkId);
				mailAlertService.sendMailOnCancel(leadManage, role);
			}
			if(request.isUserInRole("SALES_MARKETING")){
				role="SALES_MARKETING";
				leadService.cancelLead(leadManagePkId,status,comment);
				LeadManage leadManage=leadService.getLeadDetails(leadManagePkId);
				mailAlertService.sendMailOnCancel(leadManage, role);
			}
			if(request.isUserInRole("ADMIN")){
				role="ADMIN";
				leadService.cancelLead(leadManagePkId,status,comment);
				LeadManage leadManage=leadService.getLeadDetails(leadManagePkId);
				mailAlertService.sendMailOnCancel(leadManage, role);
			}
			if(request.isUserInRole("STOCKYARD_MANAGER")){
				role="ADMIN";
				leadService.cancelLead(leadManagePkId,status,comment);
				LeadManage leadManage=leadService.getLeadDetails(leadManagePkId);
				mailAlertService.sendMailOnCancel(leadManage, role);
			}
			
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@RequestMapping(value={"/rm/getLocationList2","/sales/getLocationList2","/admin/getLocationList2","/sym/getLocationList2"}, method=RequestMethod.GET)
	public @ResponseBody List<Location> getLocationList2(){	
		return leadService.getLocationList();
	}
	@RequestMapping(value={"/rm/getSmList","/admin/getSmList","/sales/getSmList","/sym/getSmList"}, method=RequestMethod.GET)
	public @ResponseBody List<User> getSmList(){	
		return leadService.getSmList();
	}
	
	@RequestMapping(value={"/rm/getStockyardList","/sales/getStockyardList","/sym/getStockyardList"},method=RequestMethod.GET)
	public @ResponseBody List<User> getStockyardList(){
		return leadService.getStockyardList();
	}
	
	@RequestMapping(value={"/rm/assignLeadByRsm/{leadManagePkId}/{status}/{userPkId}/{roleList}","/admin/assignLeadByRsm/{leadManagePkId}/{status}/{userPkId}/{roleList}","/sales/assignLeadByRsm/{leadManagePkId}/{status}/{userPkId}/{roleList}"}, method=RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean assignLeadByRsm(@PathVariable Integer leadManagePkId,@PathVariable("status") Integer status, @PathVariable("userPkId") Integer userPkId , @PathVariable("roleList") String roleList,HttpServletRequest request){
		Boolean flag =false;	
			try{
				leadService.assignLeadByRsm(leadManagePkId,status,userPkId,roleList);
				LeadManage leadManage=leadService.getLeadDetails(leadManagePkId);
				if(roleList.equals("SALES_MARKETING")){
					mailAlertService.sendMailToAssignLeadBySO(leadManage);
				}
				if(roleList.equals("STOCKYARD_MANAGER")){
					mailAlertService.sendMailToAssignLeadToStockyard(leadManage);
				}

				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
	
	@RequestMapping(value={"/rm/getActionList","/sales/getActionList","/sym/getActionList"}, method=RequestMethod.GET)
	public @ResponseBody List<CommonConstant> getActionList(){	
		return commonService.getDataFromCommonConstantAccToStatus("LEAD_STATUS");
	}
	@RequestMapping(value={"/rm/assignLeadActionByRsm/{leadManagePkId}/{action}/{comment}","/sales/assignLeadActionByRsm/{leadManagePkId}/{action}/{comment}","/sym/assignLeadActionByRsm/{leadManagePkId}/{action}/{comment}"}, method=RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean assignLeadActionByRsm(@PathVariable Integer leadManagePkId,@PathVariable("action") Integer action, @PathVariable("comment") String comment){
		Boolean flag =false;
		try{  	
			leadService.assignLeadActionByRsm(leadManagePkId, action, comment);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping(value={"/sales/assignLeadActionBySales/{leadManagePkId}/{smPkId}/{status}"}, method=RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean assignLeadActionBySales(@PathVariable Integer leadManagePkId,@PathVariable("smPkId") Integer smPkId,@PathVariable Integer status){
		Boolean flag =false;
		try{  	
			leadService.assignLeadActionBySales(leadManagePkId,smPkId,status);
			LeadManage leadManage=leadService.getLeadDetails(leadManagePkId);
			mailAlertService.sendMailToAssignLeadToStockyard(leadManage);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping(value = {"executive/bulkUploadLead"},method=RequestMethod.POST,produces="application/json")
	public @ResponseBody Boolean saveDailyAllocation(@RequestParam(value = "excelUpload", required = false) MultipartFile excelUpload ) {
		
		StringBuilder sb = new StringBuilder();
		Boolean status=false;
		try {
			bulkUploadServiceLead.uploadBulk(excelUpload, sb);
			sb.append("File Uploaded Sucessfully.");
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
			sb.append("Failed To Upload File! Please try again.");
		}
		
			return status;
	}




}
