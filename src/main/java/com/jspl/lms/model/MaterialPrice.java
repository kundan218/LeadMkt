package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "material_price")
public class MaterialPrice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_price_pk_id")
	private Integer materialPricePkId;

	@Column(name = "distributor_sap_id")
	private String distributorSapId;
	
	@Column(name = "distributor_name")
	private String distributorName;
	
	@Column(name = "material_dms_id")
	private String materialDmsId;
	
	@Column(name = "material_mkt_id")
	private String materialMktId;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "material_Price")
	private Double materialPrice;

	public Integer getMaterialPricePkId() {
		return materialPricePkId;
	}

	public void setMaterialPricePkId(Integer materialPricePkId) {
		this.materialPricePkId = materialPricePkId;
	}



	public String getDistributorSapId() {
		return distributorSapId;
	}

	public void setDistributorSapId(String distributorSapId) {
		this.distributorSapId = distributorSapId;
	}

	public String getMaterialDmsId() {
		return materialDmsId;
	}

	public void setMaterialDmsId(String materialDmsId) {
		this.materialDmsId = materialDmsId;
	}

	public String getMaterialMktId() {
		return materialMktId;
	}

	public void setMaterialMktId(String materialMktId) {
		this.materialMktId = materialMktId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getMaterialPrice() {
		return materialPrice;
	}

	public void setMaterialPrice(Double materialPrice) {
		this.materialPrice = materialPrice;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}



}


