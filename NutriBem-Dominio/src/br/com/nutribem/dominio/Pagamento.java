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
public class Pagamento extends EntidadeDominio {

	private static final long serialVersionUID = 7713495659737170112L;
	
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "data_pagamento")
	private Date dataPagamento;
	@Column(name = "valor_pago")
	private BigDecimal valorPago;
	@OneToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "forma_pagamento_id")
	private FormaDePagamento formaDePagamento;
	@ElementCollection
	private List<Pedido> pedidos;
	
	public Pagamento(Long id, Date dataPagamento, BigDecimal valorPago, FormaDePagamento formaDePagamento, List<Pedido> pedidos) {
		
		this(dataPagamento, valorPago, formaDePagamento, pedidos);
		this.setId(id);
		
	}
	
	public Pagamento(Date dataPagamento, BigDecimal valorPago, FormaDePagamento formaDePagamento, List<Pedido> pedidos) {
		this();
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
		this.formaDePagamento = formaDePagamento;
		this.pedidos = pedidos;
	}
	
	public Pagamento(){
		this.formaDePagamento = new FormaDePagamento();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tData do Pagamento - ");
		retorno.append(getDataPagamento());
		retorno.append("\tValor Pago - ");
		retorno.append(getValorPago());
		retorno.append(getFormaDePagamento());
		retorno.append("\nPedidos - ");
		for(Pedido p : pedidos){
			retorno.append(p);
		}
		
		return retorno.toString();
	}
}
