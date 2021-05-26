package com.example.demo.repository;

import com.example.demo.entity.Debtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DebtorRepository extends CrudRepository<Debtor, Integer> {
	@Override
	Optional<Debtor> findById(Integer integer);
}
