package br.com.nutribem.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Categoria extends EntidadeDominio implements Serializable{

	private static final long serialVersionUID = -6394527136029323070L;

	@Column(unique = true, nullable = false)
	private String categoria;
	
	public Categoria(Long id, String categoria){
		this(categoria);
		this.setId(id);
	}
	
	public Categoria(String categoria){
		this();
		this.categoria = categoria;
	}
	
	public Categoria(){
		
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {

		return getCategoria();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		return true;
	}
	
	
}
