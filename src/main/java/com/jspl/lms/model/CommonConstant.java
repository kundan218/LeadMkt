package com.jspl.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_constant")
public class CommonConstant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "common_constant_pk_id")
	private Integer commonConstantPkId;
	
	@Column(name = "common_constant_name")
	private String commonConstantName;
	
	@Column(name = "common_constant_value")
	private String commonConstantValue;
	
	@Column(name = "status")
	private Boolean status;

	public Integer getCommonConstantPkId() {
		return commonConstantPkId;
	}

	public void setCommonConstantPkId(Integer commonConstantPkId) {
		this.commonConstantPkId = commonConstantPkId;
	}

	public String getCommonConstantName() {
		return commonConstantName;
	}

	public void setCommonConstantName(String commonConstantName) {
		this.commonConstantName = commonConstantName;
	}

	public String getCommonConstantValue() {
		return commonConstantValue;
	}

	public void setCommonConstantValue(String commonConstantValue) {
		this.commonConstantValue = commonConstantValue;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
