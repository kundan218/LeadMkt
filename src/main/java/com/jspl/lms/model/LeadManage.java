package com.jspl.lms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class Role.
 */
@Entity
@Table(name = "lead_manage")
public class LeadManage implements Serializable {

	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lead_manage_pk_id")
	private Integer leadManagePkId;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "lead_id")
	private String leadId;

	/** The amount . */
	@Column(name = "amount")
	private String amount;

	@OneToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	@DateTimeFormat(pattern = "DD-MM-YYYY HH:mm:ss.S")
	@Column(name = "created_date")
	private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "country_fk_id")
	private Country countryFkId;

	@ManyToOne
	@JoinColumn(name = "state_fk_id")
	private State stateFkId;

	@Column(name = "location")
	private String location;

	@ManyToOne
	@JoinColumn(name = "region_fk_id")
	private Region regionFkId;

	@ManyToOne
	@JoinColumn(name = "lead_type_fk_id")
	private CommonConstant leadTypeFkId;

	@ManyToOne
	@JoinColumn(name = "sbu_type_fk_id")
	private CommonConstant sbuFkId;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "lead_manage_fk_id", referencedColumnName = "lead_manage_pk_id")
	private List<LeadMaterialMap> leadMaterialMaps;

	@Column(name = "pin_code")
	private Integer pinCode;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "house_no")
	private String houseNo;
	
	@Column(name = "comment")
	private String comment;

	@ManyToOne
	@JoinColumn(name = "lead_source_fk_id")
	private LeadSource leadSourceFkId;
	/*
	 * @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "lead_manage_fk_id", referencedColumnName =
	 * "leadManagePkId") private CustomerDetail customerDetail;
	 */

	/*
		*//** The status. *//*
							 * @Column(name = "status_fk_id")//,
							 * columnDefinition="tinyint(1) default 1") private
							 * Integer statusFkId;
							 */

	@ManyToOne
	@JoinColumn(name = "lead_status")
	private CommonConstant leadStatus;

	@Transient
	private Integer commonConstantPkId;

	@Transient
	private String commonConstantValue;

	@Transient
	private String userName;
	
	@Transient
	private String companyName;

	@Transient
	private BigInteger totalLead;
	
	@OneToOne
	@JoinColumn(name = "rsm_assign_fk_id")
	private User rsmAssignFkId;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="rsm_assign_date")
	private Date rsmAssignDate;
	
	@OneToOne
	@JoinColumn(name = "so_assign_fk_id")
	private User soAssignFkId;
	
	@OneToOne
	@JoinColumn(name = "stockyard_assign_fk_id")
	private User stockyardAssignFkId;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="so_assign_date")
	private Date soAssignDate;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="stockyard_assign_date")
	private Date stockyardAssignDate;
	
	@Column(name = "total_quantity")
	private BigDecimal totalQuantity;
	
	@Column(name = "action_comment")
	private String actionCommnet;
	
	@OneToOne
	@JoinColumn(name = "cancelled_by")
	private User cancelledBy;
	
	@OneToOne
	@JoinColumn(name = "converted_to_sale_by")
	private User convertedToSaleBy;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="cancelled_date")
	private Date cancelledDate;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss.S")
	@Column(name="converted_to_sale_date")
	private Date convertedToSaleDate;


	public Integer getLeadManagePkId() {
		return leadManagePkId;
	}

	public void setLeadManagePkId(Integer leadManagePkId) {
		this.leadManagePkId = leadManagePkId;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public CommonConstant getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(CommonConstant leadStatus) {
		this.leadStatus = leadStatus;
	}

	public Integer getCommonConstantPkId() {
		return commonConstantPkId;
	}

	public void setCommonConstantPkId(Integer commonConstantPkId) {
		this.commonConstantPkId = commonConstantPkId;
	}

	public String getCommonConstantValue() {
		return commonConstantValue;
	}

	public void setCommonConstantValue(String commonConstantValue) {
		this.commonConstantValue = commonConstantValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigInteger getTotalLead() {
		return totalLead;
	}

	public void setTotalLead(BigInteger totalLead) {
		this.totalLead = totalLead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Country getCountryFkId() {
		return countryFkId;
	}

	public void setCountryFkId(Country countryFkId) {
		this.countryFkId = countryFkId;
	}

	public State getStateFkId() {
		return stateFkId;
	}

	public void setStateFkId(State stateFkId) {
		this.stateFkId = stateFkId;
	}



	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Region getRegionFkId() {
		return regionFkId;
	}

	public void setRegionFkId(Region regionFkId) {
		this.regionFkId = regionFkId;
	}

	public CommonConstant getLeadTypeFkId() {
		return leadTypeFkId;
	}

	public void setLeadTypeFkId(CommonConstant leadTypeFkId) {
		this.leadTypeFkId = leadTypeFkId;
	}

	public LeadSource getLeadSourceFkId() {
		return leadSourceFkId;
	}

	public void setLeadSourceFkId(LeadSource leadSourceFkId) {
		this.leadSourceFkId = leadSourceFkId;
	}

	public CommonConstant getSbuFkId() {
		return sbuFkId;
	}

	public void setSbuFkId(CommonConstant sbuFkId) {
		this.sbuFkId = sbuFkId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}



	public List<LeadMaterialMap> getLeadMaterialMaps() {
		return leadMaterialMaps;
	}

	public void setLeadMaterialMaps(List<LeadMaterialMap> leadMaterialMaps) {
		this.leadMaterialMaps = leadMaterialMaps;
	}

	public User getRsmAssignFkId() {
		return rsmAssignFkId;
	}

	public void setRsmAssignFkId(User rsmAssignFkId) {
		this.rsmAssignFkId = rsmAssignFkId;
	}

	public Date getRsmAssignDate() {
		return rsmAssignDate;
	}

	public void setRsmAssignDate(Date rsmAssignDate) {
		this.rsmAssignDate = rsmAssignDate;
	}

	public User getSoAssignFkId() {
		return soAssignFkId;
	}

	public void setSoAssignFkId(User soAssignFkId) {
		this.soAssignFkId = soAssignFkId;
	}

	public Date getSoAssignDate() {
		return soAssignDate;
	}

	public void setSoAssignDate(Date soAssignDate) {
		this.soAssignDate = soAssignDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(BigDecimal total_quantity) {
		this.totalQuantity = total_quantity;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getActionCommnet() {
		return actionCommnet;
	}

	public void setActionCommnet(String actionCommnet) {
		this.actionCommnet = actionCommnet;
	}

	public User getStockyardAssignFkId() {
		return stockyardAssignFkId;
	}

	public void setStockyardAssignFkId(User stockyardAssignFkId) {
		this.stockyardAssignFkId = stockyardAssignFkId;
	}

	public Date getStockyardAssignDate() {
		return stockyardAssignDate;
	}

	public void setStockyardAssignDate(Date stockyardAssignDate) {
		this.stockyardAssignDate = stockyardAssignDate;
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

	public Date getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(Date cancelledDate) {
		this.cancelledDate = cancelledDate;
	}

	public Date getConvertedToSaleDate() {
		return convertedToSaleDate;
	}

	public void setConvertedToSaleDate(Date convertedToSaleDate) {
		this.convertedToSaleDate = convertedToSaleDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
