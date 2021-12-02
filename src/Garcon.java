public class Garcon extends Funcionario{

    void fazerPedido(Mesa mesa, Pedido pedido){
        mesa.adicionaPedido(pedido);
    }
}
