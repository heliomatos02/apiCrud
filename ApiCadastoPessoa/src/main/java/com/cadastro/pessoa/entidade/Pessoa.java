package com.cadastro.pessoa.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="tb_pessoa")
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	@Setter(AccessLevel.NONE)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@Column(name = "idade", nullable = false)
	private Integer idade;
	
	@Builder
	public Pessoa(String nome, String cpf, Integer idade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
}
