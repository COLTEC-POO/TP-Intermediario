import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Sala[] salas = new Sala[Sala.numTotalSalas];
        salas[Sala.numSalasRegistradas] = new SalaConvencional(2, 30, true);
        salas[Sala.numSalasRegistradas] = new Laboratorio(4, 25, true);

        salas[Sala.numSalasRegistradas] = new SalaConvencional(6, 30, true);
        salas[Sala.numSalasRegistradas] = new Laboratorio(8, 25, true);

        salas[Sala.numSalasRegistradas] = new SalaConvencional(10, 30, true);
        salas[Sala.numSalasRegistradas] = new Laboratorio(12, 25, true);

        salas[Sala.numSalasRegistradas] = new SalaConvencional(14, 30, true);
        salas[Sala.numSalasRegistradas] = new Laboratorio(16, 25, true);

        salas[Sala.numSalasRegistradas] = new SalaConvencional(18, 30, true);
        salas[Sala.numSalasRegistradas] = new Laboratorio(20, 25, true);

        salas[Sala.numSalasRegistradas] = new SalaConvencional(1, 30, false);
        salas[Sala.numSalasRegistradas] = new Laboratorio(3, 25, false);

        ordenaSalas(salas);

        int[] numSalas = new int[Sala.numSalasRegistradas];
        for(int i = 0; i < Sala.numSalasRegistradas; i++){
            numSalas[i] = salas[i].getNumSala();
        }
        Arrays.sort(numSalas);
        String[] opcoesSalas = new String[Sala.numSalasRegistradas];
        for(int i = 0; i < Sala.numSalasRegistradas; i++){
            opcoesSalas[i] = String.valueOf(numSalas[i]);
        }

        int numSala;
        int sala;

        Professor[] professores = new Professor[Professor.numMaxProfessores] ;
        professores[Professor.numProfessores] = new Professor("João", "Informática", "12345");
        professores[Professor.numProfessores] = new Professor("Leandro", "Informática", "123");
        professores[Professor.numProfessores] = new Professor("Fantini", "Eletrônica", "321");
        professores[Professor.numProfessores] = new Professor("Virgínia", "Diretoria", "1425");
        professores[Professor.numProfessores] = new Professor("Honda", "Eletrônica", "456");

        String[] opcoesProfessores = new String[Professor.numProfessores];

        for(int i = 0; i < Professor.numProfessores; i++){
            opcoesProfessores[i] = professores[i].getNome();
        }
        Arrays.sort(opcoesProfessores);

        String dataReserva;
        Date data;
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");

        String horaReserva;
        String horaFimReserva;
        Date horaInicio;
        Date horaFim;
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

        char selecao;
        String[] opcoes = {
                "0 - Sair do programa",
                "1 - Listar salas disponíveis",
                "2 - Listar todas as reservas",
                "3 - Listar reserva de uma sala",
                "4 - Reservar uma sala"};

        do{
            selecao = JOptionPane.showInputDialog(null,
                    "Qual opção deseja?",
                    "Escolha uma opção",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    "").toString().charAt(0);

            switch (selecao) {
                case '0':
                    JOptionPane.showMessageDialog(null, "Fim do programa!");
                    break;

                case '1':
                    listarSalas(salas);
                    break;

                case '2':
                    listarReservas(salas);
                    break;

                case '3':
                    numSala = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Número da sala: ",
                            "Informe o número da sala", JOptionPane.PLAIN_MESSAGE, null, opcoesSalas, ""));

                    sala = retornaPosicaoSala(salas, numSala);

                    //Verifica se a sala escolhida está registrada
                    if(sala >= 0) {
                        listarReservaSala(salas[sala]);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Sala não encontrada");
                    }
                    break;

                case '4':
                    String nome = JOptionPane.showInputDialog(null,
                            "Nome:",
                            "Informe o professor responsável",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoesProfessores,
                            "").toString();

                    String senha = JOptionPane.showInputDialog(null, "Senha:",
                            "Informe a senha do professor", JOptionPane.PLAIN_MESSAGE);

                    //Verifica se a senha do professor foi inserida corretamente
                    int professor = retornaPosicaoProfessor(professores, nome, senha);
                    if(professor >= 0) {
                        numSala = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Número da sala: ",
                                "Informe o número da sala", JOptionPane.PLAIN_MESSAGE, null, opcoesSalas, ""));

                        sala = retornaPosicaoSala(salas, numSala);

                        //Verifica se a sala escolhida está registrada
                        if(sala == -1) {
                            JOptionPane.showMessageDialog(null, "Sala não encontrada");
                            break;
                        }

                        dataReserva = JOptionPane.showInputDialog("Informe a data da reserva (ex: 03/10/2022):");
                        horaReserva = JOptionPane.showInputDialog("Informe a hora de início da reserva (ex: 15:30):");
                        horaFimReserva = JOptionPane.showInputDialog("Informe a hora de fim da reserva (ex: 17:30):");

                        try {
                            Date atual = new Date();

                            data = sdfData.parse(dataReserva);
                            horaInicio = sdfHora.parse(horaReserva);
                            horaFim = sdfHora.parse(horaFimReserva);

                            long horarioInicio = horaInicio.getTime();
                            long horarioFim = horaFim.getTime();

                            long dataHoraReserva = data.getTime()+horaInicio.getTime()-10800000;
                            long dataHoraAtual = atual.getTime();

                            //Verifica se o horário de início não ocorre depois do horário de fim
                            //ou se a data e hora da reserva já passou
                            if(horarioInicio > horarioFim || dataHoraReserva < dataHoraAtual){
                                throw new Exception();
                            }

                            int confirmar = JOptionPane.showConfirmDialog(null,"Confirmar reserva?\nSala "+
                                    numSala + "\nDia " + sdfData.format(data) + " de " + sdfHora.format(horaInicio) + " à " + sdfHora.format(horaFim));

                            //Verifica se a reserva foi confirmada
                            if(confirmar == 0) {
                                professores[professor].reservarSala(salas[sala], data, horaInicio, horaFim);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Reserva cancelada");
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Data ou hora inválida");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Senha incorreta");
                    }
                    break;
            }
        }while(selecao != '0');
    }

    //Função usada para listar todas as salas disponíveis
    private static void listarSalas(Sala[] salas){
        String strSalas = "Salas disponíveis\n\n";

        for(int i = 0; i < Sala.numSalasRegistradas; i++){
            if(salas[i].isDisponivel() && salas[i].getNumReservas() < Reserva.numMaxReservas){
                if(salas[i] instanceof Laboratorio) {
                    strSalas += ("Laboratorio " + salas[i].getNumSala() + "\n");
                }
                else{
                    strSalas += ("Sala " + salas[i].getNumSala() + "\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, strSalas);
    }

    //Função usada para listar todas as reservas
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

    //Função usada para listar a reserva de uma sala
    private static void listarReservaSala(Sala sala){
        String strReserva = sala.listarReservas();
        JOptionPane.showMessageDialog(null, strReserva);
    }

    //Função usada para ordenar as salas
    private static void ordenaSalas(Sala[] salas) {
        for(int i = 0; i < Sala.numSalasRegistradas - 1 ; i++) {
            boolean estaOrdenado = true;

            //Ordena as salas pelo tipo da sala
            for(int j = 0; j < Sala.numSalasRegistradas - 1 - i; j++) {
                if(salas[j] instanceof Laboratorio && salas[j + 1] instanceof SalaConvencional) {
                    Sala aux = salas[j];
                    salas[j] = salas[j + 1];
                    salas[j + 1] = aux;
                    estaOrdenado = false;
                }
            }

            //Orderna as salas pelo número da sala
            for(int j = 0; j < Sala.numSalasRegistradas - 1 - i; j++) {

                String classeJ = String.valueOf(salas[j].getClass());
                String classeJ1 = String.valueOf(salas[j+1].getClass());
                int numSalaJ = salas[j].getNumSala();
                int numSalaJ1 = salas[j + 1].getNumSala();

                if(classeJ.equals(classeJ1) && numSalaJ > numSalaJ1) {
                    Sala aux = salas[j];
                    salas[j] = salas[j + 1];
                    salas[j + 1] = aux;
                    estaOrdenado = false;
                }
            }

            if(estaOrdenado) {
                break;
            }
        }
    }

    //Função usada para retornar o índice de uma sala
    private static int retornaPosicaoSala(Sala[] salas, int numSala){
        for(int i = 0; i < Sala.numSalasRegistradas; i++){
            if(salas[i].autenticar(numSala)){
                return i;
            }
        }
        return -1;
    }

    //Função usada para retornar o índice de um professor
    private static int retornaPosicaoProfessor(Professor[] professores, String nome, String senha){
        for(int i = 0; i < Professor.numProfessores; i++){
            if(professores[i].autenticar(nome, senha)){
                return i;
            }
        }
        return -1;
    }
}