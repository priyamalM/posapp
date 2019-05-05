package com.project.pos.repository;

import com.project.pos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
   List<Product> findAllByEnglishnameIgnoreCase(String name);
}
