/*
package br.com.controledeestoque.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controledeestoque.model.FornecedorDTO;
import br.com.controledeestoque.model.LojaDTO;
import br.com.controledeestoque.model.PeditoFornecedorDTO;
import br.com.controledeestoque.model.ProdutoDTO;

@Service
public class PedidoFornecedorServices {

	//@Autowired
	//PedidoFornecedorRepositorio pedidoFornecedorRespositorio;

	@Autowired
	LojaServices lojaService;
	
	@Autowired
	FornecedorServices fornecedorServices;
	
	@Autowired
	ProdutoServices produtoServices;
	
	
	public List<PeditoFornecedorDTO> getPeditoFornecedor() {
		return adicionarNoArray();       
    }
	
	public PeditoFornecedorDTO getPeditoFornecedor(Long id) {
		List<PeditoFornecedorDTO> pList = adicionarNoArray();
		for (PeditoFornecedorDTO peditoFornecedorDTO : pList) {
			if(peditoFornecedorDTO.getId() == id) {
				return peditoFornecedorDTO;
			}
		}
		return null;
    }
	
	public List<PeditoFornecedorDTO> postPeditoFornecedor(PeditoFornecedorDTO p ) {
		List<PeditoFornecedorDTO> pList = adicionarNoArray();
		pList.add(p);
		return pList;
    }
	public PeditoFornecedorDTO putPeditoFornecedor(Long id, PeditoFornecedorDTO p) {

		System.out.println("chegou");
		List<PeditoFornecedorDTO> pList = adicionarNoArray();
		
		System.out.println("chegou"+pList.toString());
		
		for (PeditoFornecedorDTO peditoFornecedorDTO : pList) {
			if(peditoFornecedorDTO.getId() == id) {
				pList.remove(peditoFornecedorDTO);
				p.setId(id);
				pList.add(p);
			}
		}
		
		for (PeditoFornecedorDTO peditoFornecedorDTO : pList) {
			if(peditoFornecedorDTO.getId() == id) {
				return peditoFornecedorDTO;
			}
		}
		return null;
    }
	
	
	
	public List<PeditoFornecedorDTO> adicionarNoArray( ) {
		List<PeditoFornecedorDTO> pList = new ArrayList<PeditoFornecedorDTO>();
		PeditoFornecedorDTO p = new PeditoFornecedorDTO();
		PeditoFornecedorDTO p2 = new PeditoFornecedorDTO();
		FornecedorDTO f = fornecedorServices.getFornecedor().get(0);
		List<ProdutoDTO> pro  = produtoServices.getProduto();
		LojaDTO l = lojaService.getLoja().get(0);

		p.setDataPedido(new Date());
		p.setValorTotal(new BigDecimal(30.00));
		//LojaDTO l = lojaService.getLoja().get(0);
		p.setFornecedor(f);
		p.setId(1l);
		p.setLoja(l);
		p.setProduto(pro);
		
		pList.add(p);

		//		Alterar valor
		FornecedorDTO f2 = fornecedorServices.getFornecedor().get(0);
		List<ProdutoDTO> pro2  = produtoServices.getProduto();
		LojaDTO l2 = lojaService.getLoja().get(0);
		p2.setDataPedido(new Date());
		p2.setValorTotal(new BigDecimal(30.00));
		p2.setFornecedor(f);
		p2.setId(2l);
		p2.setLoja(l);
		p2.setProduto(pro2);
		pList.add(p2);

		return pList;  
	}
	

	
}

*/
