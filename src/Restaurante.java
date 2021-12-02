public class Restaurante {
    public static void main(String[] args) {

        Mesa [] mesas;

        mesas = new Mesa [50];

        Gerente gerenteRestaurante;
        gerenteRestaurante = new Gerente();

        gerenteRestaurante.setCodigo("GE001");
        gerenteRestaurante.setNome("Gerente Geral");

        Garcon garcon;
        garcon = new Garcon();

        garcon.setCodigo("GA001");
        garcon.setNome("Garcon 1");

        Garcon garcon2;
        garcon2 = new Garcon();

        garcon2.setCodigo("GA002");
        garcon2.setNome("Garcon 2");

        mesas[Mesa.getTotalDeMesas()] = garcon.abrirMesa(5);

        Pedido pedido;

        pedido = new Pedido("Hambuguer com batata",20.5);

        garcon.fazerPedido(mesas[Mesa.getTotalDeMesas() - 1], pedido);

        pedido = new Pedido("Pizza grande",25.5);

        garcon.fazerPedido(mesas[Mesa.getTotalDeMesas() - 1], pedido);

        pedido = new Pedido("Refrigerante 3 litros",6.0);

        garcon.fazerPedido(mesas[Mesa.getTotalDeMesas() - 1], pedido);

        gerenteRestaurante.visualizarPedidos(mesas[Mesa.getTotalDeMesas() - 1]);

        mesas[Mesa.getTotalDeMesas()] = garcon2.abrirMesa(2);

        pedido = new Pedido("Batata frita com bacon e cheddar",25.5);

        garcon2.fazerPedido(mesas[Mesa.getTotalDeMesas() - 1], pedido);

        pedido = new Pedido("Refrigerante 2 litros",4.5);

        garcon2.fazerPedido(mesas[Mesa.getTotalDeMesas() - 1], pedido);

        gerenteRestaurante.visualizarPedidos(mesas[Mesa.getTotalDeMesas() - 1]);

        garcon.fecharMesa(mesas[Mesa.getTotalDeMesas() - 2]);

        garcon2.fecharMesa(mesas[Mesa.getTotalDeMesas() - 1]);

        gerenteRestaurante.visualizarPedidos(mesas[Mesa.getTotalDeMesas() - 2]);

        gerenteRestaurante.visualizarPedidos(mesas[Mesa.getTotalDeMesas() - 1]);

    }
}