// Subclasse Meia Entrada
public class MeiaEntrada extends Ingresso {

    public MeiaEntrada(double preco) {
        // Chama o construtor da superclasse com o tipo e o preço do ingresso de meia entrada
        super("Meia Entrada", preco * 0.5);
    }

    @Override
    public String toString() {
        return "Data: " + this.data + " | Tipo: Meia Entrada - Preço: " + this.preco;
    }
}