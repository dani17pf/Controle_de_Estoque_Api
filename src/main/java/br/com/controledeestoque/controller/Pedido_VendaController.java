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

import br.com.controledeestoque.model.dto.PedidoVendaDTO;
import br.com.controledeestoque.services.Pedido_VendaServices;

@RestController
@RequestMapping(value = { "/pedidovenda" })
public class Pedido_VendaController {
	
	@Autowired
	Pedido_VendaServices pedido_VendaServices;
	
	@GetMapping
	public ResponseEntity<List<PedidoVendaDTO>> getPeditoVenda() {

		return ResponseEntity.ok(pedido_VendaServices.getPeditoVenda());

	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<PedidoVendaDTO> getOnePeditoVenda(@PathVariable("id") Long id) {

		return ResponseEntity.ok(pedido_VendaServices.getPeditoVenda(id));
	}
	
	
	@PostMapping
	@Transactional
	//@RequestMapping(value = "/{id}", method = RequestMethod.POST) 
	public ResponseEntity<PedidoVendaDTO> postPeditoVenda(@RequestBody PedidoVendaDTO peditoVenda) {
		
		return ResponseEntity.ok(pedido_VendaServices.postPeditoVenda(peditoVenda));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity <PedidoVendaDTO> atualizaPeditoPeditoVenda(@PathVariable Long id, @RequestBody PedidoVendaDTO peditoVenda) {

		return ResponseEntity.ok(pedido_VendaServices.atualizaPeditoPeditoVenda(id, peditoVenda));
		
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {	
		return ResponseEntity.ok(pedido_VendaServices.deletePedidoVenda(id));
	}
	
	
	
	

}
