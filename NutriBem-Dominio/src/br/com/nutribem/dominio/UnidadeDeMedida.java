package br.com.nutribem.dominio;

public class UnidadeDeMedida extends EntidadeDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6562388109255686107L;
	
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

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tUnidade de Medida - ");
		retorno.append(getUnidadeDeMedida());
		
		return retorno.toString();
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
