package br.com.controledeestoque.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.controledeestoque.model.dto.ProdutoDTO;
import br.com.controledeestoque.services.ProdutoServices;

@RestController
@RequestMapping(value = { "/produto" })
public class ProdutoController {
	
	@Autowired
	ProdutoServices produtoService;
	
	@GetMapping//(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProdutoDTO>> getProduto() {

		return ResponseEntity.ok(produtoService.getProduto());

	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ProdutoDTO> getOneProduto(@PathVariable("id") Long id) {

		return ResponseEntity.ok(produtoService.getProduto(id));
	}
	
	@PostMapping
	//@RequestMapping(value = "/{id}", method = RequestMethod.POST) 
	public ResponseEntity <ProdutoDTO> postProduto(@RequestBody ProdutoDTO produto) {
		
		return ResponseEntity.ok(produtoService.postProduto(produto));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <ProdutoDTO> atualizaProduto(@PathVariable Long id, @RequestBody ProdutoDTO produto) {

		return ResponseEntity.ok(produtoService.atualizaProduto(id, produto));
		//return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		return ResponseEntity.ok(produtoService.deleteProduto(id));
	}
	
	
	
	
	
	
	
}
