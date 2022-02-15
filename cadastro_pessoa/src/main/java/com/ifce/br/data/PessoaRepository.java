package com.ifce.br.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.ifce.br.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
