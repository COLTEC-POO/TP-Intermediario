import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Sala {
    public static int numTotalSalas = 5;
    public static int numSalasRegistradas = 0;
    private int numSala;
    private int capacidade;
    private Reserva listaReservas[] = new Reserva[Reserva.numMaxReservas];
    private int numReservas = 0;
    private boolean disponivel;

    //Getters and Setters

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Reserva[] getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Reserva[] listaReservas) {
        this.listaReservas = listaReservas;
    }

    public int getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(int numReservas) {
        this.numReservas = numReservas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //Métodos

    Sala(int numSala, int capacidade, boolean disponivel){
        this.numSala = numSala;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        Sala.numSalasRegistradas++;
    }

    public void reservarSala(String nomeProfessor, String setor, Date data, Date horarioInicio, Date horarioFim){
        listaReservas[this.numReservas] = new Reserva(this.numSala, horarioInicio, data, horarioFim, nomeProfessor, setor);
        this.numReservas++;
    }
    public String listarReservas(){
        String strReservas;
        if(this.numReservas > 0) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MMM/yy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            strReservas = "Reservas da sala " + this.numSala + "\n";
            for (Reserva reserva : this.listaReservas) {
                if (reserva == null) {
                    break;
                }
                strReservas += reserva.getNomeProfessor()+ ", " + sdfData.format(reserva.getData() ) + " de " + sdfHora.format(reserva.getHorario()) + " as " + sdfHora.format(reserva.getDuracaoReserva()) + "\n";
            }
        }
        else{
            strReservas =  "Nenhuma reserva feita na sala ";
        }
        return strReservas;
    }

    public boolean autenticar(int numSala){
        if(this.numSala == numSala){
            return true;
        }
        else return false;
    }
}
