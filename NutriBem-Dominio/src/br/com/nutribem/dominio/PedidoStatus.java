package br.com.nutribem.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = "pedido_status")
public class PedidoStatus extends EntidadeDominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5137745839174495691L;
	@Column(unique = true, nullable = false)
	private String pedidoStatus;
	
	public PedidoStatus(Long id, String pedidoStatus) {
		this(pedidoStatus);
		this.setId(id);
	}
	
	public PedidoStatus(String pedidoStatus) {
		this();
		this.pedidoStatus = pedidoStatus;
	}

	public PedidoStatus(){
		
	}

	public String getPedidoStatus() {
		return pedidoStatus;
	}

	public void setPedidoStatus(String pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}
	
	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tPedido Status - ");
		retorno.append(getPedidoStatus());
		
		return retorno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pedidoStatus == null) ? 0 : pedidoStatus.hashCode());
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
		PedidoStatus other = (PedidoStatus) obj;
		if (pedidoStatus == null) {
			if (other.pedidoStatus != null)
				return false;
		} else if (!pedidoStatus.equals(other.pedidoStatus))
			return false;
		return true;
	}
	
	
}
