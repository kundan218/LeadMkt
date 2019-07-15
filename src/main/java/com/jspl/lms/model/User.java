package com.jspl.lms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;



/**
 * The Class User.
 */

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_pk_id")
	private Integer userPkId;
	
	@Column(name = "username", nullable=false, unique=true)
	private String username;
	
	@Column(name = "password", nullable = false, updatable= true)
	private String password;
	
	/** The user name. */
	@Column(name = "name")
	private String name;
	
	
	/** The user email. */
	@Column(name = "email")
	private String email;
	
	/** The user name. */
	@Column(name = "contact_number")
	private String contactNumber;
	
	/** The user name. */
	@Column(name = "status")
	private Integer status;
	
	/** The sap id. */
	@Column(name = "sap_id")
	private String sapId;
	
	/** The user name. */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "registered_date")
	private Date registeredDate;
	
	@Column(name = "distributor_dms_id")
	private String distributorDmsId;
	
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_fk_id", referencedColumnName = "user_pk_id")
	private List<UserRole> userRole;
	
	

	
	
	
	/** The location list. */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_fk_id", referencedColumnName = "user_pk_id")
	private List<UserLocationMap> locationList; // One To Many RelationShip With
												// location
	
	

	/** The location name. */
	@Transient
	private String locationName;
	
	
	@Transient
	private String regionName;
	
	
	@Transient
	private Integer regionPkId;

	public List<UserLocationMap> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<UserLocationMap> locationList) {
		this.locationList = locationList;
	}

	/** The role name. */
	@Transient
	private String roleName;

	/** The role id. */
	@Transient
	private Integer roleId;

	/** The location pk id. */
	@Transient
	private String locationPkId;

	
	
	public Integer getUserPkId() {
		return userPkId;
	}

	public void setUserPkId(Integer userPkId) {
		this.userPkId = userPkId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

	
	public int compareTo(User obj) {
		return username.compareTo(obj.username);
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getLocationPkId() {
		return locationPkId;
	}

	public void setLocationPkId(String locationPkId) {
		this.locationPkId = locationPkId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}



	public Integer getRegionPkId() {
		return regionPkId;
	}

	public void setRegionPkId(Integer regionPkId) {
		this.regionPkId = regionPkId;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public String getDistributorDmsId() {
		return distributorDmsId;
	}

	public void setDistributorDmsId(String distributorDmsId) {
		this.distributorDmsId = distributorDmsId;
	}


	

	
	/********************************************Setters and getters*************************************************/
	
}
