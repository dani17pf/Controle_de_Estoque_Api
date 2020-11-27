package br.com.controledeestoque.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.controledeestoque.model.dto.VendedorDTO;
import br.com.controledeestoque.services.VendedorServices;

@RestController
@RequestMapping(value = { "/vendedor" })
public class VendedorController {
	
	@Autowired
	VendedorServices vendedorService;
	
	@GetMapping
	public ResponseEntity<List<VendedorDTO>> getVendedor() {

		return ResponseEntity.ok(vendedorService.getVendedor());

	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> getOneVendedor(@PathVariable("id") Long id) {

		return ResponseEntity.ok(vendedorService.getVendedor(id));
	}
	
	@PostMapping
	public ResponseEntity <VendedorDTO> postVendedor(@RequestBody VendedorDTO vendedor) {
		
		return ResponseEntity.ok(vendedorService.postVendedor(vendedor));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <VendedorDTO> atualizaVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedor) {

		return ResponseEntity.ok(vendedorService.atualizaVendedor(id, vendedor));
	}
	
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		try {
			List<VendedorDTO> l = vendedorService.deleteVendedor(id);
			return l instanceof List<?> ? 
				ResponseEntity.ok().body(vendedorService):
				ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	

}
