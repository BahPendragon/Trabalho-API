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
import br.com.serratec.trabalho.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository _repositorioCliente;
	
	@GetMapping("/{nome}")
	public ResponseEntity<Optional<Cliente>> obterPorNome(@PathVariable(value = "nome") String nome ) {
		var cliente =  _repositorioCliente.findAll()
					.stream().filter(c -> c.getNome() == nome).findFirst();
		if(cliente.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
}
