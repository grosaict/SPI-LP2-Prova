public class CarrinhoDeCompras {

	private int qtdItens = 0;
	private int maxItens = 10;
	private Produto[] produto = new Produto[maxItens];
	private int[] qtdProduto = new int[maxItens];
	
	public boolean adicionaProduto(Produto produto, int qtdProduto) {
		boolean existente = false;
		boolean adicionado = true;
		
		if (this.qtdItens >= maxItens || qtdProduto <= 0) {
			adicionado = false;
		}else {
			if (this.qtdItens == 0) {
				this.produto[this.qtdItens] = produto;
				this.qtdProduto[this.qtdItens] = qtdProduto;
				this.qtdItens++;
			} else {
				for (int i=0; i<this.qtdItens; i++) {
					if (this.produto[i].getSku() == produto.getSku()) {
						this.qtdProduto[i] += qtdProduto;
						existente = true;
						i = this.qtdItens;
					}
				}
				if (!existente) {
					this.produto[this.qtdItens] = produto;
					this.qtdProduto[this.qtdItens] = qtdProduto;
					this.qtdItens++;
				}
			}
		}
		return adicionado;
	}
	
	public boolean excluiProduto(String sku) {
		boolean excluido = false;
		
		for (int i=0; i<this.qtdItens; i++) {
			if (this.produto[i].getSku() == sku) {
				excluido = true;
				if (i == this.qtdItens-1) {
					this.produto[i] = null;
					this.qtdProduto[i] = 0;
					this.qtdItens--;
				}else {
					for (int j=i; j<this.qtdItens; j++) {
						if (j == this.qtdItens-1) {
							this.produto[j] = null;
							this.qtdProduto[j] = 0;
							this.qtdItens--;
						} else {
							this.produto[j] = this.produto[j+1];
							this.qtdProduto[j] = this.qtdProduto[j+1];
						}
					}
					i = this.qtdItens;
				}
			}
		}
		return excluido;
	}
	
	public double totalPedido() {
		double vlrTotalPedido = 0;
		for (int i=0; i<this.qtdItens; i++) {
			vlrTotalPedido =+ (this.produto[i].getPreco() * this.qtdProduto[i]);
		}
		return vlrTotalPedido;
	}
	
	public Produto getProduto (int i) {
		if (i < this.qtdItens) {
			return this.produto[i];
		} else {
			return null;
		}
	}
	
	public int getQtdProduto (int i) {
		if (i < this.qtdItens) {
			return this.qtdProduto[i];
		} else {
			return 0;
		}
	}
	
	public void setQtdProduto (Produto produto, int i) {
		if (i < this.qtdItens) {
			this.produto[i] = produto;
		}
	}

	public int getQtdItens() {
		return this.qtdItens;
	}
}
