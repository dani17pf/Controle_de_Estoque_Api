package br.com.controledeestoque.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeestoque.model.dto.PedidoVendaDTO;

@Repository
public interface Pedido_VendaRepositorio extends JpaRepository<PedidoVendaDTO, Long> {

	
	
}
