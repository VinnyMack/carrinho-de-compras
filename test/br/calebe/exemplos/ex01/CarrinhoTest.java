package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{null}, new Object[]{menor});
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00, "livro");
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00, "livro");
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00, "livro");
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00, "livro");
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00,"livro");
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{copia});
    }
    
    //adicionar novos tipos de produto no carrinho
    @Test
    public void addNovosTiposProdutosCarrinho() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00,"livro");
        carrinho.add(livro);
        Produto dvd = new Produto("Gravity", 50.00,"dvd");
        dvd = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{dvd});
    }
    
    //Listar todos os produtos do carrinho
    @Test 
    public void listarProdutos() throws CarrinhoVazioExpected {
        Produto p = new Produto("Gravity", 50.00,"dvd");
        Produto p1 = new Produto("Java em 24 horas", 50.00,"livro");
        Produto p2 = new Produto("PS4", 3999.00,"game");
        carrinho.add(p);
        carrinho.add(p1);
        carrinho.add(p2);
        carrinho.showAll();
                
    }

    @Test
    public void removerProdutoCarrinho()throws CarrinhoVazioExpected {
        Produto p = new Produto("Gravity", 50.00,"dvd");
        carrinho.add(p);
        carrinho.RemoveProduto("Gravity");
        assertTrue(carrinho.getQuantity() == 0);
    }

    @Test
    public void calcularValorTotal()throws CarrinhoVazioExpected {
        Produto p = new Produto("Gravity", 50.00,"dvd");
        Produto p1 = new Produto("Java em 24 horas", 50.00,"livro");
        Produto p2 = new Produto("PS4", 3999.00,"game");
        carrinho.add(p);
        carrinho.add(p1);
        carrinho.add(p2);
        System.out.println("Valor total: " + carrinho.calculaValorTotal());
        assertTrue(carrinho.calculaValorTotal() == 4099.00);
    }
    
}

