package com.example.demo.service;

import com.example.demo.entity.Debt;
import com.example.demo.repository.DebtRepository;
import com.example.demo.repository.DebtorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {

	private final DebtorRepository debtorRepository;
	private final DebtRepository debtRepository;

	public Integer payDebt(Integer debtorId) {
		return debtorRepository.findById(debtorId).map(debtor -> {
			var firstDebtSum = debtor.getDebtList().get(0).getDebtSum();
			businessLogicForPayment(firstDebtSum);
			return firstDebtSum;
		}).orElseThrow(() -> new IllegalArgumentException("debtor not found"));
	}

	private void businessLogicForPayment(Integer sum) {

	}
}
