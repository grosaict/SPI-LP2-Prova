public class DescontoQtd {

	public double DescontoQtd(CarrinhoDeCompras carrinho) {
		Produto produto;
		double totalDesconto = 0;
		int qtdCarrinho = carrinho.getQtdItens();
		for (int i=0;i<qtdCarrinho;i++) {
			if (carrinho.getQtdProduto(i) > 5) {
				produto = carrinho.getProduto(i);
				totalDesconto += (produto.getPreco()*carrinho.getQtdProduto(i)*0.2);
			}
		}
		return totalDesconto;
	}
}