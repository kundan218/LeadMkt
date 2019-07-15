package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



// TODO: Auto-generated Javadoc
/**
 * The Class UserLocationMap.
 */
@Entity
@Table(name="region_location_map")
public class RegionLocationMap implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user location pk id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_location_pk_id")
	private Integer regionLocationPkId;


	/** The location fk id. */
	@Column(name = "location_fk_id")
	private Integer locationFkId;
	
	
	/** The region fk id. */
	@Column(name = "region_fk_id")
	private Integer regionFkId;


	public Integer getRegionLocationPkId() {
		return regionLocationPkId;
	}


	public void setRegionLocationPkId(Integer regionLocationPkId) {
		this.regionLocationPkId = regionLocationPkId;
	}


	public Integer getLocationFkId() {
		return locationFkId;
	}


	public void setLocationFkId(Integer locationFkId) {
		this.locationFkId = locationFkId;
	}


	public Integer getRegionFkId() {
		return regionFkId;
	}


	public void setRegionFkId(Integer regionFkId) {
		this.regionFkId = regionFkId;
	}

	
	
}
