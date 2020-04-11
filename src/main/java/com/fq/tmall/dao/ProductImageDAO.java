	

package com.fq.tmall.dao;
 
import java.util.List;

import com.fq.tmall.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fq.tmall.pojo.Product;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer>{
	public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
	
}

	
