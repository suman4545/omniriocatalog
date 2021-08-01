package com.omnirio.catalog.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.catalog.beans.CategoryAttribute;
import com.omnirio.catalog.dao.CategoryAttributeService;
import com.omnirio.catalog.repo.CategoryAttributeRepository;

@Service
public class CategoryAttributeServiceImpl implements CategoryAttributeService{
 
	@Autowired
	CategoryAttributeRepository CategoryAttributeRepo;

	@Override
	public CategoryAttribute saveCatalogAttribte(CategoryAttribute catalogAttribte) {
		catalogAttribte=CategoryAttributeRepo.save(catalogAttribte);
    	Optional<CategoryAttribute>catlogattr=findcatalogAttribteById(catalogAttribte.getId());
    	return catlogattr.orElseThrow(()->new RuntimeException("Error In catalog save"));
	}

	@Override
	public Optional<CategoryAttribute> findcatalogAttribteById(int attributeId) {
		return CategoryAttributeRepo.findById(attributeId);
	}
	

}
