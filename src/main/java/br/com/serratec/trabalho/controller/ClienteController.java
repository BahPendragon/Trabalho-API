package br.com.serratec.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Cliente;
import br.com.serratec.trabalho.repository.ClienteRepository;

@RestController
@RequestMapping("api/clitentes")
public class ClienteController {

    @Autowired
    private ClienteRepository _repositorioCliente;

    @GetMapping
    public ResponseEntity<Cliente> obterTodos(@RequestBody Cliente cliente){

        var obter = this._repositorioCliente.findAll(cliente);

        return new ResponseEntity<>(obter, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> deletar(@PathVariable(value = "id") Long id) {
		try {
			
		var deletado = this._repositorioCliente.deleteById(id);
		
		return new ResponseEntity<Optional<Cliente>>(deletado, HttpStatus.OK);
		
		} catch (ClienteNaoEncontratoException e) {
			
			System.out.println(e.getMessage()); 
			
			return new ResponseEntity<Optional<Cliente>>(HttpStatus.NOT_FOUND);
		}
	}
    
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

