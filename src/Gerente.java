
public class Gerente extends Funcionario {

    public Gerente(String nome, String code) {
        super(nome, code);
    }

    void visualizarPedidos(Mesa mesa) {

        System.out.println("\n# Pedidos da mesa " + mesa.getTableNumber() + " #\n");
        for (Pedido pedido : mesa.getOrderHistory()) {
            if (pedido == null) {
                break;
            }
            System.out.println(pedido.getDescription() + " - " + pedido.getValue());
        }

        System.out.println("\nTotal: " + mesa.getTotalBill());
    }

}
