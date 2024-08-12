import javax.swing.*;

public abstract class Evento implements RelaDeRece {
    protected String nome;
    protected String data = " ";
    protected String hora;
    protected String local;
    protected String Tipo;
    protected String Orcamento;
    protected Ingresso[] vetorIngressos;
    protected int ingressosVendidos = 0;
    protected int ingressosPadrao = 0;
    protected int ingressosMeia = 0;
    protected int ingressosVip = 0;

    public String getOrcamento() {
        return Orcamento;
    }

    public void setOrcamento(String orcamento) {
        Orcamento = orcamento;
    }

    //variavel que representa a quantidade de ingressos
    protected int QuanIn;

    protected double PreIn;
    public abstract boolean VerificacaoDosIngressos();
    @Override
    public String toString(){
        return this.nome + "\n" + this.data + "\n" +
                this.hora + "\n" + this.local + "\n" +
                this.QuanIn + "\n" + this.Tipo + "\n";
    }
    public void imprimirIngressos(){
        for (Ingresso ingresso : vetorIngressos){
            if (ingresso != null){
                String[] ok = ingresso.extrato();
                String mes = "";
                for (int f = 0; f< ok.length;f++) {
                    mes = mes + ok[f] + "\n";
                }
                JOptionPane.showMessageDialog(null,mes);
            }
        }
    }
    public abstract boolean verificaIngresso();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {Tipo = tipo;}

    public double getPreIn() {
        return PreIn;
    }

    public void setPreIn(double preIn) {
        PreIn = preIn;
    }

    public int getQuanIn() {
        QuanIn = ingressosVendidos;
        return QuanIn;
    }

    public void setQuanIn(int quanIn) {
        QuanIn = quanIn;
    }
}
