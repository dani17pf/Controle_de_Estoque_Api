package br.com.controledeestoque.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.LojaDTO;
import br.com.controledeestoque.model.dto.VendedorDTO;
import br.com.controledeestoque.repositorio.VendedorRepositorio;

@Service
public class VendedorServices {
	
	@Autowired
	VendedorRepositorio vendedorRepositorio;
	
	@Autowired
	LojaServices lojaService;
	
	public List<VendedorDTO> getVendedor() {
		
		return vendedorRepositorio.findAll();        
    }
	
	public VendedorDTO getVendedor(Long id) {
		Optional<VendedorDTO> result = vendedorRepositorio.findById(id);
		
		if (result.isPresent()) {
			
			return result.get();
		}
		return null;
    }
	
	public VendedorDTO postVendedor( VendedorDTO vendedor) {
		
		return vendedorRepositorio.save(vendedor);
    }
	
	public VendedorDTO atualizaVendedor(Long id, VendedorDTO vendedor) {
		
		Optional<VendedorDTO> result = vendedorRepositorio.findById(id);
		
		if(result.isPresent()) {
			VendedorDTO vendedorDTO = result.get();
			LojaDTO loja =  null;
			
			if(vendedor.getLoja().getId() == null){
				loja = lojaService.getLoja(vendedorDTO.getLoja().getId());	
			} else {
				loja = lojaService.getLoja(vendedor.getLoja().getId());
			}
			BigDecimal com = vendedor.adicionarCommissao(vendedorDTO.getComissao());
			vendedor.setComissao(com);
			
			vendedor.setId(id);
			vendedor.setLoja(loja);
			return vendedorRepositorio.save(vendedor);
		}
        return null;
        
	}
	
	public List<VendedorDTO> deleteVendedor(Long id) throws Exception{

		Optional<VendedorDTO> result = vendedorRepositorio.findById(id);
		
		if (result.isPresent()) {
			vendedorRepositorio.deleteById(id);
			return vendedorRepositorio.findAll();
		}
		return null;

	}
}
