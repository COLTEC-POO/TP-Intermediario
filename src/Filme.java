public class Filme extends Evento{
    public Filme() {
        //define a quantidade de ingrssos disponiveis para venda
        QuaIn = 200;
    }
    private Ingresso[] IngressoFilm = new Ingresso[QuaIn];

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
                total += atual.preco;
        }
        return total;
    }
    @Override
    public void extrato(){
        for(Ingresso atual : this.IngressoFilm){
            if(atual!= null)
                atual.toString();
        }
    }
}
