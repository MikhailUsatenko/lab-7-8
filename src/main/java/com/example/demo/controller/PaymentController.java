package com.example.demo.controller;

import com.example.demo.entity.Debt;
import com.example.demo.service.DebtorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/v1")
public class PaymentController {

	private final DebtorService debtorService;

	@PostMapping("/pay/{id}")
	public ResponseEntity<String> makePayment(@PathVariable Integer id) {
		debtorService.payDebt(id);
		return ResponseEntity.ok("Payment was successful");
	}
}
