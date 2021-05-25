package com.example.demo.repository;

import com.example.demo.entity.Debtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorRepository extends CrudRepository<Debtor, Integer> {
}
