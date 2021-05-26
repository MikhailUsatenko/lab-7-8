package com.example.demo.repository;

import com.example.demo.entity.Debt;
import com.example.demo.entity.Debtor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class DebtRepositoryTest {

	@Autowired
	private DebtRepository debtRepository;
	@Autowired
	private DebtorRepository debtorRepository;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	public void testCreateDebt() {
		var debtor =  new Debtor(1, "Oleg");
		debtorRepository.save(debtor);
		var debt = new Debt(1, 250, debtor);
		debtRepository.save(debt);
	}
}