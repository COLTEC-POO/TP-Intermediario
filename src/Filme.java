public class Filme extends Evento{
    public Filme() {
        //define a quantidade de ingrssos disponiveis para venda
        QuanIn = 200;
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
    public void extrato(){
        for(Ingresso atual : this.IngressoFilm){
            if(atual!= null)
                atual.toString();
        }
    }
}
