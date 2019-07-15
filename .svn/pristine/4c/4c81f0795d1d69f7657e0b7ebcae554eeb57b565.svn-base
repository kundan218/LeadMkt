package com.jspl.lms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jspl.lms.service.DistributorService;
import com.jspl.lms.service.MaterialService;
import com.jspl.lms.service.ReportService;

@Controller
public class ReportController {

	/**
	 * @author Kundan
	 */
	@Autowired
	private ReportService reportService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private DistributorService  distributorService;
	
	String roleId=null;
	
	@RequestMapping(value={"/distributor/report","/admin/report","/sales/report","/rm/report","/asm/report","/sbu/report","/sym/report","/zsm/report","/nwm/report"}, method = RequestMethod.GET)
	public String report (ModelMap map,HttpServletRequest request, HttpServletResponse response){
		System.out.println("report");	
		return "report";
	}
	
}
