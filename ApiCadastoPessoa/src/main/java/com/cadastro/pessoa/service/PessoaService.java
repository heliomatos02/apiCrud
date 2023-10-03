package com.cadastro.pessoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cadastro.pessoa.dto.request.PessoaRequestDTO;
import com.cadastro.pessoa.dto.response.PessoaResponseDTO;


public interface PessoaService {

	PessoaResponseDTO findById(Long id);
	
	List<PessoaResponseDTO> findAll();
	
	PessoaResponseDTO register(PessoaRequestDTO pessoaDTO);
	
	PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO);
	
	String delete(Long id);
}
