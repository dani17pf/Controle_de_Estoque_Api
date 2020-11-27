package br.com.controledeestoque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeestoque.model.dto.FornecedorDTO;


@Repository
public interface FornecedorRepositorio extends JpaRepository<FornecedorDTO, Long> {

	
	
}
