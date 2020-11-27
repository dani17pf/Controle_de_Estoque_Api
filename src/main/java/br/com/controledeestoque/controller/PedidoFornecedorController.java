/*


// TESTE --> REALIZANDO CRUD CONTROLLE
 * 
package br.com.controledeestoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controledeestoque.model.PeditoFornecedorDTO;
import br.com.controledeestoque.model.ProdutoDTO;
import br.com.controledeestoque.services.PedidoFornecedorServices;

@RestController
@RequestMapping(value = { "/pedidofornecedor" })
public class PedidoFornecedorController {
	
	@Autowired
	PedidoFornecedorServices pedidoFornecedorService;
	
	
	@GetMapping
	public ResponseEntity<List<PeditoFornecedorDTO>> getPeditoFornecedor() {

		return ResponseEntity.ok(pedidoFornecedorService.getPeditoFornecedor());

	}
	
	@GetMapping(value = "{id}")						           //	(@PathVariable("id") Long id)				
	public ResponseEntity<PeditoFornecedorDTO> getOnePeditoFornecedor(@PathVariable Long id) {

		return ResponseEntity.ok(pedidoFornecedorService.getPeditoFornecedor(id));
	}
	
	@PostMapping
	public ResponseEntity <List<PeditoFornecedorDTO>> postPeditoFornecedo(@RequestBody PeditoFornecedorDTO pedidoFornecedor) {
		
		return ResponseEntity.ok(pedidoFornecedorService.postPeditoFornecedor(pedidoFornecedor));

	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity <PeditoFornecedorDTO> putPeditoFornecedo(@PathVariable Long id, @RequestBody PeditoFornecedorDTO pedidoFornecedor) {
		return ResponseEntity.ok(pedidoFornecedorService.putPeditoFornecedor(id,pedidoFornecedor));

	}
	
	

}

*/
