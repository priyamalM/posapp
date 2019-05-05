package com.project.pos.controllers;

import com.project.pos.model.Grn;
import com.project.pos.service.GrnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController("/grn")
public class GrnController {

    @Autowired
    GrnService grnService;


    @GetMapping("/")
    public List<Grn> getGrnList(@RequestParam("sdate")Date sdate, @RequestParam("edate") Date edate){
        return grnService.getGrnsBetween(sdate,edate);
    }

    @GetMapping("/sup/{supid}")
    public List<Grn> getGrnListFromSupplierId(@PathVariable("supid") int supid){
       return grnService.getGrnsFromSupplier(supid);
    }



}
