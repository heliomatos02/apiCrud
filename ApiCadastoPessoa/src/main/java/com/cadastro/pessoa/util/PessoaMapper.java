package com.cadastro.pessoa.util;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cadastro.pessoa.dto.request.PessoaRequestDTO;
import com.cadastro.pessoa.dto.response.PessoaResponseDTO;
import com.cadastro.pessoa.entidade.Pessoa;

@Component
public class PessoaMapper {

	public Pessoa toPessoa(PessoaRequestDTO pessoaDTO) {
		
		return Pessoa.builder()
				.nome(pessoaDTO.getNome())
				.cpf(pessoaDTO.getCpf())
				.idade(pessoaDTO.getIdade())
				.build();
	}
	
	public PessoaResponseDTO toPessoaDTO(Pessoa pessoa) {
		return new PessoaResponseDTO(pessoa);
	}
	
	public List<PessoaResponseDTO> toPessoaDTO(List<Pessoa> pessoaList){
		return pessoaList.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
	}
	
	public void updatePessoaData(Pessoa pessoa, PessoaRequestDTO pessoDto) {
		pessoa.setCpf(pessoDto.getCpf());
		pessoa.setIdade(pessoDto.getIdade());
		pessoa.setNome(pessoDto.getNome());
	}
}
