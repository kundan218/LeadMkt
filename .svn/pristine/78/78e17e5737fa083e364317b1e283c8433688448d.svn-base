package com.jspl.lms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "lead_source")
public class LeadSource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "lead_source_pk_id")
	private Integer leadSourcePkId;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="created_on")
	private Date createdOn;
	
	
	@Column(name = "company_name")
	private String companyName;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="contract_validity_date_from")
	private Date contractValidityDateFrom;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="contract_validity_date_to")
	private Date contractValidityDateTo;
	
	
	@ManyToOne
	@JoinColumn(name="lead_source_status_fk_id")
	private  CommonConstant leadSourceStatusFkId;
	
	@Column(name="status")
	private Boolean status;

	public Integer getLeadSourcePkId() {
		return leadSourcePkId;
	}

	public void setLeadSourcePkId(Integer leadSourcePkId) {
		this.leadSourcePkId = leadSourcePkId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getContractValidityDateFrom() {
		return contractValidityDateFrom;
	}

	public void setContractValidityDateFrom(Date contractValidityDateFrom) {
		this.contractValidityDateFrom = contractValidityDateFrom;
	}

	public Date getContractValidityDateTo() {
		return contractValidityDateTo;
	}

	public void setContractValidityDateTo(Date contractValidityDateTo) {
		this.contractValidityDateTo = contractValidityDateTo;
	}

	public CommonConstant getLeadSourceStatusFkId() {
		return leadSourceStatusFkId;
	}

	public void setLeadSourceStatusFkId(CommonConstant leadSourceStatusFkId) {
		this.leadSourceStatusFkId = leadSourceStatusFkId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	

}
