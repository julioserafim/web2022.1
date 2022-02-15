package com.ifce.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifce.br.data.PessoaRepository;
import com.ifce.br.model.Pessoa;

@Service
//Tudo que for regra de negócio é aqui que nós 
//fazemos
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepo;
	
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoaRepo.save(pessoa);
	}

}
