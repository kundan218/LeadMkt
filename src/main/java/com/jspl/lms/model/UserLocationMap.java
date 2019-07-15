package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



// TODO: Auto-generated Javadoc
/**
 * The Class UserLocationMap.
 */
@Entity
@Table(name="user_location_map")
public class UserLocationMap implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user location pk id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_location_pk_id")
	private Integer userLocationPkId;

	/** The user fk id. */
	@Column(name = "user_fk_id")
	private Integer userFkId;

	/** The location fk id. */
	@Column(name = "location_fk_id")
	private Integer locationFkId;
	
	
	/** The region fk id. */
	@Column(name = "region_fk_id")
	private Integer regionFkId;

	/** The location. */
	@OneToOne(cascade = { CascadeType.ALL }, targetEntity = Location.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "location_fk_id", referencedColumnName = "location_pk_id", insertable = false, updatable = false)
	private Location location;

	/**
	 * Gets the location fk id.
	 *
	 * @return the location fk id
	 */
	public Integer getLocationFkId() {
		return locationFkId;
	}

	/**
	 * Sets the location fk id.
	 *
	 * @param locationFkId the new location fk id
	 */
	public void setLocationFkId(Integer locationFkId) {
		this.locationFkId = locationFkId;
	}

	/**
	 * Gets the user location pk id.
	 *
	 * @return the user location pk id
	 */
	public Integer getUserLocationPkId() {
		return userLocationPkId;
	}

	/**
	 * Sets the user location pk id.
	 *
	 * @param userLocationPkId the new user location pk id
	 */
	public void setUserLocationPkId(Integer userLocationPkId) {
		this.userLocationPkId = userLocationPkId;
	}

	/**
	 * Gets the user fk id.
	 *
	 * @return the user fk id
	 */
	public Integer getUserFkId() {
		return userFkId;
	}

	/**
	 * Sets the user fk id.
	 *
	 * @param userFkId the new user fk id
	 */
	public void setUserFkId(Integer userFkId) {
		this.userFkId = userFkId;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getRegionFkId() {
		return regionFkId;
	}

	public void setRegionFkId(Integer regionFkId) {
		this.regionFkId = regionFkId;
	}

	
}
