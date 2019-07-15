package com.jspl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.jspl.lms.service.DistributorService;

@Controller
public class MailAlertController {
	
	@Autowired
	private DistributorService distributorService;
	
	
	
	String roleId=null;
	


}
