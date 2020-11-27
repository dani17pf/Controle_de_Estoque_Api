package br.com.controledeestoque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeestoque.model.dto.LojaDTO;


@Repository
public interface LojaRepositorio extends JpaRepository<LojaDTO, Long> {

	
	
}
