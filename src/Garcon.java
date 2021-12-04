
public class Garcon extends Funcionario {

    public Garcon(String nome, String code) {
        super(nome, code);
    }

    void fazerPedido(Mesa mesa, Pedido pedido) {
        System.out.println("Fazer pedido");
        mesa.pushOrderToHistory(pedido);
        System.out.println("Pedido " + pedido.getDescription() + " feito para a mesa " + mesa.getTableNumber());
    }
}
