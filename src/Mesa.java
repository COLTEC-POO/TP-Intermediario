public class Mesa {
    private int numeroDaMesa;
    private int numeroDeClientes;
    private Pedido [] historicoDePedidos;
    private String funcionarioResponsavel;
    private static int totalDeMesas = 0;
    private int numeroDePedidosNaMesa = 0;

    //  Construtores

    public Mesa (String funcionarioResponsavel, int numeroDeClientes){
        totalDeMesas++;
        numeroDaMesa = totalDeMesas;
        historicoDePedidos = new Pedido [100];
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.numeroDeClientes = numeroDeClientes;
    }

    //    Getters

    public int getNumeroDaMesa() {
        return numeroDaMesa;
    }

    public int getNumeroDeClientes() {
        return numeroDeClientes;
    }

    public Pedido[] getHistoricoDePedidos() {
        return historicoDePedidos;
    }

    public String getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public static int getTotalDeMesas() {
        return totalDeMesas;
    }

    public int getNumeroDePedidosNaMesa() {
        return numeroDePedidosNaMesa;
    }

    //  Setters

    public void setNumeroDaMesa(int numeroDaMesa) {
        this.numeroDaMesa = numeroDaMesa;
    }

    public void setNumeroDeClientes(int numeroDeClientes) {
        this.numeroDeClientes = numeroDeClientes;
    }

    public void setHistoricoDePedidos(Pedido[] historicoDePedidos) {
        this.historicoDePedidos = historicoDePedidos;
    }

    public void setFuncionarioResponsavel(String funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public static void setTotalDeMesas(int totalDeMesas) {
        Mesa.totalDeMesas = totalDeMesas;
    }

    public void setNumeroDePedidosNaMesa(int numeroDePedidosNaMesa) {
        this.numeroDePedidosNaMesa = numeroDePedidosNaMesa;
    }
    //  Métodos

    public void adicionaPedido (Pedido pedido){
        historicoDePedidos[numeroDePedidosNaMesa]= pedido;
        numeroDePedidosNaMesa++;
    }

}
