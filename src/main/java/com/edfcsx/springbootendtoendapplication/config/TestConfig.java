package com.edfcsx.springbootendtoendapplication.config;

import com.edfcsx.springbootendtoendapplication.domain.Category;
import com.edfcsx.springbootendtoendapplication.domain.Product;
import com.edfcsx.springbootendtoendapplication.repositories.CategoryRepository;
import com.edfcsx.springbootendtoendapplication.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat = new Category(null, "Informática");
        Category cat1 = new Category(null, "Escritório");

        categoryRepository.saveAll(Arrays.asList(cat, cat1));

        Product p1 = new Product(null, "Computador", 2000.00);
        Product p2 = new Product(null, "Impressora", 800.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        p1.getCategories().addAll(Arrays.asList(cat));
        p2.getCategories().addAll(Arrays.asList(cat, cat1));
        p3.getCategories().addAll(Arrays.asList(cat));

        productRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
