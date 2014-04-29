package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex02.controller.ClasseExemploController;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ClasseExemplo {

    private ClasseExemploController controller;
    private String answer;

    public ClasseExemplo() throws Exception {
        controller = new ClasseExemploController();
    }

    public void run(int i) {
        answer = controller.metodo(i);
    }

    public void pagueNoCartaoCredito(double valor){
        
        try{
            Thread.sleep(700);
            System.out.println("aguardando pagamento");
            Thread.sleep(300);
            answer = controller.pagamentoViaCartaoCredito(valor);
            System.out.println("pago");
        }catch(Exception e){
            System.out.println("Houve alguma falha no pagamento");
        }
        
    }
    
    public void controleEstoque(int itens){
        try{
            answer = controller.controleEstoque(itens);
            Thread.sleep(400);
            System.out.println("empacotando");
            Thread.sleep(500);
            System.out.println("enviado para entrega");
            Thread.sleep(200);
            System.out.println("Entregue!!!!!");
        }catch(Exception e){
            System.out.println("Falta de produtos no estoque!!!!!");
        }
    }
    
    public String getAnswer() {
        return answer;
    }
}
