import javax.swing.*;
import java.util.Date;

public abstract class Sala {
    public static int numTotalSalas = 12;
    public static int numSalasRegistradas = 0;
    protected int numSala;
    protected Reserva[] listaReservas;
    protected int numReservas = 0;
    private int capacidade;
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
            //Se não existir uma reserva no horário informado a reserva é criada
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
    public abstract String listarReservas();

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
