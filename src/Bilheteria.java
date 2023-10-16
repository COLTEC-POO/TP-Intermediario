import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bilheteria {

    static ArrayList<Evento> eventos;
    static ArrayList<Ingresso> ingressos;

    public static void main(String[] args) {
        eventos = new ArrayList<Evento>();
        ingressos = new ArrayList<Ingresso>();

        JOptionPane.showMessageDialog(null, "Bem vindo a Bilheteria Virtual MKM");

        menu();
    }

    public static void menu() {

        int escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma operação que deseja realizar:\n" +
                "1 - Criar um evento\n" +
                "2 - Comprar ingressos\n" +
                "3 - Gerenciamento de receita\n" +
                "4 - Exibir eventos\n" +
                "5 - Exibir ingressos\n" +
                "6 - Sair"));

        switch (escolha) {
            case 1:
                cadastrarEvento();
                break;
            case 2:
                comprarIngresso();
                break;
            case 3:
                gerenciarReceita();
                break;
            case 4:
                exibirEventos();
                break;
            case 5:
                exibirIngresso();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Volte sempre! :)");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!","Ops, deu erro", JOptionPane.ERROR_MESSAGE);
                menu();
                break;
        }
    }

    private static void cadastrarEvento() {
        int tipoEvento = Integer.parseInt(JOptionPane.showInputDialog("Selecione o tipo de evento:\n" +
                "1 - Cinema\n" +
                "2 - Teatro\n" +
                "3 - Concerto"));

        String nomeEvento = JOptionPane.showInputDialog("Nome do evento: ");

        String dataEvento = JOptionPane.showInputDialog("Data do evento: (dd/mm/yyyy)");

        String horarioEvento = JOptionPane.showInputDialog("Horário do evento: (hh:mm)");

        double precoEvento = Double.parseDouble(JOptionPane.showInputDialog("Preço do ingresso: ($$.$$)"));

        Evento novoEvento;

        switch (tipoEvento) {
            case 1:
                novoEvento = new Cinema(nomeEvento, dataEvento, horarioEvento, precoEvento);
                eventos.add(novoEvento);
                JOptionPane.showMessageDialog(null, "Evento de CINEMA cadastrado com sucesso!");
                break;
            case 2:
                novoEvento = new Teatro(nomeEvento, dataEvento, horarioEvento, precoEvento);
                eventos.add(novoEvento);
                JOptionPane.showMessageDialog(null, "Evento de tipo TEATRO cadastrado com sucesso!");
                break;
            case 3:
                novoEvento = new Concerto(nomeEvento, dataEvento, horarioEvento, precoEvento);
                eventos.add(novoEvento);
                JOptionPane.showMessageDialog(null, "Evento de CONCERTO cadastrado com sucesso!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!","Ops, deu erro", JOptionPane.ERROR_MESSAGE);
        }
        menu();
    }

    private static void exibirEventos() {
        if (eventos.size() > 0) {
            StringBuilder eventosString = new StringBuilder("Exibição dos eventos em cartaz:\n");

            for (int i = 0; i < eventos.size(); i++) {
                Evento evento = eventos.get(i);
                eventosString.append(i + 1).append(". ").append(evento.getNome()).append("\n");
            }

            eventosString.append("0 - >Voltar ao MENU <");

            int escolhaEvento = Integer.parseInt(JOptionPane.showInputDialog(eventosString.toString()));

            if (escolhaEvento == 0) {
                menu();
            } else if (escolhaEvento > 0 && escolhaEvento <= eventos.size()) {
                Evento eventoSelecionado = eventos.get(escolhaEvento - 1);
                exibirDetalhesEvento(eventoSelecionado);
            } else {
                JOptionPane.showMessageDialog(null, "Escolha de evento inválida!", "Ops, deu erro", JOptionPane.ERROR_MESSAGE);
                exibirEventos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado!", "Ops, deu erro", JOptionPane.ERROR_MESSAGE);
            menu();
        }
    }
    private static void exibirDetalhesEvento(Evento evento) {
        JOptionPane.showMessageDialog(null, evento.toString());
        exibirEventos();
    }

    private static void comprarIngresso() { //verificar a capacidade para cada tipo de evento (exibir quantos disponíveis)
        if (eventos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado!","Ops, deu erro", JOptionPane.ERROR_MESSAGE);
            menu();
        }

        StringBuilder eventosString = new StringBuilder("Escolha o evento para comprar ingressos: \n\n");
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            eventosString.append(i + 1).append(". Tipo: ").append(evento.getClass().getSimpleName()).append(" - Nome: ").append(evento.getNome()).append("- Ingressos disponíveis: ").append(evento.capacidade.length - evento.ingressoVendido).append("\n");
        }

        int escolhaEvento = Integer.parseInt(JOptionPane.showInputDialog(eventosString.toString()));

        if (escolhaEvento < 1 || escolhaEvento > eventos.size()) {
            JOptionPane.showMessageDialog(null, "Escolha de evento inválida!","Ops, deu erro", JOptionPane.ERROR_MESSAGE);
            menu();
        }

        Evento eventoEscolhido = eventos.get(escolhaEvento - 1);

        Object[] opcoes = {"Normal", "Meia", "Vip"};
        String tipoIngresso = (String) JOptionPane.showInputDialog(null,
                "Normal, Meia ou Vip?",
                "Escolha o tipo do ingresso",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                "Normal");

        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantos ingressos você deseja:"));

        // vai checar a capacidade aqui
        if (!checaCapacidade(quantidade, eventoEscolhido)) {
            JOptionPane.showMessageDialog(null, "Capacidade esgotada para este tipo de ingresso no evento selecionado!", "Ops, deu erro", JOptionPane.ERROR_MESSAGE);
            menu();
        }
        double valorTotal = 0.0;

        // ingressos vendidos são adicionados à lista
        for (int i = 0; i < quantidade; i++) {
            Ingresso ingressoVendido;
            if (tipoIngresso.equals("Meia")) {
                ingressoVendido = new IngressoMeia(eventoEscolhido.getPreco());
            } else if (tipoIngresso.equals("Vip")) {
                ingressoVendido = new IngressoVip(eventoEscolhido.getPreco());
            } else {
                ingressoVendido = new IngressoNormal(eventoEscolhido.getPreco());
            }
            ingressoVendido.setEvento(eventoEscolhido);
            ingressos.add(ingressoVendido);
            valorTotal += ingressoVendido.getValor();

        }
        eventoEscolhido.adicionarReceita(valorTotal);

        //quantidade de ingressos vendidos no evento
        eventoEscolhido.ingressoVendido += quantidade;

        JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!\n Valor Total: R$" + valorTotal, "Fechou!", JOptionPane.INFORMATION_MESSAGE);

        menu();
    }

    private static double calcularReceitaTotal() {
        double receitaTotal = 0;

        for (Evento evento : eventos) {
            receitaTotal += evento.getReceita();
        }
        return receitaTotal;
    }

    private static void gerenciarReceita() {
        int escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione a operação que deseja realizar:\n" +
                "1 - Selecionar evento\n" +
                "2 - Receita total da bilheteria\n" +
                "3 - Voltar ao menu principal"));

        switch (escolha) {
            case 1:
                if (eventos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado!", "Ops, deu erro", JOptionPane.ERROR_MESSAGE);
                    menu();
                    return;
                }
                StringBuilder eventosString = new StringBuilder("Escolha um evento:\n");
                for (int i = 0; i < eventos.size(); i++) {
                    Evento evento = eventos.get(i);
                    eventosString.append(i + 1).append(". ").append(evento.getNome()).append("\n");
                }

                int escolhaEvento = Integer.parseInt(JOptionPane.showInputDialog(eventosString.toString()));

                if (escolhaEvento >= 1 && escolhaEvento <= eventos.size()) {
                    Evento eventoSelecionado = eventos.get(escolhaEvento - 1);
                    double receitaEvento = eventoSelecionado.getReceita();
                    JOptionPane.showMessageDialog(null, "Receita total do evento " + eventoSelecionado.getNome() + ": R$" + receitaEvento);
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha de evento inválida!","Ops, deu erro", JOptionPane.ERROR_MESSAGE);
                }
                gerenciarReceita();
                break;
            case 2:
                double receitaTotal = calcularReceitaTotal();
                JOptionPane.showMessageDialog(null, "Receita total da bilheteria: R$" + receitaTotal, "Receita", JOptionPane.INFORMATION_MESSAGE);
                gerenciarReceita();
                break;
            case 3:
                menu();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!","Ops, deu erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void exibirIngresso() {
        if (ingressos.size() > 0) {
            //StringBuilder ingressosString = new StringBuilder("Exibição de Ingressos Vendidos:\n");

            for (Ingresso ingresso : ingressos) {
                JOptionPane.showMessageDialog(null, ingresso.toString());
            }

            //JOptionPane.showMessageDialog(null, ingressosString.toString(), "Detalhes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum ingresso foi vendido ainda", "Ops, deu erro", JOptionPane.ERROR_MESSAGE);
        }

        menu();
    }

    private static boolean checaCapacidade(int quantidadePedido, Evento evento){
        return quantidadePedido <= (evento.capacidade.length - evento.ingressoVendido);
    }
}