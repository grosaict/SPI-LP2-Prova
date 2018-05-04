public class DescontoAluno {

	public double DescontoAluno(CarrinhoDeCompras carrinho) {
		Produto produto;
		double totalDesconto = 0;
		int qtdCarrinho = carrinho.getQtdItens();
		for (int i=0;i<qtdCarrinho;i++) {
			produto = carrinho.getProduto(i);
			totalDesconto += (produto.getPreco()*carrinho.getQtdProduto(i)*0.15);
		}
		return totalDesconto;
	}
}
