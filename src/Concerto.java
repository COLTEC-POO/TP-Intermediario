public class Concerto extends Evento {
    public Concerto() {
        //define a quantidade de ingrssos disponiveis para venda
        QuaIn = 150;
    }
    private Ingresso[] IngressoCon = new Ingresso[QuaIn];

    @Override
    public boolean VerificacaoDosIngressos() {
        int NumVip = 0;
        for(Ingresso atual : this.IngressoCon)
            if(atual != null)
                //retorna false caso mais que 10% dos ingressos sejam Vip
                if(atual instanceof InGreVip && NumVip <=(int) (QuaIn * 10)/100)
                    NumVip++;
                else
                    return false;
        return true;
    }
    @Override
    public double ReceiTot() {
        double total = 0;
        for(Ingresso atual : this.IngressoCon){
            if(atual!= null)
                total += atual.getPreco();
        }
        return total;
    }
    @Override
    public void extrato(){
        for(Ingresso atual : this.IngressoCon){
            if(atual!= null)
                atual.toString();
        }
    }
}
