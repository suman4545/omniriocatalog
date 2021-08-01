package com.omnirio.catalog.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class CategoryAttribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="attr_id",unique=true,nullable=false)
	private int id;
	
	
	@NotEmpty(message = "attributename may not be empty")
	@Column
	String attributename;
	
	public String getAttributename() {
		return attributename;
	}

	public void setAttributename(String attributename) {
		this.attributename = attributename;
	}

	public String getAttributevalue() {
		return attributevalue;
	}

	public void setAttributevalue(String attributevalue) {
		this.attributevalue = attributevalue;
	}

	@NotEmpty(message = "attributevalue may not be empty")
	@Column
	String attributevalue;
	
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	 
	

}
