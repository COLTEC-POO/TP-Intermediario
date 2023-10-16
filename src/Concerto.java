public class Concerto extends Evento{
    protected int ingressoVendido = 0;
    protected double receita = 0;
    public Concerto(String nome, String data, String horario, double preco) {
        super(nome, data, horario, preco);
        this.capacidade = new Ingresso[150];
    }


}
