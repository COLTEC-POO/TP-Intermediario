import java.util.Date;

public class MeiaEntrada extends Ingresso {

    MeiaEntrada (Date dataCompra, double valor, String tipo) {
        super(dataCompra, valor, "Meia");
    }

    // Método da interface ICalculaPreco para definir o multiplicador de cada tipo
    
    public double calculaPreco() {
        return 0.5 * this.valor;
    }
}
