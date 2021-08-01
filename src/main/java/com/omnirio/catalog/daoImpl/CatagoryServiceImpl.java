package com.omnirio.catalog.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omnirio.catalog.beans.Catagory;
import com.omnirio.catalog.dao.CatalogService;
import com.omnirio.catalog.exception.DataPersisException;
import com.omnirio.catalog.exception.NoDeatailsFoundException;
import com.omnirio.catalog.repo.CatagoryRepository;

@Service
public class CatagoryServiceImpl implements CatalogService{

	@Autowired
	CatagoryRepository catalogRepo;
	
	@Override
	public Catagory saveCatalog(Catagory catalog) {
		try {
			catalog=catalogRepo.save(catalog);
	    	Catagory catlogg=findCatagoryById(catalog.getCatId());
	    	return catlogg;
		}
		catch(Exception ex){
			throw new DataPersisException("Error In catalog save", ex);
		}
		
	}

	@Override
	public Catagory findCatagoryById(int catId) {
		return catalogRepo.findById(catId).orElseThrow(()->new NoDeatailsFoundException("Error In catalog search"));
	
	}
	
}
