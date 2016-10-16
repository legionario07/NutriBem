package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido extends EntidadeDominio{

	private static final long serialVersionUID = -5070650738264686464L;
	
	private BigDecimal valor;
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "data_pedido")
	private Date dataPedido;
	@OneToOne 
	@JoinColumn(name = "pedido_status_id")
	private PedidoStatus pedidoStatus;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<ItemPedido> itens;
	
	public Pedido(Long id, BigDecimal valor, Date dataPedido, PedidoStatus pedidoStatus, List<ItemPedido> itens) {
		this(valor, dataPedido, pedidoStatus, itens);
		this.setId(id);
		
	}
	
	public Pedido(BigDecimal valor, Date dataPedido, PedidoStatus pedidoStatus, List<ItemPedido> itens) {
		this();
		this.valor = valor;
		this.dataPedido = dataPedido;
		this.pedidoStatus = pedidoStatus;
		this.itens = itens;
	}
	
	public Pedido(){
		this.pedidoStatus = new PedidoStatus();
		this.itens = new ArrayList<ItemPedido>();
	}
	
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public PedidoStatus getPedidoStatus() {
		return pedidoStatus;
	}
	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\nData do Pedido - ");
		retorno.append(getDataPedido());
		retorno.append("\nValor - ");
		retorno.append(getValor());
		retorno.append("\nStatus do Pedido - ");
		retorno.append(getPedidoStatus());
		retorno.append("\nItens do Pedido - ");
		int j = 0; 
		for(ItemPedido i : itens){
			retorno.append("\n\nItem: ");
			retorno.append(++j);
			retorno.append("\nProduto ");
			retorno.append(i.getProduto().getDescricao());
			retorno.append("\nValor uniário - ");
			retorno.append(i.getProduto().getPreco());
			retorno.append("\nDesconto - ");
			retorno.append(i.getDesconto());
			retorno.append("\nQuantidade - ");
			retorno.append(i.getQuantidade());
			retorno.append("\nValor - ");
			retorno.append(i.getValor());
		}
		
		return retorno.toString();
	}
	
	
	
	
}
