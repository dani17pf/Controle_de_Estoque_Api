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

import br.com.controledeestoque.model.dto.ClienteDTO;
import br.com.controledeestoque.services.ClienteServices;

@RestController
@RequestMapping(value = { "/cliente" })
public class ClienteController {
	
	@Autowired
	ClienteServices clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getCliente() {

		return ResponseEntity.ok(clienteService.getCliente());

	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ClienteDTO> getOneCliente(@PathVariable("id") Long id) {

		// retorna lista categoria
		return ResponseEntity.ok(clienteService.getCliente(id));
	}
	
	@PostMapping
	public ResponseEntity <ClienteDTO> postCliente(@RequestBody ClienteDTO cliente) {
		
		return ResponseEntity.ok(clienteService.postCliente(cliente));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <ClienteDTO> atualizaCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente) {

		return ResponseEntity.ok(clienteService.atualizaCliente(id, cliente));
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		return ResponseEntity.ok(clienteService.deleteCliente(id));
	}

}
