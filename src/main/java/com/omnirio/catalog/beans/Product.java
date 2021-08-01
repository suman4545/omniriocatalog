package com.omnirio.catalog.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="product_id",unique=true,nullable=false)
	@Id
	@GenericGenerator(name="seq_id", strategy="com.omnirio.catalog.utility.ProductIdGenerator")
	@GeneratedValue(generator="seq_id")
	@Column(name = "product_id", unique = true, nullable = false, length = 20)
	private String productid;
	
	@NotEmpty
	@Column
	private String productName;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="catId")
	@Valid
	private Catagory categoty;
	
	
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Catagory getCategoty() {
		return categoty;
	}

	public void setCategoty(Catagory categoty) {
		this.categoty = categoty;
	}
	
	
	
	
	
	
	

}
