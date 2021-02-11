package com.edfcsx.springbootendtoendapplication.services;

import com.edfcsx.springbootendtoendapplication.domain.Category;
import com.edfcsx.springbootendtoendapplication.repositories.CategoryRepository;
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

        return obj.get();
    }

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);

        return obj.get();
    }

}
