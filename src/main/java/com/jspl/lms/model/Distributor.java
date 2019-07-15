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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "distributor")
public class Distributor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distributor_pk_id")
	private Integer distributorPkId;

	@Column(name = "distributor_name")
	private String distributorName;
	
	@Column(name = "distributor_dms_id")
	private String distributorDmsId;

	@Column(name = "address")
	private String address;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "city")
	private String city;
	
	@OneToOne
	@JoinColumn(name = "country_fk_id")
	private Country countryFkId;
	
	@Column(name = "pin_code")
	private String pinCode;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pan_no")
	private String panNo;
	
	@Column(name = "vat_no")
	private String vatNo;
	
	@Column(name = "tin_no")
	private String tinNo;
	
	@Column(name = "service_tax_no")
	private String serviceTaxNo;
	
	@Column(name = "contact_person")
	private String contactPerson;
	
	@OneToOne
	@JoinColumn(name = "state_fk_id")
	private State stateFkId;
	
	@OneToOne
	@JoinColumn(name = "location_fk_id")
	private Location locationFkId;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "telephone_no")
	private Integer telephoneNo;
	
	@Column(name = "sap_id")
	private String sapId;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "modify_on")
	private Date modifyOn;
	
	@Column(name = "status")
	private Boolean isDeleted;
/*	
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@OneToMany(fetch=FetchType.EAGER,mappedBy="distributorFkId")
	@Fetch(FetchMode.SELECT)
	private List<Aso> asoList;*/
	
	@OneToOne
	@JoinColumn(name = "user_fk_id")
	private User user;

	@Column(name = "sales_officer")
	private Integer salesOfficer;
	
	@Column(name = "regional_manager")
	private Integer regionalManager;
	
	@Column(name = "terms_condition")
	private String termsCondition;
	
	//Added For SYM and ZSM
	@Column(name = "stockyard_manager")
	private Integer stockyardManager;
	
	@Column(name = "zsm")
	private Integer zsm;
	
	public Integer getDistributorPkId() {
		return distributorPkId;
	}

	public void setDistributorPkId(Integer distributorPkId) {
		this.distributorPkId = distributorPkId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getVatNo() {
		return vatNo;
	}

	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getServiceTaxNo() {
		return serviceTaxNo;
	}

	public void setServiceTaxNo(String serviceTaxNo) {
		this.serviceTaxNo = serviceTaxNo;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public State getStateFkId() {
		return stateFkId;
	}

	public void setStateFkId(State stateFkId) {
		this.stateFkId = stateFkId;
	}

	public Location getLocationFkId() {
		return locationFkId;
	}

	public void setLocationFkId(Location locationFkId) {
		this.locationFkId = locationFkId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(Integer telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifyOn() {
		return modifyOn;
	}

	public void setModifyOn(Date modifyOn) {
		this.modifyOn = modifyOn;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/*public List<Aso> getAsoList() {
		return asoList;
	}

	public void setAsoList(List<Aso> asoList) {
		this.asoList = asoList;
	}*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public Country getCountryFkId() {
		return countryFkId;
	}

	public void setCountryFkId(Country countryFkId) {
		this.countryFkId = countryFkId;
	}

	public Integer getSalesOfficer() {
		return salesOfficer;
	}

	public void setSalesOfficer(Integer salesOfficer) {
		this.salesOfficer = salesOfficer;
	}

	public Integer getRegionalManager() {
		return regionalManager;
	}

	public void setRegionalManager(Integer regionalManager) {
		this.regionalManager = regionalManager;
	}

	public String getDistributorDmsId() {
		return distributorDmsId;
	}

	public void setDistributorDmsId(String distributorDmsId) {
		this.distributorDmsId = distributorDmsId;
	}

	public String getTermsCondition() {
		return termsCondition;
	}

	public void setTermsCondition(String termsCondition) {
		this.termsCondition = termsCondition;
	}

	public Integer getStockyardManager() {
		return stockyardManager;
	}

	public void setStockyardManager(Integer stockyardManager) {
		this.stockyardManager = stockyardManager;
	}

	public Integer getZsm() {
		return zsm;
	}

	public void setZsm(Integer zsm) {
		this.zsm = zsm;
	}

	
	
}
