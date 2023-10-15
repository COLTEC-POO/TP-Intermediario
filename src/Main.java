import java.util.Date;
import javax.swing.JOptionPane;

public class Main {

    private static Evento[] eventos = new Evento[999];
    private static int qtdEventos = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = exibirMenu();

            switch (opcao) {
                case 1:
                    criarEvento();
                    break;
                case 2:
                    venderIngresso();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    listarIngressos();
                    break;
            }
        } while (opcao != 0);
    }

    // Criar as opções do menu, e abrir um menu do JOptionPane com o método showOptionDialog
    private static int exibirMenu() {
        // Criando as opções
        String[] opcoes = {
                "Criar Evento",
                "Comprar Ingresso",
                "Listar Eventos",
                "Exibir Ingressos"
        };

        // Mostrar o menu

        int opcao = JOptionPane.showOptionDialog(
                null,
                "Menu Sistema Bilheteria",
                "Bilheteria",
                JOptionPane.DEFAULT_OPTION, // Definindo opção padrão pra criação da aba
                JOptionPane.PLAIN_MESSAGE, // Definindo tipo de mensagem que vai ser exibida na aba
                null, // Icone
                opcoes, // Opções
                opcoes[0]
        );

        return opcao + 1;
    }

    private static void criarEvento() {
        String nome = JOptionPane.showInputDialog("Informe o nome do Evento");
        String dataStr = JOptionPane.showInputDialog("Informe a data do Evento (dd/MM/yyyy)");
        Date data = null;
        try {
            data = new Date(dataStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do ingresso do Evento"));

        String[] tiposEvento = { "Filme", "Teatro", "Concerto" };
        int opcao = JOptionPane.showOptionDialog(
                null,
                "Selecione o tipo de Evento:",
                "Tipo de Evento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                tiposEvento,
                tiposEvento[0]
        );

        Evento evento = null;
        switch (opcao) {
            case 0:
                evento = new Filme(nome, data, preco);
                break;
            case 1:
                evento = new Teatro(nome, data, preco);
                break;
            case 2:
                evento = new Concerto(nome, data, preco);
                break;
        }

        eventos[qtdEventos] = evento;
        qtdEventos++;
        JOptionPane.showMessageDialog(null, "Evento criado com sucesso:\n" + evento.toString());
    }

    private static void venderIngresso() {
        if (qtdEventos == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum evento disponível para venda.");
            return;
        }

        listarEventos();

        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do evento para comprar o ingresso"));
        if (opcao < 1 || opcao > qtdEventos) {
            JOptionPane.showMessageDialog(null, "Evento inválido.");
            return;
        }

        Evento evento = eventos[opcao - 1];

        String[] tiposIngresso = { "Inteira", "Meia", "VIP" };
        opcao = JOptionPane.showOptionDialog(
                null,
                "Selecione o tipo de ingresso:",
                "Tipo de Ingresso",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                tiposIngresso,
                tiposIngresso[0]
        );

        switch (opcao) {
            case 0:
                evento.venderIngresso(TipoIngresso.NORMAL);
                break;
            case 1:
                evento.venderIngresso(TipoIngresso.MEIA);
                break;
            case 2:
                evento.venderIngresso(TipoIngresso.VIP);
                break;
        }
    }

    private static void listarIngressos() {
        if (qtdEventos == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum evento disponível para listar ingressos.");
            return;
        }

        listarEventos();

        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do evento para listar os ingressos"));
        if (opcao < 1 || opcao > qtdEventos) {
            JOptionPane.showMessageDialog(null, "Evento inválido.");
            return;
        }

        Evento evento = eventos[opcao - 1];
        JOptionPane.showMessageDialog(null, evento.listarIngressos());
    }

    private static void listarEventos() {
        if (qtdEventos > 0) {
            String  eventosStr = "Lista de Eventos:\n";
            for (int i = 0; i < qtdEventos; i++) {
                eventosStr += i + 1 + "º " + eventos[i].toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, eventosStr);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado.");
        }
    }
}
