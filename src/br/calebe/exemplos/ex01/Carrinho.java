package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<Produto> produtos;

	public Carrinho() {
		produtos = new ArrayList();
	}

	public void add(Produto produto) {
		produtos.add(produto);
	}
        
        public int getQuantity() {
		return this.produtos.size();
	}

	public Produto menorProduto() throws CarrinhoVazioExpected {
		if (produtos.isEmpty())
			throw new CarrinhoVazioExpected();
		Produto menor = produtos.get(0);
		for (Produto produto : produtos) {
			if (produto.getPreco() < menor.getPreco())
				menor = produto;
		}
		return menor;
	}
        
        public void showAll () throws CarrinhoVazioExpected {
                if (produtos.isEmpty())
                    throw new CarrinhoVazioExpected();
		for (Produto p : this.produtos) {			
			System.out.println("Produto:" + p.getName() + " Tipo:" + p.getTipo() + " Valor:" + p.getPreco());
		}
		System.out.println();
	}
        
        public boolean RemoveProduto(String nomeProduto) throws CarrinhoVazioExpected{
            if (produtos.isEmpty())
                throw new CarrinhoVazioExpected();
            for(Produto p : this.produtos) {
                    if (p.getName().equals(nomeProduto)) {
                            this.produtos.remove(p);
                            return true;
                    }
            }
            return false;
	}
        
        public double calculaValorTotal() throws CarrinhoVazioExpected{
                double valor;
                valor = 0;
                if (produtos.isEmpty())
                throw new CarrinhoVazioExpected();
		for (Produto p : this.produtos) {			
                    valor += p.getPreco();
                    
		}
		return valor;
	}


}