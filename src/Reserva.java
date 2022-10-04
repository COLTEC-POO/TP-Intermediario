import java.util.Date;

public class Reserva {
    public static int numMaxReservas = 20;
    private int numSala;
    private Date horario;
    private Date data;
    private int duracaoReserva;
    private String nomeProfessor;
    private String setorProfessor;

    Reserva(int numSala, Date horario, Date data, int duracaoReserva, String nomeProfessor, String setorProfessor){
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

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
