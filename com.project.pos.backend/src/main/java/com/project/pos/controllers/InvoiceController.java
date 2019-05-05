package com.project.pos.controllers;

import com.project.pos.model.Invoice;
import com.project.pos.model.request.InvoiceRequest;
import com.project.pos.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/")
    public Invoice saveInvoice(InvoiceRequest invoiceRequest){
        Invoice invoice = invoiceService.saveInvoice(invoiceRequest);
        return invoice;
    }

    @GetMapping("/lastone")
    public Invoice getLastInvoice(){
        Invoice lastInvoice = invoiceService.getLastInvoice();
        return lastInvoice;
    }

    @GetMapping("/last")
    public List<Invoice> getLastInvoiceList(@RequestParam(value = "count",defaultValue = "10") int count  ){
        if (count>10) count = 10;
        Pageable pageable = PageRequest.of(0,count, Sort.Direction.DESC,"idinvoice");
        return invoiceService.getLastInvoiceList(pageable);
    }


}