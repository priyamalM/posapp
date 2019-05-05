package com.project.pos.service;

import com.project.pos.model.Category;
import com.project.pos.model.Product;
import com.project.pos.repository.CategoryRepository;
import com.project.pos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    public Product saveProduct(Product product) {
        Product save = productRepository.save(product);
        return save;
    }

    public Product getProductId(int id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) return byId.get();
        return  null;
    }

    public List<Product> getProductsByName(String name) {
        List<Product> allByEnglishnameIgnoreCase = productRepository.findAllByEnglishnameIgnoreCase(name);
        return allByEnglishnameIgnoreCase;
    }
}
