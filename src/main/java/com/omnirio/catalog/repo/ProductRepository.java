package com.omnirio.catalog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.omnirio.catalog.beans.Product;

 
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	@Query("SELECT m FROM Product m WHERE m.productid=:id")
	Optional<Product> findById(@Param("id")String id);

}
