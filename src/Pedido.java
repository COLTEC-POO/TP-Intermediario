public class Pedido {
    //Pedido: representa um pedido realizado

    //Atributos
    //Descrição do pedido
    //Valor do pedido
    //TOTAL DE PEDIDOS: Número total de pedidos realizados no geral
    //-----------------------------------------------------------------------------------------------------//
    private String descricao;
    private double valor;
    static int qtyPedidos = 0;
    //-----------------------------------------------------------------------------------------------------//

    //Getters

    public String getDescricao() {return descricao;}
    public double getValor() {return valor;}
    //-----------------------------------------------------------------------------------------------------//

    //Setters

    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setValor(double valor) {this.valor = valor;}
    //-----------------------------------------------------------------------------------------------------//

    //Construtores
    public Pedido(String descricao, double valor){
        qtyPedidos++;
        this.descricao = descricao;
        this.valor = valor;
    }
    //-----------------------------------------------------------------------------------------------------//

}
