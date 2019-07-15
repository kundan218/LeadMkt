package com.jspl.lms.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspl.lms.dto.ReportParam;
import com.jspl.lms.dto.Sales;
import com.jspl.lms.model.DataTableDto;
import com.jspl.lms.model.LeadManage;
import com.jspl.lms.model.LeadManageDto;
import com.jspl.lms.model.UserInfo;
import com.jspl.lms.service.CommonService;
import com.jspl.lms.service.DashBoardService;
import com.jspl.lms.service.DistributorService;

@Controller
public class DashBoardController {

	/**
	 * @author Kundan
	 */
	@Autowired
	private DashBoardService dashBoardService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DistributorService distributorService;

	@RequestMapping(value={"/distributor/dashboard","/admin/dashboard","/sales/dashboard","/rm/dashboard","/sbu/dashboard","/asm/dashboard","/sym/dashboard","/zsm/dashboard","/nwm/dashboard"}, method = RequestMethod.GET)
	public String dashboard (ModelMap map,HttpServletRequest request, HttpServletResponse response){
		UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		 String roleName=null;
		 ReportParam param=new ReportParam();
			if(request.isUserInRole("ADMIN")){
				param.setRoleId("ADMIN");
				 try {
					JSONArray dayArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getDayArray()));
						JSONArray regionArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getRegionArray()));
						List<Sales> list = dashBoardService.getLeadsReport(param).getSaleList();
						map.put("dayAll",dayArray);
						map.put("regionArray",regionArray);
						map.put("saleArray",new JSONArray(Arrays.asList(list)));
						map.put("list",list);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(request.isUserInRole("REGIONAL_MANAGER")){
				param.setRoleId("REGIONAL_MANAGER");
				param.setUserPkId(user.getUserPkId());
				 try {
						JSONArray dayArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getDayArray()));
							JSONArray regionArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getRegionArray()));
							List<Sales> list = dashBoardService.getLeadsReport(param).getSaleList();
							map.put("dayAll",dayArray);
							map.put("regionArray",regionArray);
							map.put("saleArray",new JSONArray(Arrays.asList(list)));
							map.put("list",list);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}else if(request.isUserInRole("SALES_MARKETING")){
				param.setRoleId("SALES_MARKETING");
				param.setUserPkId(user.getUserPkId());
				 try {
						JSONArray dayArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getDayArray()));
							JSONArray regionArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getRegionArray()));
							List<Sales> list = dashBoardService.getLeadsReport(param).getSaleList();
							map.put("dayAll",dayArray);
							map.put("regionArray",regionArray);
							map.put("saleArray",new JSONArray(Arrays.asList(list)));
							map.put("list",list);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}else if(request.isUserInRole("STOCKYARD_MANAGER")){
				param.setRoleId("STOCKYARD_MANAGER");
				param.setUserPkId(user.getUserPkId());
				 try {
						JSONArray dayArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getDayArray()));
							JSONArray regionArray = new JSONArray(Arrays.asList(dashBoardService.getLeadsReport(param).getRegionArray()));
							List<Sales> list = dashBoardService.getLeadsReport(param).getSaleList();
							map.put("dayAll",dayArray);
							map.put("regionArray",regionArray);
							map.put("saleArray",new JSONArray(Arrays.asList(list)));
							map.put("list",list);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		
		return "dashboard";
	}

	@RequestMapping(value={"/distributor/myProfile"}, method = RequestMethod.GET)
	public String dashboardAdmin (ModelMap map,HttpServletRequest request, HttpServletResponse response){
		//	map.addAttribute("totalDistributor", dashBoardService.getTotalDistributor());
		return "myProfile";
	}

	@RequestMapping(value={"/executive/home"}, method = RequestMethod.GET)
	public String dashboardExecutive (ModelMap map,HttpServletRequest request, HttpServletResponse response){
		//UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return "home";
	}

	 @RequestMapping(value={"/admin/getLeadCount","/rm/getLeadCount","/sales/getLeadCount","/sym/getLeadCount"},method=RequestMethod.GET,produces="application/json")
	 public @ResponseBody List<LeadManage> getLeadList(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		 UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 Integer userId= user.getUserPkId();
		 String roleName=null;
			List<LeadManage> leadCountList=null;
			if(request.isUserInRole("ADMIN")){
				 roleName="ADMIN";
				 leadCountList=commonService.getLeadCountList(roleName,null);
			}else if(request.isUserInRole("REGIONAL_MANAGER")){
				roleName="REGIONAL_MANAGER";
				 leadCountList=commonService.getLeadCountList(roleName,userId);
			}else if(request.isUserInRole("SALES_MARKETING")){
				roleName="SALES_MARKETING";
				leadCountList=commonService.getLeadCountList(roleName,userId);
			}else if(request.isUserInRole("STOCKYARD_MANAGER")){
				roleName="STOCKYARD_MANAGER";
				leadCountList=commonService.getLeadCountList(roleName,userId);
			}
		return  leadCountList;	
		}
	
	 @RequestMapping(value={"/admin/getLeadSourceCount","/rm/getLeadSourceCount","/sales/getLeadSourceCount","/sym/getLeadSourceCount"},method=RequestMethod.GET,produces="application/json")
	 public @ResponseBody List<LeadManage> getLeadSourceCount(ModelMap map,HttpServletRequest request,HttpServletResponse response){
		 UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		 String roleName=null;
		 Integer userId= user.getUserPkId();
		 ReportParam param=new ReportParam();
			List<LeadManage> leadSourceCountList=null;
			if(request.isUserInRole("ADMIN")){
				 roleName="ADMIN";
				 leadSourceCountList=commonService.getLeadSourceCount(roleName,null);
			}else if(request.isUserInRole("REGIONAL_MANAGER")){
				roleName="REGIONAL_MANAGER";
				leadSourceCountList=commonService.getLeadSourceCount(roleName,userId);
			}else if(request.isUserInRole("SALES_MARKETING")){
				roleName="SALES_MARKETING";
				leadSourceCountList=commonService.getLeadSourceCount(roleName,userId);
			}
			else if(request.isUserInRole("STOCKYARD_MANAGER")){
				roleName="STOCKYARD_MANAGER";
				leadSourceCountList=commonService.getLeadSourceCount(roleName,userId);
			}
		return  leadSourceCountList;	
		}
	 
	@RequestMapping(value={"/admin/getLeadManageList","/rm/getLeadManageList","/sales/getLeadManageList","/executive/getLeadManageList","/sym/getLeadManageList"},method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DataTableDto leadManageList(@RequestBody DataTableDto dataTableDto,HttpServletRequest request){
		DataTableDto dataTableDto1 = null;
		UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Integer userId= user.getUserPkId();
		// Integer locationId=user.getUserLocationMaps().get(0).getLocationFkId().getLocationPkId();
		//Integer locationId=user.getLocationFkId().getLocationPkId();
		String roleName=null;
		List<LeadManageDto> leadManageDtoList = null;
		try {
			if(request.isUserInRole("ADMIN")){
				roleName="ADMIN";
				dataTableDto1=new DataTableDto();
				dataTableDto1.setDraw(dataTableDto.getDraw());
				System.out.println("++++++Role"+roleName);
				Long total = dashBoardService.countLeadManageData(dataTableDto,roleName,userId);
				dataTableDto1.setRecordsTotal(total);
				dataTableDto1.setRecordsFiltered(total);
				leadManageDtoList=dashBoardService.getLeadManageList(dataTableDto,roleName,userId);
				dataTableDto1.setLeadManageDtoList(leadManageDtoList);
			}
			
			else if(request.isUserInRole("REGIONAL_MANAGER")){
				roleName="REGIONAL_MANAGER";
				dataTableDto1=new DataTableDto();
				dataTableDto1.setDraw(dataTableDto.getDraw());
				Long total = dashBoardService.countLeadManageData(dataTableDto,roleName,userId);
				dataTableDto1.setRecordsTotal(total);
				dataTableDto1.setRecordsFiltered(total);
				leadManageDtoList=dashBoardService.getLeadManageList(dataTableDto,roleName,userId);
				dataTableDto1.setLeadManageDtoList(leadManageDtoList);
			}
			
			else if(request.isUserInRole("SALES_MARKETING")){
				roleName="SALES_MARKETING";
				dataTableDto1=new DataTableDto();
				dataTableDto1.setDraw(dataTableDto.getDraw());
				Long total = dashBoardService.countLeadManageData(dataTableDto,roleName,userId);
				dataTableDto1.setRecordsTotal(total);
				dataTableDto1.setRecordsFiltered(total);
				leadManageDtoList=dashBoardService.getLeadManageList(dataTableDto,roleName,userId);
				dataTableDto1.setLeadManageDtoList(leadManageDtoList);
			}
			else if(request.isUserInRole("EXECUTIVE")){
				roleName="EXECUTIVE";
				dataTableDto1=new DataTableDto();
				dataTableDto1.setDraw(dataTableDto.getDraw());
				Long total = dashBoardService.countLeadManageData(dataTableDto,roleName,userId);
				dataTableDto1.setRecordsTotal(total);
				dataTableDto1.setRecordsFiltered(total);
				leadManageDtoList=dashBoardService.getLeadManageList(dataTableDto,roleName,userId);
				dataTableDto1.setLeadManageDtoList(leadManageDtoList);
			}
			else if(request.isUserInRole("STOCKYARD_MANAGER")){
				roleName="STOCKYARD_MANAGER";
				dataTableDto1=new DataTableDto();
				dataTableDto1.setDraw(dataTableDto.getDraw());
				Long total = dashBoardService.countLeadManageData(dataTableDto,roleName,userId);
				dataTableDto1.setRecordsTotal(total);
				dataTableDto1.setRecordsFiltered(total);
				leadManageDtoList=dashBoardService.getLeadManageList(dataTableDto,roleName,userId);
				dataTableDto1.setLeadManageDtoList(leadManageDtoList);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataTableDto1;
	}

}
