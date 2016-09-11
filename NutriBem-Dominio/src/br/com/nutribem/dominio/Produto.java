package br.com.nutribem.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produto extends EntidadeDominio{

	private static final long serialVersionUID = 1199548372165014072L;
	
	@Column(nullable = false)
	private String descricao;
	@Column(name = "codigo_barras", unique = true)
	private String codigoBarras;
	@Column(name = "qtde_estoque")
	private Integer quantidadeEstoque;
	@Column(name = "qtde_minima")
	private Integer quantidadeMinima;
	private BigDecimal preco;
	@Temporal(TemporalType.DATE) @Column(name = "data_fabricacao")
	private Date dataDeFabricacao;
	@Temporal(TemporalType.DATE) @Column(name = "data_validade")
	private Date dataDeValidade;
	private String lote;
	@OneToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unidade_medida_id")
	private UnidadeDeMedida unidadeDeMedida;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Fornecedor> fornecedores;
	
	public Produto(Long id, String descricao, String codigoBarras, Integer quantidadeEstoque, Integer quantidadeMinima,
			BigDecimal preco, Date dataDeFabricacao, Date dataDeValidade, String lote, Categoria categoria,
			UnidadeDeMedida unidadeDeMedida, List<Fornecedor> fornecedores) {
		
		this(descricao,codigoBarras, quantidadeEstoque, quantidadeMinima, preco, dataDeFabricacao, 
				dataDeValidade, lote, categoria, unidadeDeMedida, fornecedores);

		this.setId(id);
	}
	
	
	public Produto(String descricao, String codigoBarras, Integer quantidadeEstoque, Integer quantidadeMinima,
			BigDecimal preco, Date dataDeFabricacao, Date dataDeValidade, String lote, Categoria categoria,
			UnidadeDeMedida unidadeDeMedida, List<Fornecedor> fornecedores) {
		this();
		this.descricao = descricao;
		this.codigoBarras = codigoBarras;
		this.quantidadeEstoque = quantidadeEstoque;
		this.quantidadeMinima = quantidadeMinima;
		this.preco = preco;
		this.dataDeFabricacao = dataDeFabricacao;
		this.dataDeValidade = dataDeValidade;
		this.lote = lote;
		this.categoria = categoria;
		this.unidadeDeMedida = unidadeDeMedida;
		this.fornecedores = fornecedores;
	}

	public Produto(){
		this.categoria = new Categoria();
		this.unidadeDeMedida = new UnidadeDeMedida();
		this.fornecedores = new ArrayList<Fornecedor>();
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Integer getQuantidadeMinima() {
		return quantidadeMinima;
	}
	public void setQuantidadeMinima(Integer quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}
	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	public Date getDataDeValidade() {
		return dataDeValidade;
	}
	public void setDataDeValidade(Date dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public UnidadeDeMedida getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public String toString() {

		StringBuilder retorno = new StringBuilder();
		retorno.append("\nId - ");
		retorno.append(this.getId());
		retorno.append("\tDescricao - ");
		retorno.append(getDescricao());
		retorno.append(getCategoria());
		retorno.append("\nCodigo de Barras - ");
		retorno.append(getCodigoBarras());
		retorno.append("\nPreço - ");
		retorno.append(getPreco());
		retorno.append("\tQuantidade em Estoque - ");
		retorno.append(getQuantidadeEstoque());
		retorno.append("\tQuantidade Minima - ");
		retorno.append(getQuantidadeMinima());
		retorno.append("\nData de Fabricação - ");
		retorno.append(getDataDeFabricacao());
		retorno.append("\tData de Validade - ");
		retorno.append(getDataDeValidade());
		retorno.append("\nLote - ");
		retorno.append(getLote());
		retorno.append(getUnidadeDeMedida());
		retorno.append("\nFornecedores - ");
		for(Fornecedor f : fornecedores){
			retorno.append(f);
		}
		
		return retorno.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
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
		Produto other = (Produto) obj;
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
			return false;
		return true;
	}
	
	
	

}
