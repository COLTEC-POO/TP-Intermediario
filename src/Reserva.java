import java.util.Date;

public class Reserva {
    public static int numMaxReservas = 20;
    private Date data;
    private Date horarioInicio;
    private Date horarioFim;
    private String nomeProfessor;
    private String setorProfessor;

    Reserva(Date data, Date horarioInicio, Date horarioFim, String nomeProfessor, String setorProfessor){
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.nomeProfessor = nomeProfessor;
        this.setorProfessor = setorProfessor;
    }

    //Getters and Setters

    public Date getData() {
        return data;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public Date getHorarioFim() {
        return horarioFim;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getSetorProfessor() {
        return setorProfessor;
    }

}
