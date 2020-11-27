package br.com.controledeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.FornecedorDTO;
import br.com.controledeestoque.repositorio.FornecedorRepositorio;

@Service
public class FornecedorServices {
	
	@Autowired
	FornecedorRepositorio fornecedorRepositorio;
	
	public List<FornecedorDTO> getFornecedor() {
		
		return fornecedorRepositorio.findAll();
        
    }
	
	public FornecedorDTO getFornecedor(Long id) {
		Optional<FornecedorDTO> result = fornecedorRepositorio.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
        return null;
    }
	
	public FornecedorDTO postFornecedor( FornecedorDTO fornecedor) {
		
		return fornecedorRepositorio.save(fornecedor);
    }
	
	public FornecedorDTO atualizaFornecedor(Long id, FornecedorDTO fornecedor) {
		Optional<FornecedorDTO> result = fornecedorRepositorio.findById(id);
		
		if(result.isPresent()) {
			fornecedor.setId(id);
			return fornecedorRepositorio.save(fornecedor);
		}
        return null;
		
    }
	
	public ResponseEntity<?> deleteFornecedor(Long id) {

		Optional<FornecedorDTO> result = fornecedorRepositorio.findById(id);

		if (result.isPresent()) {
			fornecedorRepositorio.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
