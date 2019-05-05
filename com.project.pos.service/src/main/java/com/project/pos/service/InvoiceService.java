package com.project.pos.service;

import com.project.pos.model.Customer;
import com.project.pos.model.Invoice;
import com.project.pos.model.request.InvoiceRequest;
import com.project.pos.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    CustomerService customerService;

    @Autowired
    InvoiceRepository invoiceRepository;


    public Invoice convertToInvoiceEntity(InvoiceRequest invoiceRequest){
        Invoice invoice = new Invoice();
        invoice.setDate(new Date());
        Optional<Customer> customerbean = customerService.findByCustomerID(invoiceRequest.getCustomer());
        if (customerbean.isPresent()) invoice.setCustomer(customerbean.get());
        invoice.setInvtype(invoiceRequest.getInvtype());
        invoice.setPaid(invoiceRequest.getPaid());
        invoice.setPaytype(invoiceRequest.getPaytype());
        invoice.setRemain(invoiceRequest.getRemain());
        invoice.setTotal(invoiceRequest.getTotal());
        invoice.setInvoiceregs(invoiceRequest.getInvoiceregList());
        return invoice;
    }

    public Invoice saveInvoice(InvoiceRequest invoiceRequest) {
        Invoice invoice = convertToInvoiceEntity(invoiceRequest);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return  savedInvoice;
    }


    public Invoice getLastInvoice(){
        Invoice topByOrderByIdinvoice = invoiceRepository.findTopByOrderByIdinvoice();
        return topByOrderByIdinvoice;
    }


    public List<Invoice> getLastInvoiceList(Pageable pageable) {
        List<Invoice> allByOrderByIdinvoice = invoiceRepository.findAllByOrderByIdinvoice(pageable);
        return allByOrderByIdinvoice;
    }
}