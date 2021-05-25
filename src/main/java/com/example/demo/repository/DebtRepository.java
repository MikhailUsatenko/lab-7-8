package com.example.demo.repository;

import com.example.demo.entity.Debt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository  extends CrudRepository<Debt, Integer> {
}
