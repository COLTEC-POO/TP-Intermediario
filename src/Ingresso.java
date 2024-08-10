import java.util.Date;

public class Ingresso implements RelaDeRece{
    private Date dataVenda;
    //preço do ingresso normal
    private float preco;
    protected String tipo;

    @Override
    public String toString(){
        return dataVenda.toString()+ "\n" + preco + "\n" + tipo + "\n";
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public double ReceiTot() {
        return preco;
    }

    @Override
    public void extrato() {
        toString();
    }
}
