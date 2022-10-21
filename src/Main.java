import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // Salas de Laboratório

        Salas Azul = new Laboratorio(1, 20);
        Salas Vermelho = new Laboratorio(2, 20);
        Salas Amarelo = new Laboratorio(3, 20);

        // Salas Convencionais

        Salas SalaA = new Convencional(10, 20);
        Salas SalaB = new Convencional(11, 20);
        Salas SalaC = new Convencional(12, 20);

        Azul.fazerReserva("Joao", "Tecnologia", "11/02/2022 10:10");
        Amarelo.fazerReserva("Jessica", "Tecnologia", "02/01/2022 15:10");
        Vermelho.fazerReserva("Maria", "Biologia", "09/12/2022 20:10");

        UIManager.put("OptionPane.minimumSize", new Dimension(500, 200));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SanSerif", Font.BOLD, 18)));

        JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema de Reservas!");

        Object[] opcoes = {"usuario", "professor"};
        String op = (String) JOptionPane.showInputDialog(null, "Primeiramente, se identifique:",
                "Escolha o identificador", JOptionPane.PLAIN_MESSAGE, null, opcoes, "usuario");

        if (op.equals("usuario")) {

            Object[] opcoesUsuario = {"Ver_Salas", "Ver_Reservas"};
            String opu = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:",
                    "Selecione uma opção", JOptionPane.PLAIN_MESSAGE, null, opcoesUsuario, "Ver_Salas");

            if (opu == "Ver_Salas") {

                JOptionPane.showMessageDialog(null, "\n     Laboratórios Disponíveis     \n" +
                        "Sala: " + Azul.getNumeroSala() + "\n" + "Sala: " + Vermelho.getNumeroSala() + "\n" + "Sala: " + Amarelo.getNumeroSala() + "\n" +
                        "\n     Salas Convencionais Disponíveis     \n" +"Sala: " + SalaA.getNumeroSala() + "\n" + "Sala: " + SalaB.getNumeroSala() +
                        "\n" + "Sala: " + SalaC.getNumeroSala());
            }

            if (opu == "Ver_Reservas") {

                Azul.listarReservas();
                Vermelho.listarReservas();
                Amarelo.listarReservas();
                SalaA.listarReservas();
                SalaB.listarReservas();
                SalaC.listarReservas();
            }
        }

        if (op.equals("professor")) {

            Object[] opcoesProfessor = {"Ver_Salas", "Ver_Reservas", "Reservar_Sala"};
            String opr = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:",
                    "Selecione uma opção", JOptionPane.PLAIN_MESSAGE, null, opcoesProfessor, "Ver Salas");

            if(opr.equals("Ver_Salas")){

                JOptionPane.showMessageDialog(null, "\n     Laboratórios Disponíveis     \n" +
                        "Sala: " + Azul.getNumeroSala() + "\n" + "Sala: " + Vermelho.getNumeroSala() + "\n" + "Sala: " + Amarelo.getNumeroSala() + "\n" +
                        "\n     Salas Convencionais Disponíveis     \n" +"Sala: " + SalaA.getNumeroSala() + "\n" + "Sala: " + SalaB.getNumeroSala() +
                        "\n" + "Sala: " + SalaC.getNumeroSala());
            }

            if(opr.equals("Ver_Reservas")){

                Azul.listarReservas();
                Vermelho.listarReservas();
                Amarelo.listarReservas();
                SalaA.listarReservas();
                SalaB.listarReservas();
                SalaC.listarReservas();

            }

            if (opr.equals("Reservar_Sala")) {

                Object[] salas = {"Convencional", "Laboratorio"};
                String ops = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:",
                        "Selecione uma sala", JOptionPane.PLAIN_MESSAGE, null, salas, "Convencional");

                if (ops.equals("Laboratorio")) {

                    Object[] sala_lab = {"Azul", "Vermelho","Amarelo"};
                    String oplab = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:",
                            "Selecione um laboratorio", JOptionPane.PLAIN_MESSAGE, null, sala_lab, "Azul");

                    if(oplab.equals("Azul")){

                        if (Azul.numReservas < 20) {

                            JOptionPane.showMessageDialog(null, "Esta sala ainda tem " +
                                    (20 - Azul.numReservas) + " reservas disponíveis");

                            String nome = JOptionPane.showInputDialog("Qual o seu nome?");
                            String setor = JOptionPane.showInputDialog("Qual o setor?");
                            String data = JOptionPane.showInputDialog("Insira a data e o horário da reserva (dd/MM/yyyy HH:mm): ");

                            Azul.fazerReserva(nome, setor, data);
                            JOptionPane.showMessageDialog(null, "Reserva feita com sucesso!");

                        }

                        else{
                            JOptionPane.showMessageDialog(null, "Não há mais reservas disponíveis para esta sala","ERRO", JOptionPane.ERROR_MESSAGE);

                        }
                    }

                    if(oplab.equals("Vermelho")) {

                        if (Vermelho.numReservas < 20) {

                            JOptionPane.showMessageDialog(null, "Esta sala ainda tem " +
                                    (20 - Vermelho.numReservas) + " reservas disponíveis");

                            String nome = JOptionPane.showInputDialog("Qual o seu nome?");
                            String setor = JOptionPane.showInputDialog("Qual o setor?");
                            String data = JOptionPane.showInputDialog("Insira a data e o horário da reserva (dd/MM/yyyy HH:mm): ");

                            Vermelho.fazerReserva(nome, setor, data);
                            JOptionPane.showMessageDialog(null, "Reserva feita com sucesso!");
                        }

                        else{
                            JOptionPane.showMessageDialog(null, "Não há mais reservas disponíveis para esta sala","ERRO", JOptionPane.ERROR_MESSAGE);

                        }
                    }

                    if(oplab.equals("Amarelo")) {

                        if (Amarelo.numReservas< 20) {

                            JOptionPane.showMessageDialog(null, "Esta sala ainda tem " +
                                    (20 - Amarelo.numReservas) + " reservas disponíveis");

                            String nome = JOptionPane.showInputDialog("Qual o seu nome?");
                            String setor = JOptionPane.showInputDialog("Qual o setor?");
                            String data = JOptionPane.showInputDialog("Insira a data e o horário da reserva (dd/MM/yyyy HH:mm): ");

                            Amarelo.fazerReserva(nome, setor, data);
                            JOptionPane.showMessageDialog(null, "Reserva feita com sucesso!");
                        }

                        else{
                            JOptionPane.showMessageDialog(null, "Não há mais reservas disponíveis para esta sala","ERRO", JOptionPane.ERROR_MESSAGE);

                        }
                    }
                }
                if(ops.equals("Convencional")){

                    Object[] sala_conv = {"SalaA", "SalaB","SalaC"};
                    String opconv = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:",
                            "Selecione uma sala", JOptionPane.PLAIN_MESSAGE, null, sala_conv, "SalaA");

                    if(opconv.equals("SalaA")){

                        if (SalaA.numReservas < 20) {

                            JOptionPane.showMessageDialog(null, "Esta sala ainda tem " +
                                    (20 - SalaA.numReservas) + " reservas disponíveis");

                            String nome = JOptionPane.showInputDialog("Qual o seu nome?");
                            String setor = JOptionPane.showInputDialog("Qual o setor?");
                            String data = JOptionPane.showInputDialog("Insira a data e o horário da reserva (dd/MM/yyyy HH:mm): ");

                            SalaA.fazerReserva(nome, setor, data);

                            JOptionPane.showMessageDialog(null, "Reserva feita com sucesso!");
                        }

                        else{
                            JOptionPane.showMessageDialog(null, "Não há mais reservas disponíveis para esta sala","ERRO", JOptionPane.ERROR_MESSAGE);

                        }

                    }

                    if(opconv.equals("SalaB")){

                        if (SalaB.numReservas < 20) {

                            JOptionPane.showMessageDialog(null, "Esta sala ainda tem " +
                                    (20 - SalaB.numReservas) + " reservas disponíveis");

                            String nome = JOptionPane.showInputDialog("Qual o seu nome?");
                            String setor = JOptionPane.showInputDialog("Qual o setor?");
                            String data = JOptionPane.showInputDialog("Insira a data e o horário da reserva (dd/MM/yyyy HH:mm): ");

                            SalaB.fazerReserva(nome, setor, data);
                            JOptionPane.showMessageDialog(null, "Reserva feita com sucesso!");
                        }

                        else{
                            JOptionPane.showMessageDialog(null, "Não há mais reservas disponíveis para esta sala","ERRO", JOptionPane.ERROR_MESSAGE);

                        }

                    }
                    if(opconv.equals("SalaC")){

                        if (SalaC.numReservas < 20) {

                            JOptionPane.showMessageDialog(null, "Esta sala ainda tem " +
                                    (20 - SalaC.numReservas) + " reservas disponíveis");

                            String nome = JOptionPane.showInputDialog("Qual o seu nome?");
                            String setor = JOptionPane.showInputDialog("Qual o setor?");
                            String data = JOptionPane.showInputDialog("Insira a data e o horário da reserva (dd/MM/yyyy HH:mm): ");

                            SalaC.fazerReserva(nome, setor, data);
                            JOptionPane.showMessageDialog(null, "Reserva feita com sucesso!");
                        }

                        else{
                            JOptionPane.showMessageDialog(null, "Não há mais reservas disponíveis para esta sala","ERRO", JOptionPane.ERROR_MESSAGE);

                        }
                    }
                }
            }
        }
    }
}