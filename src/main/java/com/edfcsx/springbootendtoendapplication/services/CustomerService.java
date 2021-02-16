package com.edfcsx.springbootendtoendapplication.services;

import com.edfcsx.springbootendtoendapplication.domain.Customer;
import com.edfcsx.springbootendtoendapplication.repositories.CustomerRepository;
import com.edfcsx.springbootendtoendapplication.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        Optional<List<Customer>> obj = Optional.of(customerRepository.findAll());

        return obj.orElseThrow(() -> new ResourceNotFoundException(null));
    }

    public Customer findById(Integer id) {
        Optional<Customer> obj = customerRepository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
