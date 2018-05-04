import java.util.Scanner;

public class Console {
	public static void criaProdutos(int qtdProdutos, Produto[] p){
		for (int i=0; i<qtdProdutos; i++) {
			p[i] = new Produto(((i+1)*100), "PRODUTO_"+(i+1), "ABCDEFGHI"+(i+1));
		}
	}
	
	public static void listaProdutos(int qtdProdutos, Produto[] p){
		System.out.println("\nProdutos existentes na loja:\nSEQ    SKU       DESCRIÇÃO    VALOR");
		for (int i=0; i<qtdProdutos; i++) {
			System.out.println("["+(i+1)+"] "+p[i].getSku()+" - "+p[i].getNome()+" - R$"+p[i].getPreco());
		}
	}
	
	public static char menuPrincipal(){
		char itemMenu;
		Scanner leia = new Scanner(System.in);
		System.out.println("\nInforme a opção desejada:");
		System.out.println("[A]diciona produto no carrinho");
		System.out.println("[E]xclui produto do carrinho");
		System.out.println("[S]air");
		try {
			itemMenu = leia.next().charAt(0);
			itemMenu = Character.toUpperCase(itemMenu);
			if (itemMenu != 'A' && itemMenu != 'E' && itemMenu != 'S'){
				throw new Exception("OPÇÃO INEXISTENTE");
			}
		}catch(Exception e){
        	System.err.println(">> "+e.getMessage()+" << Informe novamente");
        	itemMenu = menuPrincipal();
		}
		return itemMenu;
	}

	public static int informaItem(int qtdProdutos) {
		int itemPedido;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe o produto desejado:");
		itemPedido = leia.nextInt();
		if (itemPedido < 1 || itemPedido > qtdProdutos) {
			System.err.println("Produto inexistente!!");
		}
		return itemPedido;
	}

	public static int informaQtd() {
		int qtdPedido;
		Scanner leia = new Scanner(System.in);
		do {
			System.out.println("Informe a quantidade desejada: ([0] para desistir)");
			qtdPedido = leia.nextInt();
			if (qtdPedido < 0){
				System.err.println("Valor inválido");
			}
			
		}while(qtdPedido < 0);
		return qtdPedido;
	}
	
	public static void listaCarrinho(CarrinhoDeCompras ca, int tpCliente) {
		int qtdItensCarrinho = ca.getQtdItens();
		double desconto;
		DescontoAluno da = new DescontoAluno();
		DescontoQtd dq = new DescontoQtd();
		Produto p;
		
		if (qtdItensCarrinho == 0) {
			System.out.println("\nCarrinho vazio!!!");
		} else {
			System.out.println("\nProdutos no carrinho:\nDESCRIÇÃO   VLR_UN   QTD   TOTAL");
			for (int i=0; i<qtdItensCarrinho; i++) {
				p = ca.getProduto(i);
				System.out.println(p.getNome()+" - R$"+p.getPreco()+" - "+ca.getQtdProduto(i)+" - "+(p.getPreco()*ca.getQtdProduto(i)));
			}
			if (tpCliente == 0) {
				desconto = dq.DescontoQtd(ca);
			} else {
				desconto = da.DescontoAluno(ca);
			}
			System.out.println("\nDESCONTO: "+desconto);
		}
	}
}
