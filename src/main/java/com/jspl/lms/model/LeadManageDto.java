package com.jspl.lms.model;

import java.util.Date;





public class LeadManageDto {

	private Integer leadManagePkId;
	private String name;
	private String leadId;
	private  LeadSource leadSourceFkId;
	private Date createdDate;
	private User rsmAssignFkId;
	private User soAssignFkId;
	private User stockyardAssignFkId;
	private CommonConstant leadStatus;
	private Region regionFkId;
	private String amount;
	private User createdBy;
	private User cancelledBy;
	private User convertedToSaleBy;


	public Integer getLeadManagePkId() {
		return leadManagePkId;
	}
	public void setLeadManagePkId(Integer leadManagePkId) {
		this.leadManagePkId = leadManagePkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public LeadSource getLeadSourceFkId() {
		return leadSourceFkId;
	}
	public void setLeadSourceFkId(LeadSource leadSourceFkId) {
		this.leadSourceFkId = leadSourceFkId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getRsmAssignFkId() {
		return rsmAssignFkId;
	}
	public void setRsmAssignFkId(User rsmAssignFkId) {
		this.rsmAssignFkId = rsmAssignFkId;
	}
	public CommonConstant getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(CommonConstant leadStatus) {
		this.leadStatus = leadStatus;
	}
	public User getSoAssignFkId() {
		return soAssignFkId;
	}
	public void setSoAssignFkId(User soAssignFkId) {
		this.soAssignFkId = soAssignFkId;
	}
	public User getStockyardAssignFkId() {
		return stockyardAssignFkId;
	}
	public void setStockyardAssignFkId(User stockyardAssignFkId) {
		this.stockyardAssignFkId = stockyardAssignFkId;
	}
	public Region getRegionFkId() {
		return regionFkId;
	}
	public void setRegionFkId(Region regionFkId) {
		this.regionFkId = regionFkId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public User getCancelledBy() {
		return cancelledBy;
	}
	public void setCancelledBy(User cancelledBy) {
		this.cancelledBy = cancelledBy;
	}
	public User getConvertedToSaleBy() {
		return convertedToSaleBy;
	}
	public void setConvertedToSaleBy(User convertedToSaleBy) {
		this.convertedToSaleBy = convertedToSaleBy;
	}


}
