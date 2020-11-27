package br.com.controledeestoque.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeestoque.model.dto.PedidoF_DTO;

@Repository
public interface Pedido_FornecedorRepositorio extends JpaRepository<PedidoF_DTO, Long> {

	
	
}
