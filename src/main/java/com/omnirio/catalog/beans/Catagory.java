package com.omnirio.catalog.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
public class Catagory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cat_id",unique=true,nullable=false)
	private int catId;
	
	@NotEmpty
	@Column
	private String catName;
	
	@Valid
	@ManyToMany
	@JoinTable( name="Catagoty_Attr_Map", joinColumns = { @JoinColumn(name="cat_id")},
	                                     inverseJoinColumns={@JoinColumn(name="attr_id")},
	                                     uniqueConstraints = {@UniqueConstraint(columnNames={"cat_id", "attr_id"})}	)
	private List<CategoryAttribute>attribute;

	public List<CategoryAttribute> getAttribute() {
		return attribute;
	}

	public void setAttribute(List<CategoryAttribute> attribute) {
		this.attribute = attribute;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
	
	 
	
	
	
	
	
	
	
	 

}
