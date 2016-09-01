package br.com.nutribem.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = "forma_pagamento")
public class FormaDePagamento extends EntidadeDominio{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4318308102167643140L;
	@Column(unique = true, nullable = false)
	private String forma;
	
	public FormaDePagamento(Long id, String forma){
		this(forma);
		this.setId(id);
	}
	
	public FormaDePagamento(String forma){
		this();
		this.setForma(forma);
	}
	
	
	public FormaDePagamento(){
		
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	
	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tForma - ");
		retorno.append(getForma());
				
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((forma == null) ? 0 : forma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormaDePagamento other = (FormaDePagamento) obj;
		if (forma == null) {
			if (other.forma != null)
				return false;
		} else if (!forma.equals(other.forma))
			return false;
		return true;
	}
	
	

}
