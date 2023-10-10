import java.util.Date;

// Classe Ingresso representa os ingressos para os eventos
public abstract class Ingresso {

    // Atributos base
    protected Date data;
    private double preco = 30;
    private String tipo;

    // Construtor de Ingressos
    public Ingresso(String tipo, double preco) {
        this.data = new Date(); // Obtém a data atual
        this.tipo = tipo;
        this.preco = preco;
    }

    // Função para obter os detalhes do ingresso para impressão (data, tipo, preço)
    public abstract String toString();

    // Método para obter o preço do ingresso
    public double getPreco() {
        return preco;
    }

    // Função para obter o tipo do ingresso
    public String getTipoIngresso() {
        return tipo;
    }
}
