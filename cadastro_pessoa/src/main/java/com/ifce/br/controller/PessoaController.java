package com.ifce.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifce.br.model.Pessoa;
import com.ifce.br.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/pessoa/formulario")
	public String form() {
		return "Formulario";
	}
	
	@PostMapping("/pessoa/salvar")
	public String cadastrarPessoa(Pessoa pessoa) {
		
		pessoaService.cadastrarPessoa(pessoa);
		
		return "Sucesso";
	}
	

}
