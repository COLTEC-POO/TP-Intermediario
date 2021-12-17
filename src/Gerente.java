public class Gerente extends Funcionario {
    public Gerente(){
        setNome("INVALIDO");
        setNumero(-1);
    }

    public void visualizarPedidos(Mesa mesa){

        Pedido[ ]auxiliar= mesa.getPedidos();
        System.out.println("Lista de pedidos:");
        double totalconta=0;
       for(int i=0;i<mesa.getcont();i++){
           System.out.println("Pedido:"+i+"="+auxiliar[i].getDescreve_pedido());
           totalconta=totalconta+auxiliar[i].getValor_pedido();
       }

        System.out.println("Valor da conta até o momento:R$"+totalconta);
    }
}

