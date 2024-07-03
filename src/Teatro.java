public class Teatro extends Evento{
    public Teatro() {
        //define a quantidade de ingrssos disponiveis para venda
        QuaIn = 250;
    }
    protected Ingresso[] IngressoTea = new Ingresso[QuaIn];

    @Override
    public boolean VerificacaoDosIngressos() {
        int NumVip = 0;
        for(Ingresso atual : this.IngressoTea)
            if(atual != null)
                //retorna false caso mais que 20% dos ingressos sejam Vip
                if(atual instanceof InGreVip && NumVip <=(int) (QuaIn * 20)/100)
                    NumVip++;
                else
                    return false;
        return true;
    }
}
