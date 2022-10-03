public class Professor extends Usuario{
    private String nome;
    private String setor;

    Professor(String nome, String setor){
        this.nome = nome;
        this.setor = setor;
    }

    public void reservarSala(String data, String horario, Sala sala, int duracao){
        sala.reservarSala(this.nome, this.setor, data, horario, duracao);
    }
}
