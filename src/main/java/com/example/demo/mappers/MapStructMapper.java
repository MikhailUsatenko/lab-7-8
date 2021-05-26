package com.example.demo.mappers;

import com.example.demo.dto.DebtDTO;
import com.example.demo.dto.DebtorDTO;
import com.example.demo.entity.Debt;
import com.example.demo.entity.Debtor;
import org.mapstruct.Mapper;

@Mapper(
		componentModel = "spring"
)
public interface MapStructMapper {

	DebtorDTO debtorToDebtorDTO(
			Debtor debtor
	);

	Debtor DebtorDTOToDebtor(
			DebtorDTO debtorDTO
	);

	DebtDTO debtToDebtDTO(
			Debt debt
	);

	Debt DebtDTOToDebt(
			DebtDTO debtDTO
	);

}