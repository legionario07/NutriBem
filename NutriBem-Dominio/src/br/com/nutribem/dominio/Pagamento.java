package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Pagamento extends EntidadeDominio {

	private static final long serialVersionUID = 7713495659737170112L;
	
	private Date dataPagamento;
	private BigDecimal valorPago;
	private FormaDePagamento formaDePagamento;
	private Pedido pedido;
	
	public Pagamento(Long id, Date dataPagamento, BigDecimal valorPago, FormaDePagamento formaDePagamento, Pedido pedido) {
		
		this(dataPagamento, valorPago, formaDePagamento, pedido);
		this.setId(id);
		
	}
	
	public Pagamento(Date dataPagamento, BigDecimal valorPago, FormaDePagamento formaDePagamento, Pedido pedido) {
		this();
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
		this.formaDePagamento = formaDePagamento;
		this.pedido = pedido;
	}
	
	public Pagamento(){
		this.formaDePagamento = new FormaDePagamento();
		this.pedido = new Pedido();
	}
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		retorno.append(getPedido());
		
		return retorno.toString();
	}
}
