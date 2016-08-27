package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaixaLoja extends Caixa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Pagamento> pagamentos;
	private List<Retirada> retiradas;
	private List<CaixaFuncionario> caixas;

	
	
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<Retirada> getRetiradas() {
		return retiradas;
	}

	public void setRetiradas(List<Retirada> retiradas) {
		this.retiradas = retiradas;
	}

	
	public List<CaixaFuncionario> getCaixas() {
		return caixas;
	}

	public void setCaixas(List<CaixaFuncionario> caixas) {
		this.caixas = caixas;
	}

	public CaixaLoja(Long id, BigDecimal valor, Date data, 
			List<Pagamento> pagamentos, List<Retirada> retiradas, List<CaixaFuncionario> caixas) {

		this(valor, data, pagamentos, retiradas, caixas);
		this.setId(id);
		
	}
	
	public CaixaLoja(BigDecimal valor, Date data, 
			List<Pagamento> pagamentos, List<Retirada> retiradas, List<CaixaFuncionario> caixas){
		
		this();
		this.setValor(valor);
		this.setData(data);
		this.pagamentos = pagamentos;
		this.retiradas = retiradas;
		this.caixas = caixas;
		
	}
	

	public CaixaLoja() {
		pagamentos = new ArrayList<Pagamento>();
		retiradas = new ArrayList<Retirada>();
		caixas = new ArrayList<CaixaFuncionario>();
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder retorno  = new StringBuilder();
		retorno.append(super.toString());
		
		retorno.append("\nPagamentos: ");
		for (Pagamento pagamento : pagamentos) {
			retorno.append(pagamento);
		}
		
		retorno.append("\nRetiradas: ");
		for (Retirada retirada : retiradas) {
			retorno.append(retirada);
		}
		
		retorno.append("\nCaixas: ");
		for (CaixaFuncionario c : caixas) {
			retorno.append(c);
		}
		
		return retorno.toString();
	}

}
