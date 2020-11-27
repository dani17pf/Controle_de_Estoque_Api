package br.com.controledeestoque.model.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data // get, set
@Entity
public class PedidoVendaDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data_pedido;
	private BigDecimal valor_total;

	@ManyToOne
	private ClienteDTO cliente;
	@ManyToOne
	private VendedorDTO vendedor;
	
	@ManyToMany
	@JoinTable(name="pedido_venda_produto", joinColumns = {@JoinColumn(name="pedido_id")}, inverseJoinColumns = {@JoinColumn(name="produto_id")})
	private List<ProdutoDTO> produto = new ArrayList<>(); 
	
	
	public PedidoVendaDTO() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getData_pedido() {
		return data_pedido;
	}


	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}


	public BigDecimal getValor_total() {
		return valor_total;
	}


	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}


	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}


	public VendedorDTO getVendedor() {
		return vendedor;
	}


	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}


	public List<ProdutoDTO> getProduto() {
		return produto;
	}


	public void setProduto(List<ProdutoDTO> produto) {
		this.produto = produto;
	}


}
