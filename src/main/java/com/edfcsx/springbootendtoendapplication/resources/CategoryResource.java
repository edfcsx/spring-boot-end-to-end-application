package com.edfcsx.springbootendtoendapplication.resources;

import com.edfcsx.springbootendtoendapplication.domain.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @GetMapping
    public ResponseEntity<List<Category>> findALl() {

        Category cat = new Category(1, "Informática");
        Category cat1 = new Category(2, "Escritório");

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(cat);
        categoryList.add(cat1);

        return ResponseEntity.ok().body(categoryList);
    }

}
