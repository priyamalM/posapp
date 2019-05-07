package com.project.pos.controllers;

import com.project.pos.model.Supplier;
import com.project.pos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;


    @PostMapping("/")
    public Supplier saveSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable("id") int id) {
        return supplierService.getSupplierById(id);
    }

    @GetMapping("/byname")
    public List<Supplier> getSupplierByName(@RequestParam("name") String name) {
        return supplierService.getSuppliersByName(name);
    }

    @GetMapping("/bymob")
    public List<Supplier> getSupplierByMob(@RequestParam("mob") String mob) {
        return supplierService.getSupplierByMobileNumber(mob);
    }


}