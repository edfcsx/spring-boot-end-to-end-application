package com.edfcsx.springbootendtoendapplication.repositories;

import com.edfcsx.springbootendtoendapplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
