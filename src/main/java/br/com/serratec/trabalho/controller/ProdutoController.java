package br.com.serratec.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Produto;
import br.com.serratec.trabalho.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository _repositorioProduto;

    /*
    @GetMapping
    public List<Produto> obterTodos(){
        return this._repositorioProduto.findAll();
    }
    */

    @GetMapping
    public ResponseEntity<Produto> obterTodos(@RequestBody Produto produto){

        var obter = this._repositorioProduto.findAll(produto);

        return new ResponseEntity<>(obter, HttpStatus.OK);
    }



}
