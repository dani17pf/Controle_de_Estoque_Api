package br.com.controledeestoque.model.dto;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PedidoF_DTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor_total;
	private String data_pedido;
	
	@ManyToOne
	private LojaDTO loja;
	
	@ManyToOne
	private FornecedorDTO fornecedor;
	
	@ManyToMany
	@JoinTable(name="pedido_fornecedor_produto", joinColumns = {@JoinColumn(name="pedido_id")}, inverseJoinColumns = {@JoinColumn(name="produto_id")})
	private List<ProdutoDTO> produto = new ArrayList<>();
	
	public PedidoF_DTO() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor_total() {
		return valor_total;
	}
	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	public String getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}
	
	public LojaDTO getLoja() {
		return loja;
	}
	public void setLoja(LojaDTO loja) {
		this.loja = loja;
	}
	public FornecedorDTO getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(FornecedorDTO fornecedor) {
		this.fornecedor = fornecedor;
	}
	public List<ProdutoDTO> getProduto() {
		return produto;
	}
	public void setProduto(List<ProdutoDTO> produto) {
		this.produto = produto;
	}

	
	
	

	

	
}
