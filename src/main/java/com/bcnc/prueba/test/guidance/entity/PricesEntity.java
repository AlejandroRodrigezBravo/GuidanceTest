package com.bcnc.prueba.test.guidance.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Clase que representa a la tabla prices
 * 
 * @author bravo
  * @version 25/08/2023 1.0.0
 */
@Entity
@Table(name = "prices")
public class PricesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "brandId")	
	private String brandId;
	
	@Column(name = "startDate")
	@Temporal(TemporalType.TIMESTAMP) //Aqui en vez de un localDateTime se puede rectificar y añadir un localDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime startDate;
	
	@Column(name = "endDate")
	@Temporal(TemporalType.TIMESTAMP)//Aqui en vez de un localDateTime se puede rectificar y añadir un localDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime endDate;

	@Column(name = "priceList")
	private Long priceList;

	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "priority")
	private String priority;

	@Column(name = "price")
	private Double price;

	@Column(name = "curr")
	private String curr;

	public PricesEntity() {
		
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}



	@Override
	public String toString() {
		return "Prices [id=" + id + ", brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", priceList=" + priceList + ", productId=" + productId + ", priority=" + priority + ", price="
				+ price + ", curr=" + curr + "]";
	}

	

	

}
