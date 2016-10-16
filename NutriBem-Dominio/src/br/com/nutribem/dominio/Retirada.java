package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Retirada extends EntidadeDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String descricao;
	private BigDecimal valor;
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "data_retirada")
	private Date dataRetirada;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Colaborador colaborador;
	
	public Retirada(Long id, String descricao, BigDecimal valor, 
			Date dataRetirada, Colaborador colaborador){
		this(descricao, valor, dataRetirada, colaborador);
		this.setId(id);
	}
	
	public Retirada(String descricao, BigDecimal valor, 
			Date dataRetirada, Colaborador colaborador){
		this();
		this.descricao = descricao;
		this.valor = valor;
		this.dataRetirada = dataRetirada;
		this.colaborador = colaborador;
	}
	
	public Retirada(){
		this.colaborador = new Colaborador();
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	@Override
	public String toString() {
		
		StringBuilder retorno  = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(getId());
		retorno.append("\tDescricao - ");
		retorno.append(getDescricao());
		retorno.append("\nValor - ");
		retorno.append(getValor());
		retorno.append("\tData de Retirada - ");
		retorno.append(getDataRetirada());
		retorno.append("\nColaborador- ");
		retorno.append(getColaborador().getNome());
		
		return retorno.toString();
	}
}
