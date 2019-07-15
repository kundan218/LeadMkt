package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_pk_id")
	private Integer locationPkId;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "state_fk_id")
	private Integer state_fk_id;

	public Integer getLocationPkId() {
		return locationPkId;
	}

	public void setLocationPkId(Integer locationPkId) {
		this.locationPkId = locationPkId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getState_fk_id() {
		return state_fk_id;
	}

	public void setState_fk_id(Integer state_fk_id) {
		this.state_fk_id = state_fk_id;
	}

	
}
