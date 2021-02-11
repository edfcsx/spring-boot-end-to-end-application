package com.edfcsx.springbootendtoendapplication.config;

import com.edfcsx.springbootendtoendapplication.domain.Category;
import com.edfcsx.springbootendtoendapplication.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat = new Category(null, "Informática");
        Category cat1 = new Category(null, "Escritório");

        categoryRepository.saveAll(Arrays.asList(cat, cat1));
    }
}
