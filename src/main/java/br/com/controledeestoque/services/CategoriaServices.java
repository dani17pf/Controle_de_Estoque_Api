package br.com.controledeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.CategoriaDTO;
import br.com.controledeestoque.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServices {
	
	@Autowired
	CategoriaRepositorio repositorio;
		
	public List<CategoriaDTO> getCategoria() {
		
		return repositorio.findAll();
        
    }
	
	public CategoriaDTO getCategoria(Long id) {
		Optional<CategoriaDTO> result = repositorio.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
        return null;
    }
	
	public CategoriaDTO postCategoria( CategoriaDTO categoriaDTO) {
		
		return repositorio.save(categoriaDTO);

    }

	public ResponseEntity<?> deleteCategoria(Long id) {

		Optional<CategoriaDTO> result = repositorio.findById(id);

		if (result.isPresent()) {
			repositorio.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	public CategoriaDTO atualizaCategoria(Long id, CategoriaDTO categoriaDTO) {
		Optional<CategoriaDTO> result = repositorio.findById(id);
		
		if(result.isPresent()) {
			categoriaDTO.setId(id);
			return repositorio.save(categoriaDTO);
		}
        return null;
		
    }
	
	


}
