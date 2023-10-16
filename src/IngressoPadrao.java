// Subclasse Ingresso Padrão
public class IngressoPadrao extends Ingresso {

    public IngressoPadrao(double preco) {
        // Tipo e o Preço do superclasse
        super("Ingresso Padrão", preco);
    }

    @Override
    public String toString() {
        return "Data: " + this.data + " | Tipo: " + this.getTipoIngresso() + " - Preço: " + this.getPreco();
    }
}