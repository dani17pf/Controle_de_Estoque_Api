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
import org.springframework.web.bind.annotation.RestController;

import br.com.controledeestoque.model.dto.FornecedorDTO;
import br.com.controledeestoque.services.FornecedorServices;

@RestController
@RequestMapping(value = { "/fornecedor" })
public class FornecedorController {
	
	@Autowired
	FornecedorServices fornecedorService;
	
	
	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> getFornecedor() {

		return ResponseEntity.ok(fornecedorService.getFornecedor());

	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<FornecedorDTO> getOneFornecedor(@PathVariable("id") Long id) {

		return ResponseEntity.ok(fornecedorService.getFornecedor(id));
	}
	
	@PostMapping
	public ResponseEntity <FornecedorDTO> postFornecedor(@RequestBody FornecedorDTO fornecedor) {
		
		return ResponseEntity.ok(fornecedorService.postFornecedor(fornecedor));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <FornecedorDTO> atualizaFornecedor(@PathVariable Long id, @RequestBody FornecedorDTO fornecedor) {

		return ResponseEntity.ok(fornecedorService.atualizaFornecedor(id, fornecedor));
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		return ResponseEntity.ok(fornecedorService.deleteFornecedor(id));
	}
	

}
