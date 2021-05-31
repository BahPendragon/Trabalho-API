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


    /*
    @GetMapping
    public List<Cliente> obterTodos(){
        return this._repositorioCliente.findAll;
    }
    */

    @GetMapping
    public ResponseEntity<Cliente> obterTodos(@RequestBody Cliente cliente){

        var obter = this._repositorioCliente.findAll(cliente);

        return new ResponseEntity<>(obter, HttpStatus.OK);
    }
}
