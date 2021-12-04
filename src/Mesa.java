public class Mesa {

    //Mesa: representa uma mesa do restaurante

    //Atributos
    //Número da mesa
    //Número de clientes
    //Histórico de pedidos (no máximo 100)
    //Funcionário responsável pela mesa
    //TOTAL DE MESAS: Número total de mesas abertas no geral
    //-----------------------------------------------------------------------------------------------------//
    private int idMesa;
    private int qtyClientes;
    private static int qtyMesas;
    private String responsavel;
    private Pedido [] histPedidos;
    private int k;
    //-----------------------------------------------------------------------------------------------------//

    //Getters
    public int getIdMesa() {return idMesa;}
    public int getQtyClientes() {return qtyClientes;}
    public Pedido[] getHistPedidos() {return histPedidos;}
    public String getResponsavel() {return responsavel;}
    public static int getQtyMesas() {return qtyMesas;}
    public int getK() {return k;}
    //-----------------------------------------------------------------------------------------------------//

    //Setters
    public void setIdMesa(int idMesa) {this.idMesa = idMesa;}
    public void setQtyClientes(int qtyClientes) {this.qtyClientes = qtyClientes;}
    public void setHistPedidos(Pedido[] histPedidos) {this.histPedidos = histPedidos;}
    public void setResponsavel(String responsavel) {this.responsavel = responsavel;}
    public static void setQtyMesas(int qtyMesas) {Mesa.qtyMesas = qtyMesas;}
    public void setK(int k) {this.k = k;}
    //-----------------------------------------------------------------------------------------------------//

    //  Construtores
    public Mesa(String responsavel, int qtyClientes){
        qtyMesas++; idMesa = qtyMesas;
        histPedidos = new Pedido [100];
        this.responsavel = responsavel;
        this.qtyClientes = qtyClientes;
    }
    //-----------------------------------------------------------------------------------------------------//

    //  Métodos
    public void newPedido(Pedido pedido){histPedidos[k]= pedido; k++;}
    public void infoMesas(){
        System.out.println("Mesa: " + this.idMesa);
        System.out.println("Responsavel: " + this.responsavel);
        System.out.println("Clientes: " + this.qtyClientes);
    }
    //-----------------------------------------------------------------------------------------------------//

}
