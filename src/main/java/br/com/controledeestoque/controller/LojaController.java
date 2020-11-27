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

import br.com.controledeestoque.model.dto.LojaDTO;
import br.com.controledeestoque.services.LojaServices;

@RestController
@RequestMapping(value = { "/loja" })
public class LojaController {

	@Autowired
	LojaServices lojaService;
	
	
	@GetMapping
	public ResponseEntity<List<LojaDTO>> getLoja() {

		return ResponseEntity.ok(lojaService.getLoja());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<LojaDTO> getOneLoja(@PathVariable("id") Long id) {

		return ResponseEntity.ok(lojaService.getLoja(id));
	}
	
	@PostMapping
	public ResponseEntity <LojaDTO> postLoja(@RequestBody LojaDTO loja) {
		
		return ResponseEntity.ok(lojaService.postLoja(loja));

	}
		
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <LojaDTO> atualizaLoja(@PathVariable Long id, @RequestBody LojaDTO loja) {

		return ResponseEntity.ok(lojaService.atualizaLoja(id, loja));
	}
	
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		return ResponseEntity.ok(lojaService.deleteLoja(id));
	}
	
	
}
