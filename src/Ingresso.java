import java.util.Date;

public class Ingresso implements RelaDeRece{
    Date dataVenda;
    //preço do ingresso normal
    float preco;
    String tipo;

    @Override
    public String toString(){
        return dataVenda.toString()+ " " + preco + " " + tipo + "\n";
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
