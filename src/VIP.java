// Subclasse VIP
public class VIP extends Ingresso {

    public VIP(double preco) {
        // Chama o construtor da superclasse com o tipo e o preço do ingresso VIP
        super("VIP", preco * 2);
    }

    @Override
    public String toString() {
        return "Data: " + this.data + " | Tipo: " + this.getTipoIngresso() + " - Preço: " + this.getPreco();
    }
}