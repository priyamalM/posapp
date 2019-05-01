package com.project.pos.repository;

import com.project.pos.model.Invoicereg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRegRepository extends JpaRepository<Invoicereg,Integer> {
}
