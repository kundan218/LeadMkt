package com.jspl.lms.dao;

import java.util.List;

import com.jspl.lms.dto.DashboardDTO;
import com.jspl.lms.dto.ReportParam;
import com.jspl.lms.model.DataTableDto;
import com.jspl.lms.model.LeadManageDto;
import com.jspl.lms.model.Region;

public interface DashBoardDao {

	public String getTotalDistributor();

	public Long countLeadManageData(DataTableDto dataTableDto, String roleName, Integer userId);

	public List<LeadManageDto> getLeadManageList(DataTableDto dataTableDto, String roleName, Integer userId);
	
	public List<Region> getRegionListByUserId(ReportParam param);

	public List<DashboardDTO> getSalesReport(ReportParam param);


}
