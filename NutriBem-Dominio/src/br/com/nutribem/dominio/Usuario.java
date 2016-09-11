package br.com.nutribem.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends EntidadeDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(unique = true, nullable = false)
	private String login;
	private String senha;
	private Boolean ativo;
	@OneToOne(fetch = FetchType.EAGER)
	private Permissao permissao;
	
	public Usuario(Long id, String login, 
			String senha, Permissao permissao){
		this(permissao);
		this.setId(id);
		this.setLogin(login);
		this.setSenha(senha);
	}
	
	public Usuario(Permissao permissao){
		this();
		setPermissao(permissao);
	}
	
	public Usuario(){
		this.permissao = new Permissao();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tLogin - ");
		retorno.append(getLogin());
		retorno.append("\tSenha - ");
		retorno.append(getSenha());
		retorno.append("\tAtivo - ");
		retorno.append(getAtivo());
		retorno.append(getPermissao());
		
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	
}
