package br.com.nutribem.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = "unidade_medida")
public class UnidadeDeMedida extends EntidadeDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6562388109255686107L;
	
	@Column(unique = true, nullable = false, name = "unidade_medida") 
	private String unidadeDeMedida;
	
	public UnidadeDeMedida(Long id, String unidadeDeMedida){
		this(unidadeDeMedida);
		this.setId(id);
	}
	
	public UnidadeDeMedida(String unidadeDeMedida){
		this();
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	public UnidadeDeMedida(){
		
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	@Override
	public String toString() {
		
		return getUnidadeDeMedida();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((unidadeDeMedida == null) ? 0 : unidadeDeMedida.hashCode());
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
		UnidadeDeMedida other = (UnidadeDeMedida) obj;
		if (unidadeDeMedida == null) {
			if (other.unidadeDeMedida != null)
				return false;
		} else if (!unidadeDeMedida.equals(other.unidadeDeMedida))
			return false;
		return true;
	}
	
	

}
