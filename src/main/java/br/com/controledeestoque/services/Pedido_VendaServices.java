package br.com.controledeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.ClienteDTO;
import br.com.controledeestoque.model.dto.PedidoVendaDTO;
import br.com.controledeestoque.model.dto.VendedorDTO;
import br.com.controledeestoque.repositorio.Pedido_VendaRepositorio;

@Service
public class Pedido_VendaServices {

	@Autowired
	Pedido_VendaRepositorio pedido_VendaRepositorio;
	
	@Autowired
	VendedorServices vendedorServices;
	
	@Autowired
	ClienteServices clienteServices;
	
	public List<PedidoVendaDTO> getPeditoVenda() {
		
		return pedido_VendaRepositorio.findAll();
        
    }
	
	public PedidoVendaDTO getPeditoVenda(Long id) {
		Optional<PedidoVendaDTO> result = pedido_VendaRepositorio.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
        return null;
    }
	
	public PedidoVendaDTO postPeditoVenda(PedidoVendaDTO peditoVenda) {
		
		return pedido_VendaRepositorio.save(peditoVenda);
    }
	
	public PedidoVendaDTO atualizaPeditoPeditoVenda(Long id, PedidoVendaDTO peditoVenda) {
		
		Optional<PedidoVendaDTO> result = pedido_VendaRepositorio.findById(id);
		
		if(result.isPresent()) {
			PedidoVendaDTO pedidoVendaDTO = result.get();
			VendedorDTO vendedor = null;
			ClienteDTO cliente =  null;

			
			if(peditoVenda.getVendedor().getId() == null && peditoVenda.getCliente().getId() == null ){
				vendedor = vendedorServices.getVendedor(pedidoVendaDTO.getVendedor().getId());
				cliente = clienteServices.getCliente(pedidoVendaDTO.getCliente().getId());	
			} else {
				vendedor = vendedorServices.getVendedor(pedidoVendaDTO.getVendedor().getId());
				cliente = clienteServices.getCliente(pedidoVendaDTO.getCliente().getId());
			}
			
			peditoVenda.setId(id);
			peditoVenda.setVendedor(vendedor);
			peditoVenda.setCliente(cliente);
			return pedido_VendaRepositorio.save(peditoVenda);
		}
        return null;
        
	}
	
	
	public ResponseEntity<?> deletePedidoVenda(Long id) {

		Optional<PedidoVendaDTO> result = pedido_VendaRepositorio.findById(id);

		if (result.isPresent()) {
			pedido_VendaRepositorio.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
	
	
}
