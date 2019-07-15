package com.jspl.lms.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspl.lms.model.CommonConstant;
import com.jspl.lms.model.Material;
import com.jspl.lms.service.CommonService;
import com.jspl.lms.service.MaterialService;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value = "/admin/material")
	public String manageMaterial() {
		System.out.println("Material");
		return "manageMaterial";

	}
	
	@RequestMapping(value = "/admin/materialList",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Material> getAllMaterial() {
       List<Material> materialList =materialService.getMaterialList();
      return materialList;
}
	@RequestMapping(value = "/admin/saveMaterial", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Material saveMaterial(@RequestBody Material material){
		return materialService.saveMaterial(material);
	}
	
	@RequestMapping(value = "/admin/getMaterial", method = RequestMethod.GET)
	public @ResponseBody java.util.List<Material> getMaterial(){
		return materialService.getMaterialList();
	}
	
	@RequestMapping(value="/admin/deleteMaterial/{materialId}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean deleteMaterial(@PathVariable Integer materialId){
		boolean status=false;
		 status=materialService.deleteMaterial(materialId);;
		 if(status){
			 status=true;
		 } 
		 return status;
		
		}
	
	@RequestMapping(value={"/admin/sbuTypeList"}, method = RequestMethod.GET)
	public @ResponseBody List<CommonConstant> getLeadSourceStatusList (){
		return commonService.getDataFromCommonConstant("SBU_TYPE");
	}
}
