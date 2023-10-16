public class Cinema extends Evento{
    protected int ingressoVendido = 0;
    protected double receita;
    public Cinema(String nome, String data, String horario, double preco) {
        super(nome, data, horario, preco);
        this.capacidade = new Ingresso[200];
    }


}
