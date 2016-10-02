package br.com.nutribem.dominio;

import javax.persistence.Entity;

@Entity
public class Estado extends EntidadeDominio {

	private static final long serialVersionUID = 1231675706483651308L;
	private String nome;
	private String uf;

	public Estado(Long id, String nome, String uf){
		this(nome, uf);
		this.setId(id);
	}
	
	public Estado(String nome, String uf){
		this();
		this.setNome(nome);
		this.setUf(uf);
	}
	
	public Estado(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {

		return getUf();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Estado other = (Estado) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
