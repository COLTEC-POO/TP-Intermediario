import java.util.Date;

public abstract class Ingresso implements ICalculaPreco {

    protected Date dataCompra;
    protected double valor;
    protected String tipoIngresso;

    Ingresso (Date dataCompra, double valor, String tipoIngresso) {
        setDataCompra();
        setValor(valor);
        setTipoIngresso(tipoIngresso);
    }

    // Getters e Setters

    public Date getDataCompra() {
        return this.dataCompra;
    }

    public void setDataCompra() {
        this.dataCompra = new Date();
    }

    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoIngresso() {
        return this.tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }    


    // Override de toString da classe Object para imprimir as informações de um ingresso vendido em uma única string

    @Override
    public String toString() {
        double precoCerto = calculaPreco();
        return this.getDataCompra() + "\t" + this.getTipoIngresso() + "\t" + precoCerto;
    }
}
