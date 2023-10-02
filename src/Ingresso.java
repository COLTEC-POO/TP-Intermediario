import java.util.Date;

public class Ingresso {

    // Atributos base
    protected Date data;
    protected double preco = 30;
    protected String tipo;

    int VendaIngresso = 0;

    // Construtor de Ingressos
    public Ingresso(String tipo, double preco) {
        this.data = new Date();
        this.tipo = tipo;
        this.preco = preco;
    }

    // Isso vai ser abstrato
    // Funcao para pegar os detalhes para impressao como data, tipo, preco
    public String toString() {
        return this.data + " " + this.tipo + " " +  this.preco;
    }

    // Isso vai ser abstrato
    public double getPreco() {
        return preco;
    }

    // Isso vai ser abstrato
    // Funcao para pegar o tipo de ingresso
    public String getTipoIngresso() {
        return tipo;
    }

    // Subclasse meiaEntrada que representa um ingresso de meia entrada
    public static class meiaEntrada extends Ingresso {

        public meiaEntrada(double preco) {
            // Chama os dados da superclasse com o tipo e o preço ajustado para meia entrada
            super("Meia Entrada", preco * 0.5);
            // Aumenta o numero de ingressos vendidos
            VendaIngresso++;
        }

        @Override
        public String toString() {
            return this.data + " Meia Entrada " + this.preco;
        }
    }

    public static class VIP extends Ingresso {

        public VIP(double preco) {
            // Chama os dados da superclasse com o tipo e o preço ajustado para meia entrada
            super(" VIP ", preco * 2 );
            // Aumenta o numero de ingressos vendidos
            VendaIngresso++;
        }
    }
}