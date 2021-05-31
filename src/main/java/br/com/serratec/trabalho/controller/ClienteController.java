package br.com.serratec.trabalho.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Cliente;
import br.com.serratec.trabalho.model.Produto;
import br.com.serratec.trabalho.repository.ClienteRepository;

@RequestMapping("/api/Trabalho-final")
@RestController
public class ClienteController {
	@Autowired 
	private ClienteRepository _repositorioCliente;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> obter(@PathVariable(value = "id") Long id){
		
		 try { 
  		   var encontrado = _repositorioCliente.findById(id);
  		   
  		    return new ResponseEntity<Optional<Cliente>>(encontrado, HttpStatus.OK);
  		    
  	 } catch (ClienteNaoEncontradoException e) {
  		 
  		 System.out.println(e.getMessage());
  		 
  		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  	 }
}
	}

