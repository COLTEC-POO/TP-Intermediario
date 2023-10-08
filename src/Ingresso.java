import java.util.Date;

// Classe Ingresso representa os ingressos para os eventos
public class Ingresso {

    // Atributos base
    protected Date data;
    protected double preco = 30;
    protected String tipo;

    // Construtor de Ingressos
    public Ingresso(String tipo, double preco) {
        this.data = new Date(); // Obtém a data atual
        this.tipo = tipo;
        this.preco = preco;
    }

    // Função para obter os detalhes do ingresso para impressão (data, tipo, preço)
    public String toString() {
        return "Data: " + this.data + "\nTipo: " + this.tipo + "\nPreço: " + this.preco;
    }

    // Método abstrato para obter o preço do ingresso (será implementado nas subclasses)
    public double getPreco() {
        return preco;
    }

    // Função para obter o tipo do ingresso
    public String getTipoIngresso() {
        return tipo;
    }

    // Subclasse Ingresso Padrão
    public static class IngressoPadrao extends Ingresso {

        public IngressoPadrao(double preco) {
            // Tipo e o Preço do superclasse
            super("Ingresso Padrão", preco);
        }

        @Override
        public String toString() {
            return "Data: " + this.data + " | Tipo: Ingresso Padrão - Preço: " + this.preco;
        }
    }

    // Subclasse Meia Entrada
    public static class MeiaEntrada extends Ingresso {

        public MeiaEntrada(double preco) {
            // Chama o construtor da superclasse com o tipo e o preço do ingresso de meia entrada
            super("Meia Entrada", preco * 0.5);
        }

        @Override
        public String toString() {
            return "Data: " + this.data + " | Tipo: Meia Entrada - Preço: " + this.preco;
        }
    }

    // Subclasse VIP
    public static class VIP extends Ingresso {

        public VIP(double preco) {
            // Chama o construtor da superclasse com o tipo e o preço do ingresso VIP
            super("VIP", preco * 2);
        }

        @Override
        public String toString() {
            return "Data: " + this.data + " | Tipo: VIP - Preço: " + this.preco;
        }
    }
}
