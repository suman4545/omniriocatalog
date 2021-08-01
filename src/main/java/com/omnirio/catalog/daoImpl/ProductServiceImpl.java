package com.omnirio.catalog.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.catalog.beans.Product;
import com.omnirio.catalog.dao.CatalogService;
import com.omnirio.catalog.dao.ProductService;
import com.omnirio.catalog.exception.DataPersisException;
import com.omnirio.catalog.exception.NoDeatailsFoundException;
import com.omnirio.catalog.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CatalogService catlog;

	@Override
	public Product saveProduct(Product product) {
		Product productdetails;
		try {
		product.setCategoty(catlog.findCatagoryById(product.getCategoty().getCatId()));
		product=productRepo.save(product);
    	productdetails=findproductById(product.getProductid());
		}
		catch (Exception ex) {
			throw new DataPersisException("Error In product save", ex);
		}
    	return productdetails;
	}

	@Override
	public Product findproductById(String id) {
		return productRepo.findById(id).orElseThrow(()->new NoDeatailsFoundException("Error In product search"));
	}
	

}
