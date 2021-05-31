package br.com.serratec.trabalho.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.serratec.trabalho.model.Produto;
import br.com.serratec.trabalho.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
     @Autowired
     private ProdutoRepository _repositorioProduto;
     
     @GetMapping("/{id}")
     public ResponseEntity<Optional<Produto>> obter(@PathVariable(value = "id") Integer id){
 		
    	 try { 
    		   var encontrado = _repositorioProduto.findById(id);
    		   
    		    return new ResponseEntity<Optional<Produto>>(encontrado, HttpStatus.OK);
    		    
    	 } catch (ProdutoNaoEncontradoException e) {
    		 
    		 System.out.println(e.getMessage());
    		 
    		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	 }
 
 	}
     
}

