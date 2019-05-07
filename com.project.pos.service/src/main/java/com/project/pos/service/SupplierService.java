package com.project.pos.service;

import com.project.pos.model.Supplier;
import com.project.pos.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Supplier saveSupplier(Supplier supplier) {
        Supplier savedSupplier = supplierRepository.save(supplier);
        return savedSupplier;
    }


    public Supplier getSupplierById(int id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isPresent())return byId.get();
        return null;
    }

    public List<Supplier> getSuppliersByName(String name){
        return supplierRepository.findAllByName(name);
    }

    public List<Supplier> getSupplierByMobileNumber(String mob){
        return supplierRepository.findAllByMob(mob);
    }



}
