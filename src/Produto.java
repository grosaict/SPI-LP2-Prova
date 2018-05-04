public class Produto {

	private double preco;
	private String nome;
	private String sku;
	
	public Produto(double preco, String nome, String sku) {
		this.preco = preco;
		this.nome = nome;
		this.sku = sku;
	}
	
	public void alteraPreco(double preco) {
		this.preco = preco;
	}
	
	public void alteraNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return this.preco;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getSku() {
		return this.sku;
	}	
}
