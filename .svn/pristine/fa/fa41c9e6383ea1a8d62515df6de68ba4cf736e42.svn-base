package com.jspl.lms.model;

import java.io.Serializable;
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
import javax.persistence.Table;


@Entity
@Table(name = "material")
public class Material implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_pk_id")
	private Integer materialPkId;
	
	@Column(name = "material_code")
	private String materialCode;
	
	@Column(name = "material_desc")
	private String materialDesc;
	
	/*@Column(name = "material_sap_id")
	private String materialSapId;*/
	
	@Column(name = "material_dms_id")
	private String materialDmsId;
	
	@Column(name = "material_mkt_id")
	private String materialMktId;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "material_fk_id")
	private Integer materialFkId;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "material_fk_id", referencedColumnName = "material_pk_id")
	private List<MaterialPlantMap> materialPlant;
	
	@Column(name = "stock_material_code")
	private String stockMaterialCode;
	
	@Column(name = "order_by_mat")
	private String orderByMat;
	
	@ManyToOne
	@JoinColumn(name="sbu_type_fk_id")
	private  CommonConstant sbuTypeFkId;

	public Integer getMaterialPkId() {
		return materialPkId;
	}

	public void setMaterialPkId(Integer materialPkId) {
		this.materialPkId = materialPkId;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	/*public String getMaterialSapId() {
		return materialSapId;
	}

	public void setMaterialSapId(String materialSapId) {
		this.materialSapId = materialSapId;
	}*/

	public String getMaterialDmsId() {
		return materialDmsId;
	}

	public void setMaterialDmsId(String materialDmsId) {
		this.materialDmsId = materialDmsId;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getMaterialFkId() {
		return materialFkId;
	}

	public void setMaterialFkId(Integer materialFkId) {
		this.materialFkId = materialFkId;
	}

	public List<MaterialPlantMap> getMaterialPlant() {
		return materialPlant;
	}

	public void setMaterialPlant(List<MaterialPlantMap> materialPlant) {
		this.materialPlant = materialPlant;
	}

	public String getMaterialMktId() {
		return materialMktId;
	}

	public void setMaterialMktId(String materialMktId) {
		this.materialMktId = materialMktId;
	}

	public String getStockMaterialCode() {
		return stockMaterialCode;
	}

	public void setStockMaterialCode(String stockMaterialCode) {
		this.stockMaterialCode = stockMaterialCode;
	}

	public String getOrderByMat() {
		return orderByMat;
	}

	public void setOrderByMat(String orderByMat) {
		this.orderByMat = orderByMat;
	}

	public CommonConstant getSbuTypeFkId() {
		return sbuTypeFkId;
	}

	public void setSbuTypeFkId(CommonConstant sbuTypeFkId) {
		this.sbuTypeFkId = sbuTypeFkId;
	}
	
}


