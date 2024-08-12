import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();

        Evento moana = new Filme("Moana", "08/07/2024", "1:30", "Cinema", 10.0);
        Evento avengers = new Filme("Avengers", "09/07/2024", "14:00", "Cinema", 18.0);
        Evento filarmonica = new Concerto("Filarmônica", "10/07/2024", "20:00", "Auditório", 50.0);
        Evento hamlet = new Teatro("Hamlet", "11/07/2024", "18:00", "Teatro", 100);
        Evento peterPan = new Teatro("Peter Pan", "12/07/2024", "16:00", "Teatro", 30);

        //adcionar eventos na lista - NÃO ESQUECER DE ADCIONAR EVENTO NA LISTA!!
        eventos.add(moana);
        eventos.add(avengers);
        eventos.add(filarmonica);
        eventos.add(hamlet);
        eventos.add(peterPan);

        /*moana.addIngresso(new Ingresso(moana.getPreco()));
        moana.addIngresso(new Ingresso(moana.getPreco()));
        moana.addIngresso(new IngressoMeiaEntrada(moana.getPreco()));

        avengers.addIngresso(new Ingresso(avengers.getPreco()));
        avengers.addIngresso(new Ingresso(avengers.getPreco()));
        avengers.addIngresso(new IngressoMeiaEntrada(avengers.getPreco()));

        filarmonica.addIngresso(new Ingresso(filarmonica.getPreco()));
        filarmonica.addIngresso(new IngressoVIP(filarmonica.getPreco()));

        System.out.println(avengers.toString() + "\n");

        moana.extratoReceita();
        avengers.extratoReceita();
        filarmonica.extratoReceita();

        moana.getIngresso(1).extratoReceita();

        moana.ingressosVendidos();
        */

        double receitaTotalAcumulada = Evento.receitaTotalAcumulada(eventos);
        System.out.println("\nReceita Total Acumulada de Todos os Eventos: R$ " + receitaTotalAcumulada);

        //dialogos para adquirir um ingresso com jOptionPane
        String[] nomesEventos = {moana.getNome(), avengers.getNome(), filarmonica.getNome(), hamlet.getNome(), peterPan.getNome()};
        String[] options = {"Conferir eventos", "Sair"};
        int opcao;

        do {
            opcao = JOptionPane.showOptionDialog(null,
                    "<< BILHETERIA >>",
                    "Clique e divirta-se!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if (opcao == 0) {
                String nomeEvento = (String) JOptionPane.showInputDialog(null,
                        "<< COMPRA DE INGRESSO >>",
                        "Seleção de Evento",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        nomesEventos,
                        nomesEventos[0]);

                //encontra o evento selecionado
                Evento eventoSelecionado = null;
                for (Evento evento : eventos) {
                    if (evento.getNome().equals(nomeEvento)) {
                        eventoSelecionado = evento;
                        break;
                    }
                }

                if (eventoSelecionado != null) {
                    //tipos de ingresso
                    Object[] opcoesIngressos = {"Normal", "VIP", "Meia Entrada"};

                    String tipoIngresso = (String) JOptionPane.showInputDialog(null,
                            "<< TIPO DO INGRESSO >>",
                            "Seleção de Ingresso",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoesIngressos,
                            "Normal");

                    if (tipoIngresso != null) {
                        //adiciona o ingresso selecionado ao evento
                        switch (tipoIngresso) {
                            case "Normal":
                                eventoSelecionado.addIngresso(new Ingresso(eventoSelecionado.getPreco()));
                                break;
                            case "VIP":
                                eventoSelecionado.addIngresso(new IngressoVIP(eventoSelecionado.getPreco()));
                                break;
                            case "Meia Entrada":
                                eventoSelecionado.addIngresso(new IngressoMeiaEntrada(eventoSelecionado.getPreco()));
                                break;
                        }
                    }
                }
            }
        } while (opcao != 1);

        //teste de funcionalidade - tudo certo!!
        receitaTotalAcumulada = Evento.receitaTotalAcumulada(eventos);
        System.out.println("\nReceita Total Acumulada de Todos os Eventos: R$ " + receitaTotalAcumulada);
    }
}
