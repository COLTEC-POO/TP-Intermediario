public class Garcon extends Funcionario {

    //Essa classe deve herdar as características de Funcionário.

    //Como garçon, desejo poder abrir uma nova mesa
    //Como garçon, desejo poder fechar uma determinada mesa
    //Como garçon, desejo poder fazer novos pedidos para uma mesa

    //Métodos Garçon
    //void fazerPedido(Mesa mesa, Pedido pedido): realize um determinado pedido para uma determinada mesa.
    //-----------------------------------------------------------------------------------------------------//
    void fazerPedido(Mesa mesa, Pedido pedido){
        mesa.newPedido(pedido);
        System.out.println("O pedido foi adicionado no seu historico");
        System.out.println();
    }
}
