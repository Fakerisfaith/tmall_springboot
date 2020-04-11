	

package com.fq.tmall.dao;

import java.util.List;

import com.fq.tmall.pojo.Order;
import com.fq.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fq.tmall.pojo.OrderItem;
import com.fq.tmall.pojo.Product;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
	List<OrderItem> findByOrderOrderByIdDesc(Order order);
	List<OrderItem> findByProduct(Product product);
	List<OrderItem> findByUserAndOrderIsNull(User user);
}

	
