import java.util.Date;

public class Ingresso {

    private Date dataVenda;
    private TipoIngresso tipoIngresso;
    private double valor;

    public Ingresso(Date dataVenda, TipoIngresso tipoIngresso, double valor) {
        this.dataVenda = dataVenda;
        this.tipoIngresso = tipoIngresso;
        this.valor = valor;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public double getValor() {
        return valor;
    }
}
