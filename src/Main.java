import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Sala salas[] = new Sala[Sala.numTotalSalas];

        Usuario user = new Usuario();
        Usuario professor = new Professor("João", "Computação");

        salas[Sala.numSalasRegistradas] = new Sala(14, 30, 'c', true);

        user.listarSalas(salas);

        professor.reservarSala("30/10", "14:00", salas[0], 3);

        JOptionPane.showMessageDialog(null, salas[0].listarReservas());

        user.listarReservas(salas);

        user.listarReserva(salas[0]);
    }
}
