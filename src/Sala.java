import javax.swing.*;

public class Sala {
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

    public void reservarSala(String nomeProfessor, String setor, String data, String horario, int duracao){
        listaReservas[this.numReservas] = new Reserva(this.numSala, horario, data, duracao, nomeProfessor, setor);
        this.numReservas++;
    }
    public String listarReservas(){
        String strReservas;
        if(this.numReservas > 0) {
            strReservas = "Reservas da sala " + this.numSala + "\n";
            for (Reserva reserva : this.listaReservas) {
                if (reserva == null) {
                    break;
                }
                strReservas += reserva.getNomeProfessor()+ ", " + reserva.getData() + ", " + reserva.getHorario() + " por " + reserva.getDuracaoReserva() + " horas\n";
            }
        }
        else{
            strReservas =  "Nenhuma reserva feita na sala ";
        }
        return strReservas;
    }
}
