import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Sala {
    public static int numTotalSalas = 12;
    public static int numSalasRegistradas = 0;
    protected int numSala;
    protected Reserva[] listaReservas;
    protected int numReservas = 0;
    private int capacidade;
    private boolean disponivel;
    private char tipo;

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

    Sala(int numSala, int capacidade, boolean disponivel, char tipo){
        this.numSala = numSala;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        this.tipo = tipo;
        listaReservas = new Reserva[Reserva.numMaxReservas];
        Sala.numSalasRegistradas++;
    }

    //Função usada para criar uma reserva na sala
    public void reservarSala(Date data, Date horarioInicio, Date horarioFim, String nomeProfessor, String setor){

        //Verifica se a sala está disponível para reserva
        if(this.disponivel && this.numReservas < Reserva.numMaxReservas){
            boolean disponivel = true;

            for(int i = 0; i < this.numReservas; i++){
                //Verifica se já não existe uma reserva no horário solicitado
                if(this.listaReservas[i].getData().equals(data)){

                    long inicioAtual = this.listaReservas[i].getHorarioInicio().getTime();
                    long fimAtual = this.listaReservas[i].getHorarioFim().getTime();
                    long inicioReserva = horarioInicio.getTime();
                    long fimReserva = horarioFim.getTime();

                    if((inicioReserva >= inicioAtual && inicioReserva <= fimAtual) || //Reserva que começa durante uma reserva ja feita
                            (fimReserva >= inicioAtual && fimReserva <= fimAtual) || //Reserva que termina durante uma reserva ja feita
                            (inicioAtual >= inicioReserva && inicioAtual <= fimReserva)){ //Reserva que começa antes e termina depois de uma reserva ja feita
                        JOptionPane.showMessageDialog(null, "Já existe uma reserva nesse intervalo de horário");
                        disponivel = false;
                    }
                }
            }
            //Se não existir uma reserva na data e horário informados a reserva é criada
            if(disponivel){
                listaReservas[this.numReservas] = new Reserva(data, horarioInicio, horarioFim, nomeProfessor, setor);
                this.numReservas++;
                JOptionPane.showMessageDialog(null, "Reserva feita com sucesso");
                ordenarReservas(listaReservas);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Sala indisponível para reserva");
        }
    }

    //Função usada para listar as reservas da sala
    public  String listarReservas(){
        String strReservas;

        //Verifica se existe alguma reserva na sala
        if(this.numReservas > 0) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MMM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            if(this.tipo == 's')
                strReservas = "Reservas da sala " + this.numSala + "\n";
            else
                strReservas = "Reservas do Laboratório " + this.numSala + "\n";

            for (Reserva reserva : this.listaReservas) {
                if (reserva == null) {
                    break;
                }

                String nomeProfessor = reserva.getNomeProfessor();
                String setorProfessor = reserva.getSetorProfessor();
                String dataRerva = sdfData.format(reserva.getData());
                String horaInicio = sdfHora.format(reserva.getHorarioInicio());
                String horaFim = sdfHora.format(reserva.getHorarioFim());

                strReservas += "\nProfessor: " + nomeProfessor +"\nSetor: " + setorProfessor +
                        "\nData: " + dataRerva + "\nHorário: " + horaInicio + " às " + horaFim + "\n";
            }
        }
        else{
            strReservas =  "Nenhuma reserva feita na sala ";
        }
        return strReservas;
    }

    //Função usada para ordernas as reservas
    public void ordenarReservas(Reserva[] reservas) {
        for(int i = 0; i < this.numReservas - 1 ; i++) {
            boolean estaOrdenado = true;

            //Ordena as reservas pela data
            for(int j = 0; j < this.numReservas - 1 - i; j++) {
                long reservaJ = reservas[j].getData().getTime();
                long reservaJ1 = reservas[j + 1].getData().getTime();

                if(reservaJ > reservaJ1) {
                    Reserva aux = reservas[j];
                    reservas[j] = reservas[j + 1];
                    reservas[j + 1] = aux;
                    estaOrdenado = false;
                }
            }

            //Se existir duas reservas na mesma data elas são ordenadas pelo horário
            for(int j = 0; j < this.numReservas - 1 - i; j++) {
                long dataReservaJ = reservas[j].getData().getTime();
                long horaReservaJ = reservas[j].getHorarioInicio().getTime();
                long dataReservaJ1 = reservas[j + 1].getData().getTime();
                long horaReservaJ1 = reservas[j + 1].getHorarioInicio().getTime();

                if(dataReservaJ == dataReservaJ1 && horaReservaJ > horaReservaJ1) {
                    Reserva aux = reservas[j];
                    reservas[j] = reservas[j + 1];
                    reservas[j + 1] = aux;
                    estaOrdenado = false;
                }
            }

            if(estaOrdenado) {
                break;
            }
        }
    }

    public boolean autenticar(int numSala){
        return this.numSala == numSala;
    }
}