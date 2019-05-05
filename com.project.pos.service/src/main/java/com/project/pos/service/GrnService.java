package com.project.pos.service;

import com.project.pos.model.Grn;
import com.project.pos.repository.GrnRegRepository;
import com.project.pos.repository.GrnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GrnService {

    @Autowired
    GrnRepository grnRepository;

    public List<Grn> getGrnsBetween(Date sdate, Date edate) {
       return grnRepository.findAllByDateBetween(sdate, edate);
    }


    public List<Grn> getGrnsFromSupplier(int supid) {
        List<Grn> allBySupplier_idsupplier = grnRepository.findAllBySupplier_idsupplier(supid);
        return allBySupplier_idsupplier;
    }
}
