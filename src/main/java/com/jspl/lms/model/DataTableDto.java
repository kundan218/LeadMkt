package com.jspl.lms.model;

import java.util.List;


import com.jspl.lms.util.Search;
import com.jspl.lms.model.LeadManageDto;

public class DataTableDto {
	
	private Integer draw;

	private Long recordsTotal;

	private Long recordsFiltered;
	
	public String fromDate;
	
	public String toDate;
	
	private String invoiceNo;
	
	List<Report> customerPOs;
	
	List<Report> salesInvoices;
	
	List<Report> misReports;
	
	List<Report> misDetailReports;
	
	List<LeadManage> leadManageList;
	
	List<LeadManageDto> leadManageDtoList;
	
	private Integer start;
	
	private Integer length;
	
	private Search search;
	
	private String distributorSearchId;
	
	

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<Report> getCustomerPOs() {
		return customerPOs;
	}

	public void setCustomerPOs(List<Report> customerPOs) {
		this.customerPOs = customerPOs;
	}

	public List<Report> getSalesInvoices() {
		return salesInvoices;
	}

	public void setSalesInvoices(List<Report> salesInvoices) {
		this.salesInvoices = salesInvoices;
	}
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public List<Report> getMisReports() {
		return misReports;
	}

	public void setMisReports(List<Report> misReports) {
		this.misReports = misReports;
	}

	public List<Report> getMisDetailReports() {
		return misDetailReports;
	}

	public void setMisDetailReports(List<Report> misDetailReports) {
		this.misDetailReports = misDetailReports;
	}

	public String getDistributorSearchId() {
		return distributorSearchId;
	}

	public void setDistributorSearchId(String distributorSearchId) {
		this.distributorSearchId = distributorSearchId;
	}

	public List<LeadManage> getLeadManageList() {
		return leadManageList;
	}

	public void setLeadManageList(List<LeadManage> leadManageList) {
		this.leadManageList = leadManageList;
	}

	public List<LeadManageDto> getLeadManageDtoList() {
		return leadManageDtoList;
	}

	public void setLeadManageDtoList(List<LeadManageDto> leadManageDtoList) {
		this.leadManageDtoList = leadManageDtoList;
	}


}
