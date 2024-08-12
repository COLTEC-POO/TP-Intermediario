import java.util.Date;

public class InGreNormal extends Ingresso{
    public InGreNormal(float prec){
        dataVenda = new Date();
        this.preco = prec;
        setPreco(getPreco());
        tipo = "Normal";
        System.out.println("Ingresso normal comprado");

    }
}
