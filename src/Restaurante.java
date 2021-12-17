public class Restaurante {
    public static void main(String[] args) {

        //testando a criação dos garçons
        Garçon Joao = new Garçon();
        Joao.setNumero(11);
        Joao.setNome("Joao");

        Garçon Luana = new Garçon();
        Luana.setNumero(12);
        Luana.setNome("Luana");

        //testando a criação do gerente
        Gerente Alfredo = new Gerente();
        Alfredo.setNumero(5);
        Alfredo.setNome("Alfredo");

        //testando a abertura de uma mesa
        //pelo garçon
        Mesa mesa= Joao.abrirMesa(12);
        System.out.println("Dono da mesa:"+mesa.getDonodamesa());
        //pelo gerente
        Mesa mesa1=Alfredo.abrirMesa(25);
        System.out.println("Dono da mesa:"+mesa1.getDonodamesa());

        //testando contador de mesas abertas
        System.out.println("Total de mesas abertas:"+Mesa.totaldemesas);

        //testando fazer pedido
        Pedido pedido0=new Pedido();
        pedido0.setDescreve_pedido("Coca-cola,batata,hamburger");
        pedido0.setValor_pedido(50.0);
        Joao.fazerPedido(mesa,pedido0);
        Pedido pedido1=new Pedido();
        pedido1.setDescreve_pedido("cerveja");
        pedido1.setValor_pedido(10.0);
        Joao.fazerPedido(mesa,pedido1);
        Pedido pedido2=new Pedido();
        pedido2.setDescreve_pedido("sorvete");
        pedido2.setValor_pedido(5.5);
        Joao.fazerPedido(mesa,pedido2);

        //testando o numero total de pedidos
        System.out.println("Numero total de pedidos:"+Pedido.totaldepedidos);

        //testando gerente visualizar pedidos:
        Alfredo.visualizarPedidos(mesa);
        Alfredo.visualizarPedidos(mesa1);

        //testando fechar mesa
       Joao.fecharMesa(mesa);
       System.out.println("Mesa fechada -numero clientes da mesa:"+mesa.getcliente());



    }
}