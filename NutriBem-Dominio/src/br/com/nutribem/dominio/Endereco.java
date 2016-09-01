package br.com.nutribem.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Endereco extends EntidadeDominio implements Serializable{

	private static final long serialVersionUID = 6128853462128401001L;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	@OneToOne
	private Cidade cidade;
	
	
	public Endereco(Long id, String logradouro, String numero, 
			String complemento, String bairro, Cidade cidade){
		this(logradouro, numero, complemento, bairro, cidade);
		this.setId(id);
	}
	
	public Endereco(String logradouro, String numero, 
			String complemento, String bairro, Cidade cidade){
		this(cidade);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setBairro(bairro);
	}
	
	public Endereco(Cidade cidade){
		this();
		this.setCidade(cidade);
	}
	
	@Override @Transient
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	
	public Endereco(){
		this.cidade = new Cidade();
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\nLogradouro - ");
		retorno.append(getLogradouro());
		retorno.append("\nNumero - ");
		retorno.append(getNumero());
		retorno.append("\tComplemento - ");
		retorno.append(getComplemento());
		retorno.append("\nBairro - ");
		retorno.append(getBairro());
		retorno.append(getCidade());
				
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	
}
