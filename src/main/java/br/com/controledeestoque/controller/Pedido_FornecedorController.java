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

import br.com.controledeestoque.model.dto.PedidoF_DTO;
import br.com.controledeestoque.model.dto.PedidoVendaDTO;
import br.com.controledeestoque.services.Pedido_FornecedorServices;



@RestController
@RequestMapping(value = { "/pedidofornecedor" })
public class Pedido_FornecedorController {
	
	@Autowired
	Pedido_FornecedorServices pedido_FornecedorServices;
	
	@GetMapping
	public ResponseEntity<List<PedidoF_DTO>> getPeditoFornecedor() {

		return ResponseEntity.ok(pedido_FornecedorServices.getPeditoFornecedor());

	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<PedidoF_DTO> getOnePeditoFornecedor(@PathVariable("id") Long id) {

		return ResponseEntity.ok(pedido_FornecedorServices.getPeditoFornecedor(id));
	}
	
	@PostMapping
	//@RequestMapping(value = "/{id}", method = RequestMethod.POST) 
	public ResponseEntity<PedidoF_DTO> postPeditoFornecedor(@RequestBody PedidoF_DTO pedidoFornecedor) {
		
		return ResponseEntity.ok(pedido_FornecedorServices.postPeditoFornecedor(pedidoFornecedor));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <PedidoF_DTO> atualizaPeditoFornecedor(@PathVariable Long id, @RequestBody PedidoF_DTO pedidoFornecedor) {

		return ResponseEntity.ok(pedido_FornecedorServices.atualizaPeditoFornecedor(id, pedidoFornecedor));

	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		return ResponseEntity.ok(pedido_FornecedorServices.deletePeditoFornecedor(id));
	}

}
