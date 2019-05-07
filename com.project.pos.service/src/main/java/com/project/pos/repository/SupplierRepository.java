package com.project.pos.repository;

import com.project.pos.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    List<Supplier> findAllByName(String name);
    List<Supplier> findAllByMob(String mob);

}
