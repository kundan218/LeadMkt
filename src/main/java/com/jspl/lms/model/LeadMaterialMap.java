package com.jspl.lms.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lead_material_map")
public class LeadMaterialMap {
	
	
	private static final long serialVersionUID = 1L;

	/** The role id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lead_material_map_pk_id")
	private Integer leadMaterialMapPkId ;
	
	/** The quantity. */
	@Column(name = "quantity")
	private BigDecimal quantity;
	
	@ManyToOne
	@JoinColumn(name="material_fk_id")
	private Material materialFkId;
	
	

	public Integer getLeadMaterialMapPkId() {
		return leadMaterialMapPkId;
	}

	public void setLeadMaterialMapPkId(Integer leadMaterialMapPkId) {
		this.leadMaterialMapPkId = leadMaterialMapPkId;
	}

	public Material getMaterialFkId() {
		return materialFkId;
	}

	public void setMaterialFkId(Material materialFkId) {
		this.materialFkId = materialFkId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
