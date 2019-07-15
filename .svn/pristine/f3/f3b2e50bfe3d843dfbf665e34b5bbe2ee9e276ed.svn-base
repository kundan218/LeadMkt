package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "region")
public class Region implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_pk_id")
	private int regionPkId;

	@Column(name = "region_name")
	private String regionName;
	
	@Transient
	private String locationName; 

	@Transient
	private Integer locationPkId; 
	
	public int getRegionPkId() {
		return regionPkId;
	}

	public void setRegionPkId(int regionPkId) {
		this.regionPkId = regionPkId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getLocationPkId() {
		return locationPkId;
	}

	public void setLocationPkId(Integer locationPkId) {
		this.locationPkId = locationPkId;
	}

	
	}
