import java.util.Date;

public class Normal extends Ingresso {

    Normal(Date dataCompra, double valor, String tipo) {
        super(dataCompra, valor, "Normal");
    }
    
    // Método da interface ICalculaPreco para definir o multiplicador de cada tipo
    
    public double calculaPreco() {
        return this.valor;
    }
}