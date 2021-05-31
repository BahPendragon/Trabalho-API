package br.com.serratec.trabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public List<Produto> obterTodos(Produto produto){

        return this._repositorioProduto.findAll();

    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obter(@PathVariable(value = "id") Long id){
		
   	 try { 
   		   var encontrado = _repositorioProduto.findById(id);
   		   
   		    return new ResponseEntity<Optional<Produto>> (encontrado, HttpStatus.OK);
   		    
   	 } catch (Exception e) {
   		 
   		 System.out.println(e.getMessage());
   		 
   		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   	 }

   }
	
    @GetMapping("/{nome}")
    public ResponseEntity<Optional<Produto>> obter(@PathVariable(value = "nome") String nome){
		
	 try { 
  		   var encontrado = _repositorioProduto.findByNome(nome);
  		   
  		    return new ResponseEntity<Optional<Produto>>(encontrado, HttpStatus.OK);
  		    
  	 } catch (Exception e) {
  		 
  		 System.out.println(e.getMessage());
  		 
  		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  	 }
   }
    
   @PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {

        var adicionado = this._repositorioProduto.save(produto);

        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
		
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<Optional<Produto>> deletar(@PathVariable(value = "id") Long id) {
		try {
			
		this._repositorioProduto.deleteById(id);
		
		return new ResponseEntity<Optional<Produto>>(HttpStatus.OK);
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage()); 
			
			return new ResponseEntity<Optional<Produto>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
		
		try {
			produto.setId(id);
			
			var clienteAtualizado = this._repositorioProduto.save(produto);
			
			return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
     
}
