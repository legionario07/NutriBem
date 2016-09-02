package br.com.nutribem.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends EntidadeDominio implements Serializable{

	private static final long serialVersionUID = 5683204210892356435L;
	private String nome;
	@ManyToOne(fetch = FetchType.EAGER) 
	private Estado estado;
	
	public Cidade(Long id, String nome, Estado estado){
		this(nome, estado);
		this.setId(id);
	}
	
	public Cidade(String nome, Estado estado){
		this();
		this.setNome(nome);
		this.setEstado(estado);
	}
	
	public Cidade(){
		this.estado = new Estado();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tCidade - ");
		retorno.append(getNome());
		retorno.append(getEstado());
		
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
