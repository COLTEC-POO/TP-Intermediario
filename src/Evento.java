public abstract class Evento implements RelaDeRece {
    protected String nome;
    protected String data = " ";
    protected String hora;
    protected String local;
    protected String Tipo;
    protected int id;
    //variavel que representa a quantidade de ingressos
    protected int QuanIn;

    protected double PreIn;
    public abstract boolean VerificacaoDosIngressos();
    @Override
    public String toString(){
        return this.nome + "\n" + this.data + "\n" +
                this.hora + "\n" + this.local + "\n" +
                this.QuanIn + "\n" + this.id + "\n" +
                this.Tipo + "\n";
    }

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

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public double getPreIn() {
        return PreIn;
    }

    public void setPreIn(double preIn) {
        PreIn = preIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuanIn() {
        return QuanIn;
    }

    public void setQuanIn(int quanIn) {
        QuanIn = quanIn;
    }
}
