
public class Gerente extends Funcionario {

    public Gerente(String nome, String code) {
        super(nome, code);
    }

    void visualizarPedidos(Mesa mesa) {

        System.out.println("Pedidos da mesa " + mesa.getTableNumber() + "\n");
        for (Pedido pedido : mesa.getOrderHistory()) {
            System.out.println(pedido.getDescription() + " - " + pedido.getValue() + "\n");
        }

        System.out.println("\nTotal: " + mesa.getTotalBill());
    }

}
