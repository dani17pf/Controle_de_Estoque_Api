package br.com.controledeestoque.model.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data // get, set
@Entity
public class VendedorDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal salario;
	private BigDecimal comissao;
	
	@ManyToOne
	private LojaDTO loja;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public LojaDTO getLoja() {
		return loja;
	}

	public void setLoja(LojaDTO loja) {
		this.loja = loja;
	}
	
	public BigDecimal adicionarCommissao(BigDecimal comissao) {
		return this.comissao.add(comissao);
	}
	
	
}
