package com.jspl.lms.service;

import java.util.List;

import com.jspl.lms.dto.ReportParam;
import com.jspl.lms.dto.SalesReport;
import com.jspl.lms.model.DataTableDto;
import com.jspl.lms.model.LeadManageDto;

public interface DashBoardService {

	public String getTotalDistributor();

	public Long countLeadManageData(DataTableDto dataTableDto, String roleName, Integer userId);

	public List<LeadManageDto> getLeadManageList(DataTableDto dataTableDto, String roleName, Integer userId);
	
	public SalesReport getLeadsReport(ReportParam param);

}
