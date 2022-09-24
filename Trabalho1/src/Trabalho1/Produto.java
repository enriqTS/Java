package Trabalho1;

public class Produto {
	private int idProduto;
	private String nome;
	private double preco;
	private String descricao;
	
	public Produto() {
		this.idProduto = -1;
		this.nome = "";
		this.preco = -1;
		this.descricao = "";
	}
	
	public Produto(int idProduto, String nome, double preco, String descricao) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public String getProdNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void setProdNome(String nome) {
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
