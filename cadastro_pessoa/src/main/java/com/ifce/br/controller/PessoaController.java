package com.ifce.br.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifce.br.model.Pessoa;
import com.ifce.br.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/pessoa/formulario")
	public String form(Model model) {
		
		model.addAttribute("pessoa", new Pessoa());
		return "Formulario";
	}
	
	@PostMapping("/pessoa/salvar")
	public String cadastrarPessoa(Pessoa pessoa) {
		
		pessoaService.cadastrarPessoa(pessoa);
		
		return "redirect:/pessoa/listar";
	}
	
	@GetMapping("/pessoa/listar")
	public String listarPessoa(Model model) {
		//mandar os objetos da tabela pessoa pro html
		//Model -> se comunicar com o front-end
		model.addAttribute("pessoas", pessoaService.listarPessoas());
		return "PaginaListagem";
		
	}
	
	@GetMapping("/pessoa/excluir/{codigo}")
	public String excluirPessoa(@PathVariable Long codigo) {
		//deletar o cara
		//redirecionar para página de listagem
		
		pessoaService.excluir(codigo);
		return "redirect:/pessoa/listar";
		
	}
	
	@GetMapping("/pessoa/atualizar/{codigo}")
	public String atualizarPessoa(@PathVariable Long codigo, Model model) {
		//saber quem é que vai atualizar 
		//pegar esse objeto
		
		Optional<Pessoa> pessoaOptional = pessoaService.retornarPeloCodigo(codigo);
		//System.out.println(pessoa.get().getNome());
		//System.out.println(pessoa.get().ge);
		Pessoa pessoa = pessoaOptional.get();
		model.addAttribute("pessoa", pessoa);
		return "Formulario";
	}
	

}
