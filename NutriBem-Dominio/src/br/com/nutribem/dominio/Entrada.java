package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Identifica a entrada de Dinheiro na loja
 * @author PauLinHo
 *
 */
@Entity
public class Entrada extends EntidadeDominio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "data_entrada")
	private Date data;
	private BigDecimal valor;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Colaborador colaborador;
	
	public Entrada(Long id){
		this();
		this.setId(id);
	}
	
	public Entrada(){
		colaborador = new Colaborador();
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
}
