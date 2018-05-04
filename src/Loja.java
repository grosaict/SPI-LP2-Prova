public class Loja {

	public static void main(String[] args) {

		int qtdProdutos = 9;
		Produto[] p = new Produto[qtdProdutos];
		CarrinhoDeCompras ca = new CarrinhoDeCompras();
		DescontoAluno da = new DescontoAluno();
		DescontoQtd dq = new DescontoQtd();
		Console co = new Console();
		char itemMenu;
		int itemPedido, qtdPedido, tpCliente = 0; //tpCliente [0] normal [1] estudante
		
		co.criaProdutos(qtdProdutos, p);
		co.listaProdutos(qtdProdutos, p);
		
		do{
			co.listaCarrinho(ca, tpCliente);
			itemMenu = co.menuPrincipal();
			switch (itemMenu){
			case 'A':	//Adiciona produto carrinho
				itemPedido = co.informaItem(qtdProdutos);
				if (itemPedido > 0 && itemPedido <= qtdProdutos) {
					qtdPedido = co.informaQtd();
					if (qtdPedido > 0) {
						ca.adicionaProduto(p[itemPedido-1], qtdPedido);
					}
				}
				break;
			case 'E':	//Exclui produto carrinho
				itemPedido = co.informaItem(qtdProdutos);
				if (itemPedido > 0 && itemPedido <= qtdProdutos) {
					ca.excluiProduto(p[itemPedido-1].getSku());
				}
				break;
			}
		}while(itemMenu == 'A' || itemMenu == 'E');
		
		System.err.println(">>> Sistema Encerrado <<<");
	}
}
