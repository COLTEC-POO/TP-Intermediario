public class Gerente extends Funcionario{
    void visualizarPedidos(Mesa mesa){
        int i;
        double total = 0;
        System.out.println("Pedidos mesa " + mesa.getNumeroDaMesa() + ": \n");
        for (i = 0; i < mesa.getNumeroDePedidosNaMesa(); i++){
            System.out.println(mesa.getHistoricoDePedidos()[i].getDescricao() + "\n");
            total = (double) total + (double) mesa.getHistoricoDePedidos()[i].getValor();
        }
        System.out.println("Total da conta: R$ " + total + "\n");

    }
}

