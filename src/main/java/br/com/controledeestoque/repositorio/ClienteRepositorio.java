package br.com.controledeestoque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeestoque.model.dto.ClienteDTO;


@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteDTO, Long> {

	
	
}
