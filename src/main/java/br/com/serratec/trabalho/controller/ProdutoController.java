package br.com.serratec.trabalho.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.repository.ProdutoRepository;
import br.com.serratec.trabalho.model.Produto;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository _repositorioProduto;
	
	@GetMapping("/{nome}")
	public ResponseEntity<Optional<Produto>> obterPorNome(@PathVariable(value = "nome") String nome ) {
		var produto =  _repositorioProduto.findAll()
					.stream().filter(p -> p.getNome() == nome).findFirst();
		if(produto.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
}
