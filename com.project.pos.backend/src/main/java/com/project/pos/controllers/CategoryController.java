package com.project.pos.controllers;

import com.project.pos.model.Category;
import com.project.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Category> getCategories(){
        return productService.getAllCategories();
    }

    @PostMapping("/")
    public Category saveCategory(@RequestBody Category category){
        return productService.saveCategory(category);
    }


}
