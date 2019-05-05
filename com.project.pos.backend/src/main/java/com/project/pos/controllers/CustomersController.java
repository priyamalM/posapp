package com.project.pos.controllers;

import com.project.pos.model.Customer;
import com.project.pos.model.Customerdebt;
import com.project.pos.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomersController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        return customerService.findByCustomerID(id).get();
    }

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/{id}/adddebt")
    public Customerdebt addDebt(@RequestBody Customerdebt customerdebt, @PathVariable("id") int id){
        return customerService.addDebt(customerdebt,id);
    }

    @GetMapping("/{id}/getdebts")
    public List<Customerdebt> getAlDebts(@PathVariable("id") int id){
        return customerService.getAllDebtsHistory(id);
    }

    @GetMapping("/{id}/currentdebt")
    public Double getCurrentDebt(@PathVariable("id") int id){
        Optional<Customer> byCustomerID = customerService.findByCustomerID(id);
        return byCustomerID.get().getDebt();
    }

}
