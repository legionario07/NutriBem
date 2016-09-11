package br.com.nutribem.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Loja extends EntidadeDominio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	@Column(unique = true, nullable = false)
	private String cnpj;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Contato contato;
	@OneToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	private Endereco endereco;
	
	public Loja(Long id, String nome, String nomeFantasia, String cnpj, 
			Contato contato, Endereco endereco){
		this(nome, nomeFantasia, cnpj, contato, endereco);
		this.setId(id);
	}
	
	public Loja(String nome, String nomeFantasia, String cnpj, 
			Contato contato, Endereco endereco){
		this();
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.contato = contato;
		this.endereco = endereco;
		
	}
	
	public Loja(){
		this.contato = new Contato();
		this.endereco = new Endereco();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		
		StringBuilder retorno  = new StringBuilder();
		
		retorno.append("\nId- ");
		retorno.append(getId());
		retorno.append("\tNome- ");
		retorno.append(getNome());
		retorno.append("\nNome Fantasia - ");
		retorno.append(getNomeFantasia());
		retorno.append("\nCnpj- ");
		retorno.append(getCnpj());
		retorno.append(getContato());
		retorno.append(getEndereco());
		
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Loja other = (Loja) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

}
