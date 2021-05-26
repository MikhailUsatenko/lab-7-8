package com.example.demo.repository;

import com.example.demo.entity.Debtor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DebtorRepositoryTest {

	@Autowired
	private DebtorRepository debtorRepository;

	private static final List<Debtor> debtors = List.of(
			new Debtor(1,"Vasilii Vasiliev1"),
			new Debtor(2,"Vasilii Vasiliev2"),
			new Debtor(3,"Vasilii Vasiliev3"),
			new Debtor(4,"Vasilii Vasiliev4"),
			new Debtor(5, "Vasilii Vasiliev5")
	);

	@BeforeEach
	void setUp() {
		debtorRepository.deleteAll();
		debtorRepository.saveAll(debtors);
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	public void testCreateDebt() {
		var debtor =  new Debtor(1, "Oleg");
		debtorRepository.save(debtor);
	}

	@Test
	void testFindById() {
		// arrange
		var id = 3;
		var expectedDebtorOptional = debtors.stream().filter(file -> file.getId().equals(id)).findFirst();
		var expectedDebtor = expectedDebtorOptional.get();
		// act
		var debtorOptional = debtorRepository.findById(id);
		var debtor = debtorOptional.get();

		// assert
		assertEquals(expectedDebtor, debtor);
	}
}