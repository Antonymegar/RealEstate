package com.example.realestate.Repositories;

import com.example.realestate.model.CashDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashDepoRepo extends JpaRepository<CashDeposit,Long> {

}
