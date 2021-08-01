package com.omnirio.catalog.dao;

import java.util.Optional;

import com.omnirio.catalog.beans.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	public Product findproductById(String id);


}
