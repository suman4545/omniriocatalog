package com.omnirio.catalog.repo;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.catalog.beans.Catagory;

@Repository
public interface CatagoryRepository extends CrudRepository<Catagory, Integer>{

	@Cacheable(value="Category")
	Optional<Catagory> findById(int catId);
}
