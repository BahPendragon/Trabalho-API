package br.com.serratec.trabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Cliente;
import br.com.serratec.trabalho.repository.ClienteRepository;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository _repositorioCliente;

    @GetMapping
    public ResponseEntity<Cliente> obterTodos(@RequestBody Cliente cliente){

        var obter = this._repositorioCliente.findAll(cliente);

        return new ResponseEntity<>(obter, HttpStatus.OK);
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
	
	
    @PostMapping
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {

        var adicionado = this._repositorioCliente.save(cliente);

        return new ResponseEntity<Cliente>(adicionado, HttpStatus.CREATED);		

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

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
		
		try {
			cliente.setId(id);
			
			var clienteAtualizado = this._repositorioCliente.save(cliente);
			
			return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
			
		} catch (ClienteNaoEncontratoException e) {
			System.out.println(e.getMessage()); 
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	}
