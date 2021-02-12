package com.edfcsx.springbootendtoendapplication.services;

import com.edfcsx.springbootendtoendapplication.domain.Category;
import com.edfcsx.springbootendtoendapplication.repositories.CategoryRepository;
import com.edfcsx.springbootendtoendapplication.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        Optional<List<Category>> obj = Optional.of(categoryRepository.findAll());

        return obj.orElseThrow(() -> new ResourceNotFoundException(null));
    }

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
