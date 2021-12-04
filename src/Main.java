public class Main {

    public static void main(String[] args) {
        var waiter1 = new Garcon("João", "123.456.789-10");
        var waiter2 = new Garcon("Maria", "987.654.321-20");

        var manager = new Gerente("Pedro", "987.654.321-20");

        var mesa1 = waiter1.abrirMesa(5);
        var mesa2 = waiter2.abrirMesa(10);

        var pedido1 = new Pedido("Pão de queijo", 790);
        var pedido2 = new Pedido("Café com leite", 590);
        var pedido3 = new Pedido("Pizza", 1290);
        var pedido4 = new Pedido("Coca-cola", 290);

        waiter1.fazerPedido(mesa1, pedido1);
        waiter1.fazerPedido(mesa1, pedido2);
        waiter1.fazerPedido(mesa1, pedido4);

        waiter2.fazerPedido(mesa2, pedido2);
        waiter2.fazerPedido(mesa2, pedido3);

        manager.visualizarPedidos(mesa2);

        waiter1.fecharMesa(mesa1);
    }

}
