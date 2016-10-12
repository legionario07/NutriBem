package br.com.nutribem.dominio;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "item_pedido")
public class ItemPedido extends EntidadeDominio{

	private static final long serialVersionUID = -3011245822946210763L;

	private Integer quantidade;
	private BigDecimal desconto;
	private BigDecimal valor;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Produto produto;
	
	public ItemPedido(Long id, Integer quantidade, BigDecimal valor, Produto produto){
		this(quantidade, valor, produto);
		this.setId(id);
	}
	
	
	public ItemPedido(Integer quantidade, BigDecimal valor, Produto produto) {

		this();
		this.quantidade = quantidade;
		this.valor = valor;
		this.produto = produto;
	}


	public ItemPedido(){
		this.produto = new Produto();
	}
	
	public BigDecimal getDesconto() {
		return desconto;
	}


	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tQuantidade - ");
		retorno.append(getQuantidade());
		retorno.append("\tValor - ");
		retorno.append(getValor());
		retorno.append("\nProduto - ");
		retorno.append(getProduto());
		
		return retorno.toString();
	}
	
	
}
