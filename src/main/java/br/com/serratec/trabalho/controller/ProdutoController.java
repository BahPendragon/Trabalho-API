package br.com.serratec.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Produto;
import br.com.serratec.trabalho.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
	private ProdutoRepository _repositorioProduto ;

    @PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {

        var adicionado = this._repositorioProduto.save(produto);

        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
		
	}

}
