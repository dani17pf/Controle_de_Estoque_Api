package br.com.controledeestoque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeestoque.model.dto.VendedorDTO;


@Repository
public interface VendedorRepositorio extends JpaRepository<VendedorDTO, Long> {

	
}
