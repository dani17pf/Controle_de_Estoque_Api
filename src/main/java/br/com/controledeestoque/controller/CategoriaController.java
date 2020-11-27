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

import br.com.controledeestoque.model.dto.CategoriaDTO;
import br.com.controledeestoque.services.CategoriaServices;

@RestController
@RequestMapping(value = { "/categoria" })
public class CategoriaController {

	@Autowired
	CategoriaServices service;


	@GetMapping//(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaDTO>> getCategoria() {

		return ResponseEntity.ok(service.getCategoria());

	}

	@GetMapping(value = "{id}")
	public ResponseEntity<CategoriaDTO> getOneCategoria(@PathVariable("id") Long id) {

		// retorna lista categoria
		return ResponseEntity.ok(service.getCategoria(id));
	}

	@PostMapping
	//@RequestMapping(value = "/", method = RequestMethod.POST) 
	public ResponseEntity <CategoriaDTO> postCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		
		return ResponseEntity.ok(service.postCategoria(categoriaDTO));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <CategoriaDTO> atualizaCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {

		return ResponseEntity.ok(service.atualizaCategoria(id, categoriaDTO));
	}
	

	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		return ResponseEntity.ok(service.deleteCategoria(id));
	}

}
