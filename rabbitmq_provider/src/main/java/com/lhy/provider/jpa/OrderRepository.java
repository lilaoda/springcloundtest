package com.lhy.provider.jpa;

import com.lhy.provider.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> ,Serializable{
}
