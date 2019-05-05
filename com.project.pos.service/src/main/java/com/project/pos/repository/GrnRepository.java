package com.project.pos.repository;

import com.project.pos.model.Grn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GrnRepository extends JpaRepository<Grn,Integer> {

    List<Grn> findAllByDateBetween(Date sdate, Date edate);

    List<Grn> findAllBySupplier_idsupplier(int supplierId);

}
