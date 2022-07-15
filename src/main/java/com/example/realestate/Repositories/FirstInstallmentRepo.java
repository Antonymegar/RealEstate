package com.example.realestate.Repositories;

import com.example.realestate.model.FirstInstallment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstInstallmentRepo extends JpaRepository<FirstInstallment, Long> {
}
