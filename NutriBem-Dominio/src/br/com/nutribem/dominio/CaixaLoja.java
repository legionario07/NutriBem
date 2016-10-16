package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity @Table(name = "caixa_loja")
public class CaixaLoja extends Caixa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ElementCollection(fetch = FetchType.EAGER)
	@IndexColumn(name= "id")	
	private List<Entrada> entradas;
	@ElementCollection(fetch = FetchType.EAGER)
	@IndexColumn(name= "id")
	private List<Retirada> retiradas;
	@ElementCollection()
	private List<CaixaFuncionario> caixas;

	

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
			List<Entrada> entradas, List<Retirada> retiradas, List<CaixaFuncionario> caixas) {

		this(valor, data, entradas, retiradas, caixas);
		this.setId(id);
		
	}
	
	public CaixaLoja(BigDecimal valor, Date data, 
			List<Entrada> entradas, List<Retirada> retiradas, List<CaixaFuncionario> caixas){
		
		this();
		this.setValor(valor);
		this.setData(data);
		this.entradas = entradas;
		this.retiradas = retiradas;
		this.caixas = caixas;
		
	}
	

	public CaixaLoja() {
		entradas = new ArrayList<Entrada>();
		retiradas = new ArrayList<Retirada>();
		caixas = new ArrayList<CaixaFuncionario>();
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder retorno  = new StringBuilder();
		retorno.append(super.toString());
		
		retorno.append("\nPagamentos: ");
		for (Entrada entrada : entradas) {
			retorno.append(entrada);
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

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

}
