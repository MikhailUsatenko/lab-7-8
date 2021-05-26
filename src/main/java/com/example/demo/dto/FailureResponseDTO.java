package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class FailureResponseDTO {

	private Integer status;
	private Long timestamp;
	private String message;
	private String[] errors;
}
