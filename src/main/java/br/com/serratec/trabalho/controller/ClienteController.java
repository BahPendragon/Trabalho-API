package br.com.serratec.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho.model.Cliente;
import br.com.serratec.trabalho.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
	private ClienteRepository _repositorioCliente ;

    @PostMapping
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {

        var adicionado = this._repositorioCliente.save(cliente);

        return new ResponseEntity<Cliente>(adicionado, HttpStatus.CREATED);
		

}
