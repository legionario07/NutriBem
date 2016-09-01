package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = "item_pedido")
public class ItemPedido extends EntidadeDominio{

	private static final long serialVersionUID = -3011245822946210763L;

	private Integer quantidade;
	private BigDecimal valor;
	@ElementCollection
	private List<Produto> produtos;
	
	public ItemPedido(Long id, Integer quantidade, BigDecimal valor, List<Produto> produtos){
		this(quantidade, valor, produtos);
		this.setId(id);
	}
	
	
	public ItemPedido(Integer quantidade, BigDecimal valor, List<Produto> produtos) {

		this();
		this.quantidade = quantidade;
		this.valor = valor;
		this.produtos = produtos;
	}


	public ItemPedido(){
		this.produtos = new ArrayList<Produto>();
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
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
		retorno.append("\nProdutos - ");
		for(Produto p : produtos){
			retorno.append(p);
		}
		
		return retorno.toString();
	}
	
	
}
