package br.com.nutribem.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "telefone_fixo")
	private String telefoneFixo;
	@Column(name = "telefone_comercial")
	private String telefoneComercial;
	private String celular;
	private String email;
	
	
	public Contato(String telefoneFixo, String telefoneComercial, 
			String celular, String email){
		this.setTelefoneFixo(telefoneFixo);
		this.setCelular(celular);
		this.setCelular(celular);
		this.setEmail(email);
	}
	
	public Contato(){
		
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nCelular - ");
		retorno.append(getCelular());
		retorno.append("\nTelefone Fixo - ");
		retorno.append(getTelefoneFixo());
		retorno.append("\nTelefone Comercial - ");
		retorno.append(getTelefoneComercial());
		retorno.append("\nEmail - ");
		retorno.append(getEmail());
				
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Contato other = (Contato) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
}
