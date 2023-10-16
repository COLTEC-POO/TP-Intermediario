public class Teatro extends Evento{
    protected int ingressoVendido = 0;
    protected double receita;
    public Teatro(String nome, String data, String horario, double preco) {
        super(nome, data, horario, preco);
        this.capacidade = new Ingresso[250];
    }

}
