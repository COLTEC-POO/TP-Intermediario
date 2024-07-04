public abstract class Evento implements RelaDeRece {
    protected String nome;
    protected String data;
    protected String hora;
    protected String local;
    //variavel que representa a quantidade de ingressos
    protected int QuaIn;
    //variavel que representa o preço dos ingressos
    protected int InPre;
    public abstract boolean VerificacaoDosIngressos();
}
