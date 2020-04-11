	

package com.fq.tmall.dao;
 
import java.util.List;

import com.fq.tmall.pojo.Order;
import com.fq.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order,Integer>{
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}

	
