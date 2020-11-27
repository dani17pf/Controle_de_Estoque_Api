package br.com.controledeestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.dto.CategoriaDTO;
import br.com.controledeestoque.model.dto.ProdutoDTO;
import br.com.controledeestoque.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServices {
	
	@Autowired
	ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	CategoriaServices serviceCategoria;
	
	public List<ProdutoDTO> getProduto() {
		
		return produtoRepositorio.findAll();        
    }
	
	public ProdutoDTO getProduto(Long id) {
		Optional<ProdutoDTO> result = produtoRepositorio.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
        return null;
    }
	
	public ProdutoDTO postProduto( ProdutoDTO produto) {
		
		return produtoRepositorio.save(produto);
    }
	
	public ProdutoDTO atualizaProduto(Long id, ProdutoDTO produto) {
		
		Optional<ProdutoDTO> result = produtoRepositorio.findById(id);
		
		if(result.isPresent()) {
			ProdutoDTO produtoDTO = result.get();
			CategoriaDTO categoriaDTO =  null;
			
			if(produto.getCategoria().getId() == null){
				categoriaDTO = serviceCategoria.getCategoria(produtoDTO.getCategoria().getId());	
			} else {
				categoriaDTO = serviceCategoria.getCategoria(produto.getCategoria().getId());
			}
			
			produto.setId(id);
			produto.setCategoria(categoriaDTO);
			return produtoRepositorio.save(produto);
		}
        return null;
        
	}
	
	public ResponseEntity<?> deleteProduto(Long id) {

		Optional<ProdutoDTO> result = produtoRepositorio.findById(id);

		if (result.isPresent()) {
			produtoRepositorio.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	

}
