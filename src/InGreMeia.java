import java.util.Date;

public class InGreMeia extends Ingresso{
    public InGreMeia(float prec){
        dataVenda = new Date();
        this.preco = prec;
        setPreco(getPreco() / 2);
        tipo = "Meia";
        System.out.println("Ingresso meia comprado");
    }
}
