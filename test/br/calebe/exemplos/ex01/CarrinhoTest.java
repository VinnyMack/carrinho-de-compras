package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex02.ClasseExemplo;
import br.calebe.exemplos.ex02.controller.ClasseExemploController;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.easymock.EasyMock;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

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
    
    /*@Test
    public void realizarPagamentoCarrinho() throws Exception{
        
        double total;
        
        Produto p = new Produto("Gravity", 50.00,"dvd");
        Produto p1 = new Produto("Java em 24 horas", 50.00,"livro");
        Produto p2 = new Produto("PS4", 3999.00,"game");
        carrinho.add(p);
        carrinho.add(p1);
        carrinho.add(p2);
        
        total = carrinho.calculaValorTotal();
        
        
        //============PAGAMENTO==================
        // Cria o objeto Mock da classe ClasseExemploController
        ClasseExemploController controllerMockPagamento = PowerMock.createMock(ClasseExemploController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(ClasseExemploController.class).andReturn(controllerMockPagamento);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMockPagamento.pagamentoViaCartaoCredito(total)).andReturn("Pagamento feito no valor de "+total);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMockPagamento, ClasseExemploController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        ClasseExemplo tested = new ClasseExemplo();
        tested.pagueNoCartaoCredito(total);
        
        // Faz a verificaçao agendada
        Assert.assertEquals("Pagamento feito no valor de "+total, tested.getAnswer());
        
        System.out.println("Pagamento efetuado no valor de " + carrinho.calculaValorTotal());
       
        // Executa todas as verificação
        PowerMock.verifyAll();
    }*/
    
    @Test
    public void controleDeEstoque() throws Exception{
        List<String> listaProdutos = new ArrayList<>();
        int itens;
        
        //add 3 itens
        listaProdutos.add("Shampoo");
        listaProdutos.add("Camisinha");
        listaProdutos.add("Sabonete");
        
        itens = listaProdutos.size();
        
        //=============CONTROLE DE ESTOQUE==================
        // Cria o objeto Mock da classe ClasseExemploController
        ClasseExemploController controllerMockEstoque = PowerMock.createMock(ClasseExemploController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(ClasseExemploController.class).andReturn(controllerMockEstoque);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMockEstoque.controleEstoque(itens)).andReturn("Quantidade de itens: "+itens);
        // "Executa" a configuração programada
        PowerMock.replay(controllerMockEstoque,ClasseExemploController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        ClasseExemplo controlaEstoque = new ClasseExemplo();
        controlaEstoque.controleEstoque(itens);
        
        // Faz a verificaçao agendada
        Assert.assertEquals("Quantidade de itens: "+itens, controlaEstoque.getAnswer());
        
        PowerMock.verifyAll();
        
    }    
}

