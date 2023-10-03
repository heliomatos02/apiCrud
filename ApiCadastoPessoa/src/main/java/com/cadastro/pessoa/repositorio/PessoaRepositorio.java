package com.cadastro.pessoa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.pessoa.entidade.Pessoa;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{

}
