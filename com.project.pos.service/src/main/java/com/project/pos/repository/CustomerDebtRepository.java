package com.project.pos.repository;

import com.project.pos.model.Customerdebt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDebtRepository extends JpaRepository<Customerdebt,Integer> {
}
