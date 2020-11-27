package br.com.controledeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.LojaDTO;
import br.com.controledeestoque.repositorio.LojaRepositorio;

@Service
public class LojaServices {

	@Autowired
	LojaRepositorio lojarepositorio;
		
	public List<LojaDTO> getLoja() {
		
		return lojarepositorio.findAll();      
    }
	
	public LojaDTO getLoja(Long id) {
		Optional<LojaDTO> result = lojarepositorio.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
        return null;
    }
	
	public LojaDTO postLoja( LojaDTO loja) {
		
		return lojarepositorio.save(loja);

    }
	
	public ResponseEntity<?> deleteLoja(Long id) {

		Optional<LojaDTO> result = lojarepositorio.findById(id);

		if (result.isPresent()) {
			lojarepositorio.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
	public LojaDTO atualizaLoja(Long id, LojaDTO loja) {
		Optional<LojaDTO> result = lojarepositorio.findById(id);
		
		if(result.isPresent()) {
			loja.setId(id);
			return lojarepositorio.save(loja);
		}
        return null;
		
    }
	
	
	
	
	
	
}
