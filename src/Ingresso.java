import java.util.*;
import java.text.SimpleDateFormat;
/*CLASSE DE INGRESSOS*/
public abstract class Ingresso {
    //ATRIBUTOS
    protected Date data;
    protected double valor;
    protected String tipo;

    private Evento evento;

    /*CONSTRUTOR*/
    public Ingresso(double valor, String tipo) {
        this.data = new Date();
        this.valor = valor;
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String horarioCompra = formato.format(data);
        return "Data e Horário da Venda: " + horarioCompra + "\n" +
                "Evento: " + evento.getNome() + "\n" +
                "Tipo de Ingresso: " + tipo + "\n" +
                "Valor do Ingresso: R$" + valor;
    }
}
