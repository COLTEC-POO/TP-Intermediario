import javax.swing.*;

public class Main {

    private static final int MAX_EVENTOS = 100;
    
    public static void main (String[] args) {

        int qntEventos = 0;
        Eventos[] totalEventos = new Eventos[MAX_EVENTOS];

        System.out.println(menu());
        int option = Integer.parseInt(JOptionPane.showInputDialog("Insira a opção desejada: "));

        System.out.println(menu());

        while (option != 0) {

                switch (option) {

                    case 1:
                    if (qntEventos < MAX_EVENTOS) {                 // Limita a criação de novos eventos ao tamanho do array
                        totalEventos[qntEventos] = criaEventos();
                        if (totalEventos[qntEventos] != null) {     // Garante que apenas eventos válidos sejam adicionados ao array (se por algum motivo o default do switch for alcançado)
                            qntEventos++; 
                        }
                    } else {
                    JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível criar o evento",
                    "Limite excedido!",
                    JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                    case 2:
                    Eventos.compraIngresso(totalEventos, qntEventos);
                    break;                
                
                    case 3:
                    calculaReceitaGeral(totalEventos, qntEventos);
                    break;

                    case 4:
                    imprimeEventos(totalEventos, qntEventos);
                    break;

                    case 5:
                    exibeIngressos(totalEventos, qntEventos);
                    break;

                    default:
                    JOptionPane.showMessageDialog(
                    null,
                    "Insira um valor válido!",
                    "Opção inválida!",
                    JOptionPane.ERROR_MESSAGE);
                    break;
                } 

            System.out.println(menu());
            option = Integer.parseInt(JOptionPane.showInputDialog("Insira a opção desejada: "));
        }
        System.out.println("Fim da execução!");
    }


    // Método que permite a criação de eventos dos tipos definidos

    public static Eventos criaEventos() {
        String[] options = { "Filme", "Teatro", "Concerto" };

        int tipoEvento = JOptionPane.showOptionDialog(
        null,
        "Qual tipo de evento você deseja criar?",
        "Novo Evento",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0]
        );

        // Evita com que o usuário perca tempo digitando dados de um evento inválido

        if (tipoEvento == JOptionPane.CLOSED_OPTION) {
        JOptionPane.showMessageDialog(
        null,
        "A janela foi fechada durante a criação do evento! Tente novamente.",
        "Erro ao criar o evento.",
        JOptionPane.ERROR_MESSAGE);
        return null;
        }

        String nomeEvento = JOptionPane.showInputDialog("Digite o nome do evento:");
        String dataEvento = JOptionPane.showInputDialog("Digite a data do evento:");
        String horaEvento = JOptionPane.showInputDialog("Digite o horário do evento:");
        double precoEvento = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do ingresso:"));
        String localEvento = JOptionPane.showInputDialog("Digite o local do evento:");

            switch (tipoEvento) {
                case 0:
                    return new Filme(nomeEvento, dataEvento, horaEvento, precoEvento, localEvento);
                case 1:
                    return new Teatro(nomeEvento, dataEvento, horaEvento, precoEvento, localEvento);
                case 2:
                    return new Concerto(nomeEvento, dataEvento, horaEvento, precoEvento, localEvento);
                default:
                    JOptionPane.showMessageDialog(
                    null,
                    "Tipo de evento inválido!",
                    "Erro ao criar o evento",
                    JOptionPane.ERROR_MESSAGE);
                    return null;
            }
    }

    // Método que calcula a receita geral da bilheteria a partir da receita individual de cada evento

    public static void calculaReceitaGeral(Eventos[] totalEventos, int qntEventos){
        double receitaGeral = 0;
        for (int i = 0; i < qntEventos; i++){
            receitaGeral += totalEventos[i].calculaReceitaIndividual();
        }
        JOptionPane.showMessageDialog(
            null,
            "A receita total da bilheteria é: " + receitaGeral,
            "Receita geral",
            JOptionPane.INFORMATION_MESSAGE);
    }

    // Método que mostra informações de todos os eventos ativos

    public static void imprimeEventos(Eventos[] totalEventos, int qntEventos) {
        if (qntEventos > 0) {
            System.out.println("Eventos disponíveis:");
            for (int i = 0; i < qntEventos; i++){
                System.out.println(totalEventos[i].toString());
            }
        } else {
            JOptionPane.showMessageDialog(null,
            "Não há nenhum evento ativo no momento =(",
            "Nenhum evento encontrado",
            JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método que permite escolher qual evento o usuário deseja exibir o extrato de vendas

    public static void exibeIngressos(Eventos[] totalEventos, int qntEventos){
        if (qntEventos > 0) {
            for (int i = 0; i < qntEventos; i++) {
                System.out.println("Evento " + (i + 1) + ":" + "\n" + totalEventos[i].toString());
            }

            int escolhaEvento = Integer.parseInt(JOptionPane.showInputDialog("Escolha o número do evento:"));

            Eventos eventoEscolhido = totalEventos[escolhaEvento - 1];

            if (escolhaEvento > 0 && escolhaEvento <= qntEventos) {
            System.out.println("Ingressos vendidos do evento " + eventoEscolhido.getNome() + ": ");
            System.out.println("Data da compra: " + "\t\t" + "Tipo: " + "\t" + "Valor: ");
            eventoEscolhido.imprimeIngressos();
            } else {
                JOptionPane.showMessageDialog(
                null,
                "O evento selecionado não é válido!",
                "Evento Inválido!",
                JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
            null,
            "Não há eventos disponíveis para imprimir ingressos!",
            "Lista de eventos vazia!",
            JOptionPane.INFORMATION_MESSAGE);
            }
    }

    // Método que imprime na tela as funcionalidades do sistema

    public static String menu() {
        String options =    "================== Sistema de Bilheteria ================== " + "\n" + 
                            "1 - Cadastrar um novo evento: " + "\n" +
                            "2 - Venda de ingressos: " + "\n" +
                            "3 - Receita geral da bilheteria: " + "\n" +
                            "4 - Exibir os eventos disponíveis: " + "\n" +
                            "5 - Exibir os ingressos vendidos: " + "\n" +
                            "0 - Fechar o programa: " + "\n";
        return options;
    }
}