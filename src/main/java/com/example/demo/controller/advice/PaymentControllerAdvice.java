package com.example.demo.controller.advice;

import com.example.demo.controller.PaymentController;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = {PaymentController.class})
@Slf4j
public class PaymentControllerAdvice {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleRefreshTokenException(IllegalArgumentException exception) {
		log.error("Handle the IllegalArgumentException with message: {}", exception.getMessage());
		return exception.getMessage();
	}
}
