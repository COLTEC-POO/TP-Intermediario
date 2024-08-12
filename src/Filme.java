import java.io.Serializable;
import java.util.Arrays;

public class Filme extends Evento implements Serializable {
    public Filme() {
        //define a quantidade de ingrssos disponiveis para venda
        QuanIn = 200;
        vetorIngressos = new Ingresso[QuanIn];
        setTipo("Filme");
    }
    private Ingresso[] IngressoFilm = new Ingresso[QuanIn];

    @Override
    public boolean VerificacaoDosIngressos() {
        for(Ingresso atual : this.IngressoFilm)
            if(atual != null)
                //retorna false caso haja ingressos Vip
                if(atual instanceof InGreVip )
                    return false;
        return true;
    }

    @Override
    public double ReceiTot() {
        double total = 0;
        for(Ingresso atual : this.IngressoFilm){
            if(atual!= null)
                total += atual.getPreco();
        }
        return total;
    }
    @Override
    public String[] extrato(){
        String[] extratoComp = new String[3];
        int i = 0;
        for(Ingresso atual : this.IngressoFilm){
            i++;
            if(atual!= null)
                extratoComp[i] = atual.toString();
            extratoComp = Arrays.copyOf(extratoComp,(i + 1));

        }return extratoComp;
    }
    public boolean verificaIngresso(){
        return true;
    }

}
