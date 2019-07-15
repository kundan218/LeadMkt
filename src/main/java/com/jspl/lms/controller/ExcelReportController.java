package com.jspl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jspl.lms.service.DistributorService;
import com.jspl.lms.service.ReportService;

@Controller
public class ExcelReportController {

	@Autowired
	private ReportService reportService;
	@Autowired 
	private DistributorService distributorService;
	
	
}
