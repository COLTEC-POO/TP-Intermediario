import java.util.Date;

public class Ingresso implements IReceita {
    private Date data;
    protected double valor;
    protected char tipo;

    public Ingresso(double valor) {
        this.data = new Date();
        this.valor = valor;
        this.tipo = 'n';
    }

    public double getValor () {
        return this.valor;
    }

    public char getTipo() {
        return tipo;
    }

    @Override
    public double totalReceita() {
        return valor;       //receita de um ingresso é seu valor
    }

    @Override
    public String toString() {
        return "Ingresso [ Data: " + data + " || Valor: " + valor + " || Tipo: " + tipo + " ]";
    }

    @Override
    public void extratoReceita() {
        System.out.println(this.toString());
    }

}
