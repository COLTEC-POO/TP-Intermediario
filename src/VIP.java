import java.util.Date;

public class VIP extends Ingresso {
     
    VIP (Date dataCompra, double valor, String tipo) {
        super(dataCompra, valor, "VIP");
    }
    
    // Método da interface ICalculaPreco para definir o multiplicador de cada tipo

    public double calculaPreco() {
        return 2 * this.valor;
    }
}

