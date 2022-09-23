package Trabalho1;

public class Produto {
	private String idProduto;
	private String nome;
	private String preco;
	private String descricao;
	
	public Produto() {
		this.idProduto = "";
		this.nome = "";
		this.preco = "";
		this.descricao = "";
	}
	
	public Produto(String idProduto, String nome, String preco, String descricao) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public String getIdProduto() {
		return idProduto;
	}
	
	public String getPreco() {
		return preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String prod = "Identificador: " + this.idProduto + System.lineSeparator() + "Nome: " + this.nome
		+ System.lineSeparator() + "Descrição: " + this.descricao + System.lineSeparator() + "Preço: "
		+ this.preco;
		
		return prod;
	}

	
}
