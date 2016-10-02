package br.com.nutribem.dominio.enums;

public enum SexoType {

	MASCULINO("MASCULINO"),
	FEMININO("FEMININO");
	
	private String descricao;
	
	private SexoType(String descricao){
		this.setDescricao(descricao);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
