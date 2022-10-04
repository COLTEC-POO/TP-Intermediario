import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Sala salas[] = new Sala[Sala.numTotalSalas];
        salas[Sala.numSalasRegistradas] = new SalaConvencional(14, 30, true);
        salas[Sala.numSalasRegistradas] = new Laboratorio(8, 25, true);

        Professor professores[] = new Professor[Professor.numMaxProfessores] ;
        professores[Professor.numProfessores] = new Professor("João", "Computação", "12345");

        String dataReserva;
        Date data;
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");

        String horaReserva;
        Date hora;
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

        char selecao = 'a';
        Object[] opcoes = {
                "0 - Sair do programa",
                "1 - Listar salas disponíveis",
                "2 - Listar reservas",
                "3 - Listar reserva de uma sala",
                "4 - Reservar uma sala"};

        while(selecao != '0') {

            selecao = JOptionPane.showInputDialog(null,
                    "Qual opção deseja?",
                    "Escolha uma opção",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    "").toString().charAt(0);

            switch (selecao) {
                case '0':
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o programa!");
                    break;

                case '1':
                    listarSalas(salas);
                    break;

                case '2':
                    listarReservas(salas);
                    break;

                case '3':
                    listarReservaSala(salas[0]);
                    break;

                case '4':
                    int numProfessor = -1;
                    String nome = JOptionPane.showInputDialog(null, "Nome:", "Informe o nome do professor", JOptionPane.PLAIN_MESSAGE);
                    String senha = JOptionPane.showInputDialog(null, "Senha:", "Informe a senha do professor", JOptionPane.PLAIN_MESSAGE);

                    for(int i = 0; i < Professor.numProfessores; i++){
                        if(professores[i].autenticar(nome, senha)){
                            numProfessor = i;
                        }
                    }
                    if(numProfessor >= 0) {
                        dataReserva = JOptionPane.showInputDialog("Informe a data da reserva (ex: 03/10/2022):");
                        horaReserva = JOptionPane.showInputDialog("Informe a hora da reserva (ex: 15:30):");

                        try {
                            data = sdfData.parse(dataReserva);
                            hora = sdfHora.parse(horaReserva);

                            JOptionPane.showMessageDialog(null, "Dia " + sdfData.format(data) + " as " + sdfHora.format(hora));

                            professores[numProfessor].reservarSala(data, hora, salas[0], 3);

                        } catch (ParseException e) {
                            JOptionPane.showMessageDialog(null, "Data ou hora inválida");
                        }
                    }
                    break;
            }
        }
    }

    private static void listarSalas(Sala[] salas){
        String strSalas = "Salas disponíveis\n\n";
        for(int i = 0; i < Sala.numSalasRegistradas; i++){
            if(salas[i].isDisponivel() && salas[i].getNumReservas() < Reserva.numMaxReservas){
                strSalas += ("Sala " + salas[i].getNumSala() + "\n");
            }
        }
        JOptionPane.showMessageDialog(null, strSalas);
    }

    private static void listarReservas(Sala[] salas){
        String strReservas = "Lista de salas reservadas\n\n";
        for(Sala sala: salas){
            if (sala == null) {
                break;
            }
            if(sala.getNumReservas() > 0){
                strReservas += sala.listarReservas() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, strReservas);

    }

    private static void listarReservaSala(Sala sala){
        String strReserva = sala.listarReservas();
        JOptionPane.showMessageDialog(null, strReserva);
    }
}
