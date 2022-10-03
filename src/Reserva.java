public class Reserva {
    public static int numMaxReservas = 20;
    private int numSala;
    private String horario;
    private String data;
    private int duracaoReserva;
    private String nomeProfessor;
    private String setorProfessor;

    Reserva(int numSala, String horario, String data, int duracaoReserva, String nomeProfessor, String setorProfessor){
        this.numSala = numSala;
        this.horario = horario;
        this.data = data;
        this.duracaoReserva = duracaoReserva;
        this.nomeProfessor = nomeProfessor;
        this.setorProfessor = setorProfessor;
    }

    //Getters and Setters

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDuracaoReserva() {
        return duracaoReserva;
    }

    public void setDuracaoReserva(int duracaoReserva) {
        this.duracaoReserva = duracaoReserva;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getSetorProfessor() {
        return setorProfessor;
    }

    public void setSetorProfessor(String setorProfessor) {
        this.setorProfessor = setorProfessor;
    }
}
