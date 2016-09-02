package br.com.nutribem.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor extends EntidadeDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4977156671177763274L;
	private String nome;
	@Column(unique = true)
	private String cnpj;
	@OneToOne
	private Endereco endereco;
	@OneToOne
	private Contato contato;
	
	public Fornecedor(Long id, String nome, String cnpj, Endereco endereco, 
			Contato contato){
		this(nome, cnpj, endereco, contato);
		this.setId(id);
	}
	
	public Fornecedor(String nome, String cnpj, Endereco endereco, 
			Contato contato){
		this(endereco, contato);
		this.setNome(nome);
		this.setCnpj(cnpj);
	}
	
	public Fornecedor(Endereco endereco, Contato contato){
		this();
		this.setEndereco(endereco);
		this.setContato(contato);
	}
	
	public Fornecedor(){
		this.endereco = new Endereco();
		this.contato = new Contato();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\nNome - ");
		retorno.append(getNome());
		retorno.append("\nCNPJ - ");
		retorno.append(getCnpj());
		retorno.append(getEndereco());
		retorno.append(getContato());
		
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	
	
}
