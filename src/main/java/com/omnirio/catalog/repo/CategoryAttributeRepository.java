package com.omnirio.catalog.repo;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.catalog.beans.CategoryAttribute;
@Repository
public interface CategoryAttributeRepository extends CrudRepository<CategoryAttribute, Integer>{

	@Cacheable(value="CategoryAttribute")
	Optional<CategoryAttribute> findById(int id);
}
