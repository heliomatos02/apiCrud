package com.cadastro.pessoa.controller;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cadastro.pessoa.dto.request.PessoaRequestDTO;
import com.cadastro.pessoa.dto.response.PessoaResponseDTO;
import com.cadastro.pessoa.entidade.Pessoa;
import com.cadastro.pessoa.service.PessoaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/pessoa")
@RequiredArgsConstructor
public class PessoaController {
	private final PessoaService pessoaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaResponseDTO> findById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(pessoaService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaResponseDTO>> findAll(){
		return ResponseEntity.ok().body(pessoaService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<PessoaResponseDTO> regitrar (@RequestBody PessoaRequestDTO pessoaDto, UriComponentsBuilder uriBuilder){
		PessoaResponseDTO pessoaResponseDTO = pessoaService.register(pessoaDto);
		URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoaResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoaResponseDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaResponseDTO> update(@RequestBody PessoaRequestDTO pessoaRequestDTO, @PathVariable(name ="id") Long id){
		return ResponseEntity.ok().body(pessoaService.update(id,pessoaRequestDTO));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok().body(pessoaService.delete(id));
	}
	
}
