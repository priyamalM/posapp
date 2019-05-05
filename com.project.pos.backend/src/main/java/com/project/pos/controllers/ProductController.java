package com.project.pos.controllers;

import com.project.pos.model.Product;
import com.project.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product){
       Product savedProduct = productService.saveProduct(product);
       return savedProduct;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id){
        Product productId = productService.getProductId(id);
        return productId;
    }


    @GetMapping("/findbyname")
    public List<Product> getProductByName(@RequestParam(value = "name",required = true) String name) {
        return productService.getProductsByName(name);
    }

}
