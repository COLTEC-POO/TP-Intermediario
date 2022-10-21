import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Salas {

    private int numeroSala;
    private int capacidade = 20;
    private List<Reservas> reservas = new ArrayList<Reservas>();
    Reservas reserva;
    public int numReservas;

    public int getNumeroSala() {
        return numeroSala;
    }

    public Salas(int numeroSala, int capacidade) {
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
        numReservas = 0;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Salas(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public void fazerReserva(String nome, String setor, String data) {

        reserva = new Reservas(nome, setor, data);
        this.reservas.add(reserva);
        this.numReservas++;
    }

    public void listarReservas() {

        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há nenhuma reserva feita!");
            System.exit(0);
        } else {
            for (Reservas r : reservas) {
                JOptionPane.showMessageDialog(null, "Sala: " + this.numeroSala + "\n" + "Nome: " + r.getNome()
                        + "\n" + "Setor: " + r.getSetor() + "\n" + "Reserva: " + r.getData());

            }
        }
    }
}