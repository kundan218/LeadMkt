package com.jspl.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "material_plant_map")
public class MaterialPlantMap implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_plant_map_pk_id")
	private Integer materialPlantMapPkId;
	
	@Column(name = "material_plant_name")
	private String materialPlantName;
	
	@Column(name = "plant_name")
	private String plantName;

	@Column(name = "status")
	private Boolean status;

	public Integer getMaterialPlantMapPkId() {
		return materialPlantMapPkId;
	}

	public void setMaterialPlantMapPkId(Integer materialPlantMapPkId) {
		this.materialPlantMapPkId = materialPlantMapPkId;
	}

	public String getMaterialPlantName() {
		return materialPlantName;
	}

	public void setMaterialPlantName(String materialPlantName) {
		this.materialPlantName = materialPlantName;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


}


