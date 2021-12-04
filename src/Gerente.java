public class Gerente extends Funcionario {
    //Essa classe deve herdar as características de Funcionário.
    //Métodos
    //void visualizarPedidos(Mesa mesa): lista os pedidos realizados em uma determinada mesa, junto do total da conta da mesa até o momento.

    //Como gerente, desejo poder abrir uma nova mesa
    //Como gerente, desejo poder fechar uma determinada mesa
    //Como gerente, desejo poder visualizar pedidos de uma mesa
    //-----------------------------------------------------------------------------------------------------//
    void visualizarPedidos(Mesa mesa){
        System.out.println("ID Mesa:" + mesa.getIdMesa());
        System.out.println("Lista de Pedidos: ");
        for (int i = 0; i < mesa.getK(); i++){
            System.out.println("Pedido: " + mesa.getHistPedidos()[i].getDescricao() + "\n" + "Valor: $" + mesa.getHistPedidos()[i].getValor());
        }
    }
}
