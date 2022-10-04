import java.util.Date;

public class Reserva {
    public static int numMaxReservas = 20;
    private int numSala;
    private Date data;
    private Date horarioInicio;
    private Date horarioFim;
    private String nomeProfessor;
    private String setorProfessor;

    Reserva(int numSala, Date horarioInicio, Date data, Date horarioFim, String nomeProfessor, String setorProfessor){
        this.numSala = numSala;
        this.horarioInicio = horarioInicio;
        this.data = data;
        this.horarioFim = horarioFim;
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
        return horarioInicio;
    }

    public void setHorario(Date horario) {
        this.horarioInicio = horario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDuracaoReserva() {
        return horarioFim;
    }

    public void setDuracaoReserva(Date duracaoReserva) {
        this.horarioFim = duracaoReserva;
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
