package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="aso")
public class Aso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aso_pk_id")
	private Integer asoPkId;
	
	@Column(name="aso_name")
	private String asoName;
	
	@Column(name="aso_contact")
	private String asoContact;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="distributor_fk_id")
	private Distributor distributorFkId;
	
	@Column(name="email_id")
	private String emailId;

	public Integer getAsoPkId() {
		return asoPkId;
	}

	public void setAsoPkId(Integer asoPkId) {
		this.asoPkId = asoPkId;
	}

	public String getAsoName() {
		return asoName;
	}

	public void setAsoName(String asoName) {
		this.asoName = asoName;
	}

	public String getAsoContact() {
		return asoContact;
	}

	public void setAsoContact(String asoContact) {
		this.asoContact = asoContact;
	}

	public Distributor getDistributorFkId() {
		return distributorFkId;
	}

	public void setDistributorFkId(Distributor distributorFkId) {
		this.distributorFkId = distributorFkId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
