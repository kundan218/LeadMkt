package com.jspl.lms.dto;

import java.math.BigDecimal;


public class Sales {
	
	private Integer xaxis;
	private Integer yaxis;
	private BigDecimal sale;
	
	public Integer getXaxis() {
		return xaxis;
	}
	public void setXaxis(Integer xaxis) {
		this.xaxis = xaxis;
	}
	
	
	public BigDecimal getSale() {
		return sale;
	}
	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}
	public Integer getYaxis() {
		return yaxis;
	}
	public void setYaxis(Integer yaxis) {
		this.yaxis = yaxis;
	}
	
	
	
}
