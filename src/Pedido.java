public class Pedido {
    private String descricao;
    private double valor;
    static int totalDePedidos = 0;

    //    Construtores

    public Pedido (String descricao, double valor){
        totalDePedidos++;
        this.descricao = descricao;
        this.valor = valor;
    }

    //    Getters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //    Setters

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
