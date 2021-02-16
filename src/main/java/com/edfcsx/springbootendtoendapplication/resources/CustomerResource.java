package com.edfcsx.springbootendtoendapplication.resources;

import com.edfcsx.springbootendtoendapplication.domain.Category;
import com.edfcsx.springbootendtoendapplication.domain.Customer;
import com.edfcsx.springbootendtoendapplication.services.CategoryService;
import com.edfcsx.springbootendtoendapplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findALl() {
        List<Customer> obj = customerService.findAll();

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id) {
        Customer obj = customerService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

}
