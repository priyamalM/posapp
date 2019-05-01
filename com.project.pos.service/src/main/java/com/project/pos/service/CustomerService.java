package com.project.pos.service;

import com.project.pos.model.Customer;
import com.project.pos.model.Customerdebt;
import com.project.pos.repository.CustomerDebtRepository;
import com.project.pos.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDebtRepository customerDebtRepository;


    public Optional<Customer> findByCustomerID(int id){
         final Optional<Customer> byId = customerRepository.findById(id);
         return byId;
    }

    public Customer saveCustomer(Customer customer){
        if (customer!=null) return customerRepository.save(customer);
        return null;
    }


    public Customerdebt addDebt(Customerdebt customerdebt, int id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()) return byId.get().addCustomerdebt(customerdebt);
        return null;
    }

    public List<Customerdebt> getAllDebtsHistory(int id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()) return byId.get().getCustomerdebts();
        return null;
    }
}
