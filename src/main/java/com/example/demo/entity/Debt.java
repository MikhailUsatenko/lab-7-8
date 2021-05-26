package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "debt")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Debt {
	@Id
	private Integer id;

	@Column(name = "sum_of_debt")
	private Integer debtSum;

	@ManyToOne
	@JoinColumn(name="debtor_id", nullable=false)
	private Debtor debtor;

	public Debt(Integer id, Integer debtSum, Debtor debtor) {
		this.id = id;
		this.debtSum = debtSum;
		this.debtor = debtor;
	}
}
