package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "debtor", schema = "public",
		uniqueConstraints = @UniqueConstraint(columnNames = "full_name"))
public class Debtor {
	@Id
	private Integer id;

	@Column(name = "full_name")
	private String fullName;

	@OneToMany(mappedBy="debtor")
	private List<Debt> debtList;

	public Debtor(Integer id, String fullName) {
		this.id = id;
		this.fullName = fullName;
	}
}
