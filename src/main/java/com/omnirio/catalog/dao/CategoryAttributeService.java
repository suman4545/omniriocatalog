package com.omnirio.catalog.dao;

import java.util.Optional;

import com.omnirio.catalog.beans.CategoryAttribute;

public interface CategoryAttributeService {
	
	public CategoryAttribute saveCatalogAttribte(CategoryAttribute catalogAttribte);
	public Optional<CategoryAttribute> findcatalogAttribteById(int attributeId);
	

}
