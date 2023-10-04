//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.swing.JOptionPane;
//
//public class SistemaEventos {
//
//    public static void main(String[] args) {
//        List<Evento> eventos = new ArrayList<>();
//
//        while (true) {
//            int escolha = Integer.parseInt(JOptionPane.showInputDialog(
//                    "Escolha uma opção:\n" +
//                            "1. Criar evento\n" +
//                            "2. Vender ingressos\n" +
//                            "3. Gerenciar receita\n" +
//                            "4. Exibir eventos\n" +
//                            "5. Sair"));
//
//            switch (escolha) {
//                case 1:
//                    criarEvento(eventos);
//                    break;
//                case 2:
//                    venderIngressos(eventos);
//                    break;
//                case 3:
//                    gerenciarReceita(eventos);
//                    break;
//                case 4:
//                    exibirEventos(eventos);
//                    break;
//                case 5:
//                    System.exit(0);
//                default:
//                    JOptionPane.showMessageDialog(null, "Opção inválida");
//            }
//        }
//    }
//
//    public static void criarEvento(List<Evento> eventos) {
//        String nome = JOptionPane.showInputDialog("Digite o nome do evento:");
//        String data = JOptionPane.showInputDialog("Digite a data do evento:");
//        String horario = JOptionPane.showInputDialog("Digite o horário do evento:");
//        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do evento:"));
//
//        Evento evento = new Evento(nome, data, horario, capacidade);
//        eventos.add(evento);
//
//        JOptionPane.showMessageDialog(null, "Evento criado com sucesso!");
//    }
//
//    public static void venderIngressos(List<Evento> eventos) {
//        String nomeEvento = JOptionPane.showInputDialog("Digite o nome do evento:");
//        Evento evento = encontrarEvento(eventos, nomeEvento);
//
//        if (evento != null) {
//            int quantidadeIngressos = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de ingressos:"));
//            String tipoIngresso = JOptionPane.showInputDialog("Digite o tipo de ingresso (Padrao, Meia, VIP):");
//
//            Ingresso ingresso;
//            if (tipoIngresso.equalsIgnoreCase("Padrao")) {
//                ingresso = new IngressoPadrao();
//            } else if (tipoIngresso.equalsIgnoreCase("Meia")) {
//                ingresso = new IngressoMeia();
//            } else if (tipoIngresso.equalsIgnoreCase("VIP")) {
//                ingresso = new IngressoVIP();
//            } else {
//                JOptionPane.showMessageDialog(null, "Tipo de ingresso inválido.");
//                return;
//            }
//
//            double totalVenda = evento.venderIngressos(quantidadeIngressos, ingresso);
//
//            JOptionPane.showMessageDialog(null, "Ingressos vendidos com sucesso!\nTotal da venda: R$" + totalVenda);
//        } else {
//            JOptionPane.showMessageDialog(null, "Evento não encontrado");
//        }
//    }
//
//    public static void gerenciarReceita(List<Evento> eventos) {
//        double receitaTotal = 0;
//        for (Evento evento : eventos) {
//            receitaTotal += evento.getReceita();
//        }
//
//        JOptionPane.showMessageDialog(null, "Receita total gerada: R$" + receitaTotal);
//    }
//
//    public static void exibirEventos(List<Evento> eventos) {
//        StringBuilder sb = new StringBuilder("Eventos:\n");
//
//        for (Evento evento : eventos) {
//            sb.append(evento.toString()).append("\n");
//        }
//
//        JOptionPane.showMessageDialog(null, sb.toString());
//    }
//
//    public static Evento encontrarEvento(List<Evento> eventos, String nomeEvento) {
//        for (Evento evento : eventos) {
//            if (evento.getNome().equals(nomeEvento)) {
//                return evento;
//            }
//        }
//        return null;
//    }
//}
//
//class Evento {
//    private String nome;
//    private String data;
//    private String horario;
//    private int capacidade;
//    private int ingressosVendidos;
//    private Ingresso ingresso; // Adicione uma instância de Ingresso
//
//    public Evento(String nome, String data, String horario, int capacidade) {
//        this.nome = nome;
//        this.data = data;
//        this.horario = horario;
//        this.capacidade = capacidade;
//        this.ingressosVendidos = 0;
//        this.ingresso = new Ingresso(); // Inicialize a instância de Ingresso
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public double getReceita() {
//        return ingressosVendidos * ingresso.getPreco();
//    }
//
//    public double venderIngressos(int quantidade, Ingresso ingresso) {
//        if (quantidade > 0 && quantidade <= (capacidade - ingressosVendidos)) {
//            ingressosVendidos += quantidade;
//            return quantidade * ingresso.getPreco();
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Nome: " + nome + "\nData: " + data + "\nHorário: " + horario +
//                "\nCapacidade: " + capacidade + "\nIngressos Vendidos: " + ingressosVendidos;
//    }
//}
//class Ingresso {
//    private double preco = 30;
//
//    public double getPreco() {
//        return preco;
//    }
//}
//
//class IngressoPadrao extends Ingresso {
//    private double precoPadrao;
//
//    public IngressoPadrao() {
//        this.precoPadrao = super.getPreco();
//    }
//
//    public double getPreco() {
//        return precoPadrao;
//    }
//}
//
//class IngressoMeia extends Ingresso {
//    private double precoMeia;
//
//    public IngressoMeia() {
//        this.precoMeia = super.getPreco() * 0.5;
//    }
//
//    public double getPreco() {
//        return precoMeia;
//    }
//}
//
//class IngressoVIP extends Ingresso {
//    private double precoVIP;
//
//    public IngressoVIP() {
//        this.precoVIP = super.getPreco() * 2;
//    }
//
//    public double getPreco() {
//        return precoVIP;
//    }
//}
