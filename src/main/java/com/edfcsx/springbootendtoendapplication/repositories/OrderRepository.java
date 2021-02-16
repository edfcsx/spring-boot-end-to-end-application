package com.edfcsx.springbootendtoendapplication.repositories;

import com.edfcsx.springbootendtoendapplication.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
