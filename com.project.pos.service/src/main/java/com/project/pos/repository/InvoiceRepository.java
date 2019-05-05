package com.project.pos.repository;

import com.project.pos.model.Invoice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    Invoice findTopByOrderByIdinvoice();
    List<Invoice> findAllByOrderByIdinvoice(Pageable pageable);

}