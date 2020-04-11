	

package com.fq.tmall.dao;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fq.tmall.pojo.Product;
import com.fq.tmall.pojo.Property;
import com.fq.tmall.pojo.PropertyValue;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{

	List<PropertyValue> findByProductOrderByIdDesc(Product product);
	PropertyValue getByPropertyAndProduct(Property property, Product product);

	
	
	
}

	
