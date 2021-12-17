public class Garçon extends Funcionario {

    public Garçon(){
        setNome("INVALIDO");
        setNumero(-2);
    }


    public void fazerPedido(Mesa mesa, Pedido pedido){
        mesa.setPedidos(pedido);
    }
}
