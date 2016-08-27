package br.com.nutribem.dominio;

public class CaixaFuncionario extends Caixa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Colaborador colaborador;

	public CaixaFuncionario(Long id, Colaborador colaborador){
		this(colaborador);
		this.setId(id);
	}
	
	public CaixaFuncionario(Colaborador colaborador){
		this();
		this.colaborador = colaborador;
	}
	
	public CaixaFuncionario(){
		this.colaborador = new Colaborador();
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	@Override
	public String toString() {
		
		StringBuilder retorno  = new StringBuilder();
		retorno.append(super.toString());
		
		retorno.append("\nColaborador- ");
		retorno.append(getColaborador().getNome());
		
		return retorno.toString();
	}
	
}
