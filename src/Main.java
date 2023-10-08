import javax.swing.*;

// Classe principal para testar ingressos e eventos
public class Main {
    public static void main(String[] args) {

        Eventos[] eventos = null; // Array para armazenar eventos criados
        Eventos eventoAtual = null; // Variável para armazenar o evento selecionado pelo usuário

        int escolha = -1;

        // Loop principal para exibir o menu e processar a escolha do usuário
        while (escolha != 0) {

            // Exibe o menu e obtém a escolha do usuário
            escolha = Integer.parseInt(JOptionPane.showInputDialog(
                    "1) Criar eventos\n2) Selecionar evento\n3) Comprar ingressos\n4) Ver receita total do evento\n5) Exibir eventos"));

            switch (escolha) {
                case 1:
                    // Opção para criar novos eventos
                    eventos = Eventos.criarEvento();
                    break;

                case 2:
                    // Opção para selecionar um evento existente
                    eventoAtual = Eventos.selecionarEvento(eventos);
                    break;

                case 3:
                    // Opção para comprar ingressos para o evento selecionado
                    if (eventoAtual != null) {
                        eventoAtual.VenderIngressos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum evento selecionado. Selecione um evento primeiro!",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 4:
                    // Opção para ver o extrato do evento selecionado
                    if (eventoAtual != null) {
                        JOptionPane.showMessageDialog(null, eventoAtual.imprimirExtrato(), "Detalhes dos Eventos",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum evento selecionado. Selecione um evento primeiro!",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:
                    // Opção para exibir detalhes de todos os eventos criados
                    if (eventos != null) {
                        JOptionPane.showMessageDialog(null, Eventos.imprimirEventos(eventos), "Detalhes dos Eventos", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum evento criado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }
    }
}
