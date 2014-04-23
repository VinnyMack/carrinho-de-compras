package br.calebe.exemplos.ex01;

public class Produto {

	private String nome;
        private String tipo;
	private double preco;
        

	public Produto(String nome, double preco, String tipo) {
		this.nome = nome;
		this.preco = preco;
                this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public boolean equals(Object obj) {
		Produto p = (Produto) obj;
		return nome.equals(p.nome);
	}
        
	public String getName() {
		return this.nome;
	}
     
	public String getTipo() {
		return this.tipo;
	}
        

}