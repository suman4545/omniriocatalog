package com.omnirio.catalog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.catalog.beans.Catagory;
import com.omnirio.catalog.beans.CategoryAttribute;
import com.omnirio.catalog.beans.Product;
import com.omnirio.catalog.dao.CatalogService;
import com.omnirio.catalog.dao.CategoryAttributeService;
import com.omnirio.catalog.dao.ProductService;
import com.omnirio.catalog.utility.ValidatorUtility;

@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	CatalogService catlog;
	@Autowired
	CategoryAttributeService catagoryAttrService;
	@Autowired
	ProductService productService;
	@Autowired
	ValidatorUtility validatorUtility;
	
	@PostMapping(value="/addcatalog",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Catagory> addCatalog(RequestEntity<Catagory> requestEntity) {
		logger.info("Request Body:"+requestEntity.getBody());      
		Catagory catalog=requestEntity.getBody();
		validatorUtility.validate(catalog);
		catalog=catlog.saveCatalog(requestEntity.getBody());
		if(catalog.getCatId()>0 ) {
			 return new ResponseEntity<Catagory>(catalog, HttpStatus.CREATED);	
		}
		 return new ResponseEntity<Catagory>(HttpStatus.CONFLICT);
		
	}
	
	@PostMapping(value="/addatribute",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryAttribute> addAttribute(RequestEntity<CategoryAttribute> requestEntity) {
		logger.info("Request Body:"+requestEntity.getBody());      
		CategoryAttribute catalogattribute=requestEntity.getBody();
		validatorUtility.validate(catalogattribute);
		catalogattribute=catagoryAttrService.saveCatalogAttribte(requestEntity.getBody());
		if(catalogattribute.getId()>0) {
			 return new ResponseEntity<CategoryAttribute>(catalogattribute, HttpStatus.CREATED);	
		}
		 return new ResponseEntity<CategoryAttribute>(HttpStatus.CONFLICT);
	}
	
	@GetMapping(value="/getcatagory/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Catagory> getcatagory(@PathVariable int id) {
		//logger.info("Request Body:"+requestEntity.getBody());      
		Catagory Catagory=catlog.findCatagoryById(id);
		 return new ResponseEntity<Catagory>(Catagory, HttpStatus.OK);	
	}
	
	@PostMapping(value="/product/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createproduct(RequestEntity<Product> requestEntity)
	{	
	logger.info("Request Body:"+requestEntity.getBody());      
		Product product=requestEntity.getBody();
		validatorUtility.validate(product);
		product=productService.saveProduct(product); 
		if(product!=null) {
			 return new ResponseEntity<Product>(product, HttpStatus.CREATED);	
		}
		 return new ResponseEntity<Product>(HttpStatus.CONFLICT);		
		
	}
	
	@GetMapping(value="/getproduct/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getproduct(@PathVariable String id) {
		//logger.info("Request Body:"+requestEntity.getBody());      
		Product product=productService.findproductById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);	
	}
	
	 

}
