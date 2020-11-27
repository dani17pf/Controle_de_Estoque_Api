package br.com.controledeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.FornecedorDTO;
import br.com.controledeestoque.model.dto.LojaDTO;
import br.com.controledeestoque.model.dto.PedidoF_DTO;
import br.com.controledeestoque.model.dto.PedidoVendaDTO;
import br.com.controledeestoque.repositorio.Pedido_FornecedorRepositorio;

@Service
public class Pedido_FornecedorServices {
	
	@Autowired
	Pedido_FornecedorRepositorio pedido_FornecedorRepositorio;
	
	@Autowired
	FornecedorServices fornecedorServices;
	
	@Autowired
	LojaServices lojaServices;

	public List<PedidoF_DTO> getPeditoFornecedor() {
		
		return pedido_FornecedorRepositorio.findAll();
        
    }
	
	public PedidoF_DTO getPeditoFornecedor(Long id) {
		Optional<PedidoF_DTO> result = pedido_FornecedorRepositorio.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
        return null;
    }
	
	public PedidoF_DTO postPeditoFornecedor(PedidoF_DTO pedidoFornecedor) {
		
		return pedido_FornecedorRepositorio.save(pedidoFornecedor);
    }
	
	
	public PedidoF_DTO atualizaPeditoFornecedor(Long id, PedidoF_DTO pedidoFornecedor) {
		
		Optional<PedidoF_DTO> result = pedido_FornecedorRepositorio.findById(id);
		
		if(result.isPresent()) {
			PedidoF_DTO pedidoF_DTO = result.get();
			FornecedorDTO fornecedor =  null;
			LojaDTO loja = null;
			
			if(pedidoFornecedor.getFornecedor().getId() == null && pedidoFornecedor.getLoja().getId() == null ){
				fornecedor = fornecedorServices.getFornecedor(pedidoF_DTO.getFornecedor().getId());	
				loja = lojaServices.getLoja(pedidoF_DTO.getLoja().getId());	
			} else {
				fornecedor = fornecedorServices.getFornecedor(pedidoF_DTO.getFornecedor().getId());	
				loja = lojaServices.getLoja(pedidoF_DTO.getLoja().getId());	
			}
			
			pedidoFornecedor.setId(id);
			pedidoFornecedor.setFornecedor(fornecedor);
			pedidoFornecedor.setLoja(loja);
			return pedido_FornecedorRepositorio.save(pedidoFornecedor);
		}
        return null;
        
	}
	
	
	public ResponseEntity<?> deletePeditoFornecedor(Long id) {

		Optional<PedidoF_DTO> result = pedido_FornecedorRepositorio.findById(id);

		if (result.isPresent()) {
			pedido_FornecedorRepositorio.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
}
