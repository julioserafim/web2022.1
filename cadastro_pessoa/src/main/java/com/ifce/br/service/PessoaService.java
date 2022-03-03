package com.ifce.br.service;

import java.util.List;
import java.util.Optional;

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
	
	public Iterable<Pessoa> listarPessoas(){
		return pessoaRepo.findAll();
	}
	
	public void excluir (Long id) {
		pessoaRepo.deleteById(id);
	}
	
	public Optional<Pessoa> retornarPeloCodigo(Long codigo) {
		return pessoaRepo.findById(codigo);
	}

}
