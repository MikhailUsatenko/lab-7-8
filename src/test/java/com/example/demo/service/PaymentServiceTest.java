package com.example.demo.service;

import com.example.demo.entity.Debt;
import com.example.demo.entity.Debtor;
import com.example.demo.repository.DebtRepository;
import com.example.demo.repository.DebtorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PaymentService.class })
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
class PaymentServiceTest {

	private final PaymentService paymentService;
	@MockBean
	private DebtorRepository debtorRepository;
	@MockBean
	private DebtRepository debtRepository;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void payDebtTest() {
		// arrange
		var id = 1;
		var debtor = new Debtor(1, "Oleg");
		var debtList = List.of(
				new Debt(1, 3500, debtor));
		var debtorOptional = Optional.of(debtor);
		debtor.setDebtList(debtList);
		var expectedResponse = debtor.getDebtList().get(0).getDebtSum();
		when(debtorRepository.findById(id)).thenReturn(debtorOptional);
		// act
		var actualResponse = paymentService.payDebt(id);
		// assert
		assertEquals(expectedResponse, actualResponse);
		verify(debtorRepository, times(1)).findById(id);
	}
}