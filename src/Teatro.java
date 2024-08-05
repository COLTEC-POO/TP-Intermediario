public class Teatro extends Evento{
    public Teatro() {
        //define a quantidade de ingrssos disponiveis para venda
        QuanIn = 250;
        setTipo("Teatro");
    }
    protected Ingresso[] IngressoTea = new Ingresso[QuanIn];

    @Override
    public boolean VerificacaoDosIngressos() {
        int NumVip = 0;
        for(Ingresso atual : this.IngressoTea)
            if(atual != null)
                //retorna false caso mais que 20% dos ingressos sejam Vip
                if(atual instanceof InGreVip && NumVip <=(int) (QuanIn * 20)/100)
                    NumVip++;
                else
                    return false;
        return true;
    }
    @Override
    public double ReceiTot() {
        double total = 0;
        for(Ingresso atual : this.IngressoTea){
            if(atual!= null)
                total += atual.getPreco();
        }
        return total;
    }
    @Override
    public void extrato(){
        for(Ingresso atual : this.IngressoTea){
            if(atual!= null)
                atual.toString();
        }
    }
}
