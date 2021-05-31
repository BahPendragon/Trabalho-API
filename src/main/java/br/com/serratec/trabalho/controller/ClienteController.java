package br.com.serratec.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Produto;
import br.com.serratec.trabalho.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ClienteController {
    @Autowired
	private ProdutoRepository _repositorioProduto ;
	
	
	@PostMapping
	public Produto adicionar(@RequestBody Produto produto) {
		return this._repositorioProduto.save(produto);
	}
	
	
	
}
