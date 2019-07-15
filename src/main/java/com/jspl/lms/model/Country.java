package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_pk_id")
	private Integer  countryPkId;

	@Column(name = "country_name")
	private String countryName;

	public Integer getCountryPkId() {
		return countryPkId;
	}

	public void setCountryPkId(Integer countryPkId) {
		this.countryPkId = countryPkId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
}
