package com.edfcsx.springbootendtoendapplication.repositories;

import com.edfcsx.springbootendtoendapplication.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
