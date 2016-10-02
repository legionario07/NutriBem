package br.com.nutribem.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Permissao extends EntidadeDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5635758496415760256L;
	@Column(unique = true, nullable = false)
	private String nivel;
	
	public Permissao(Long id, String nivel){
		this(nivel);
		this.setId(id);
	}
	
	public Permissao(String nivel){
		this();
		this.setNivel(nivel);
	}
	
	public Permissao(){
		
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {

		return getNivel();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
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
		Permissao other = (Permissao) obj;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		return true;
	}
	
	
}
