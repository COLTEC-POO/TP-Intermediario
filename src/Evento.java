import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Evento {
    /*ATRIBUTOS*/
    protected String nome;
    protected String data;
    protected String horario;
    protected double preco;
    protected int ingressoVendido = 0;
    protected double receita;

    protected Ingresso capacidade[];

    /*CONSTRUTOR*/
    public Evento(String nome, String data, String horario, double preco) {
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.preco = preco;
        this.receita = 0;
    }
    /*METODOS GET E SET*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        SimpleDateFormat formatoDataHorario = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getReceita() {
        return receita;
    }

    public void adicionarReceita(double valor) {
        receita += valor;
    }

    @Override
    public String toString() {
        return "Nome do Evento: " + nome + "\n" +
                "Tipo do Evento" + getClass().getSimpleName() + "\n" +
                "Data: " + data + "\n" +
                "Horário: " + horario + "\n" +
                "Preço do ingresso: R$" + preco + "\n" +
                "Receita Total: R$" + getReceita() + "\n" +
                "Total de ingressos vendidos: " + ingressoVendido;
    }


}
