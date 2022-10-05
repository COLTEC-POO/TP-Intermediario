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

    public int getNumReservas() {
        return numReservas;
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

    public void reservarSala(Date data, Date horarioInicio, Date horarioFim, String nomeProfessor, String setor){
        if(this.disponivel && this.numReservas < Reserva.numMaxReservas){
            boolean disponivel = true;

            for(int i = 0; i < this.numReservas; i++){

                if(this.listaReservas[i].getData().equals(data)){

                    long inicioAtual = this.listaReservas[i].getHorarioInicio().getTime();
                    long fimAtual = this.listaReservas[i].getHorarioFim().getTime();
                    long inicio = horarioInicio.getTime();
                    long fim = horarioFim.getTime();

                    if((inicio >= inicioAtual && horarioInicio.getTime() <= fimAtual) ||
                            (fim >= inicioAtual && fim <= fimAtual) ||
                            (inicioAtual >= inicio && inicioAtual <= fim)){
                        JOptionPane.showMessageDialog(null, "Já existe uma reserva nesse intervalo de horário");
                        disponivel = false;
                    }
                }
            }
            if(disponivel){
                listaReservas[this.numReservas] = new Reserva(this.numSala, data, horarioInicio, horarioFim, nomeProfessor, setor);
                this.numReservas++;
                JOptionPane.showMessageDialog(null, "Reserva feita com sucesso");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Sala indisponível para reserva");
        }
    }
    public String listarReservas(){
        String strReservas;
        if(this.numReservas > 0) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MMM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            strReservas = "Reservas da sala " + this.numSala + "\n";
            for (Reserva reserva : this.listaReservas) {
                if (reserva == null) {
                    break;
                }
                strReservas += "\nProfessor: " + reserva.getNomeProfessor()+"\nSetor: " + reserva.getSetorProfessor() +
                        "\nData: " + sdfData.format(reserva.getData() ) + "\nHorário: " + sdfHora.format(reserva.getHorarioInicio()) +
                        " às " + sdfHora.format(reserva.getHorarioFim()) + "\n";
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
