package com.omnirio.catalog.dao;

import com.omnirio.catalog.beans.Catagory;

public interface CatalogService {
	
	
	public Catagory saveCatalog(Catagory catalog);
	public Catagory findCatagoryById(int catId);

}
