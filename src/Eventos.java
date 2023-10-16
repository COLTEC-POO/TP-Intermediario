// Importando JOptionPane para interações com o usuário
import javax.swing.*;

// Importando a formatação de data
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// A classe Eventos representa eventos que podem ocorrer em uma data específica.
public abstract class Eventos {

    // Atributos base
    String nome;
    LocalDate data;
    Boolean eAcessivel;
    String horario;
    Ingresso ingresso;
    Ingresso[] vendasIngressos;


    // Contador para o número de ingressos vendidos para este evento
    private int numIngressos;

    // Limitador de ingressos que será utilizado nas subclasses de Eventos
    int LIMITE_INGRESSOS;

    // Contadores estáticos para rastrear o número total de eventos e o máximo permitido
    static int numEventosCriados = 0;
    static int MAX_EVENTOS = 50;

    // Constructor de Eventos
    public Eventos(String nome, Boolean eAcessivel, String horario, LocalDate data) {

        this.nome = nome;
        this.data = data;
        this.eAcessivel = eAcessivel;
        this.horario = horario;

        // Inicializando o limite padrão de ingressos
        this.LIMITE_INGRESSOS = 100;

        // Inicializando o array para armazenar vendas de ingressos
        this.vendasIngressos = new Ingresso[LIMITE_INGRESSOS];

        // Inicializando o número de ingressos vendidos como 0
        this.numIngressos = 0;
    }

    // Métodos para obter informações sobre o evento
    public abstract String getTipo();

    // Método para obter a quantidade de ingressos vendidos
    public int getNumIngressos() {
        return numIngressos;
    }

    // Método para verificar se o evento é acessível ou não e retornar uma mensagem correspondente
    public String eAcessivel() {
        if(eAcessivel) {
            return "Acessivel! 🚀🚀";
        } else {
            return "Nao acessivel! 😡😡";
        }
    }

    // Método para representar o objeto Eventos como uma string formatada
    public String toString() {
        // Converter a string da data em um objeto LocalDate usando DateTimeFormatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(dateFormatter);

        return "Nome: " + this.nome + "\nTipo: " + this.getTipo() + " \nData: " + dataFormatada + " - Horário: " + this.horario + "\nÉ acessível? " + eAcessivel();
    }

    // Método para imprimir detalhes de vários eventos
    public static String imprimirEventos(Eventos[] eventos) {
        String detalhesEventos = "";

        for (Eventos evento : eventos) {
            if (evento != null) { // Verificar se o evento não é nulo
                detalhesEventos += "Detalhes do Evento: \n" + evento.toString() + "\n\n";
            }
        }

        // Retornar a string acumulada com os detalhes de todos os eventos
        return detalhesEventos;
    }

    // Método para imprimir o extrato das vendas de ingressos para este evento
    public String imprimirExtrato() {
        String extrato = "";
        String tipoEvento = getTipo();
        extrato += "Extrato do Evento: " + this.nome + " - " + tipoEvento + "\n";

        double receitaTotal = 0;

        // Loop para acumular detalhes de cada ingresso vendido
        for (int i = 0; i < numIngressos; i++) {
            Ingresso ingresso = vendasIngressos[i];
            extrato += ingresso.data + " | " + ingresso.getTipoIngresso() + " - " + ingresso.getPreco() + "\n";
            receitaTotal += ingresso.getPreco();
        }
        // Acumulando o total
        extrato += "\nTotal de ingressos vendidos: " + numIngressos + "\n";
        extrato += "Receita total gerada: " + receitaTotal + "\n";

        // Retorna o extrato acumulado como uma string
        return extrato;
    }

    // Método estático para criar eventos
    public static Eventos[] criarEvento() {

        Eventos[] eventos = new Eventos[MAX_EVENTOS];

        while (numEventosCriados < MAX_EVENTOS) {
            // Salvando string em nome
            String nome = JOptionPane.showInputDialog("Digite o nome do evento:");

            // Salvando o boolean em eAcessivel
            boolean eAcessivel = JOptionPane.showInputDialog("O evento é acessível? (Sim ou Não)").equalsIgnoreCase("sim");

            // Salvando string de horario
            String horario = JOptionPane.showInputDialog("Digite o horário do evento:");

            // Salvando data como String
            String dataString = JOptionPane.showInputDialog("Digite a data do evento (no formato dd/MM/yyyy):");

            // Formatando a data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formatter);



            boolean tipoValido = false;
            while(!tipoValido) {
            // Comparando o tipo inserido com os tipos presentes
            String tipoEvento = JOptionPane.showInputDialog("Digite o tipo do evento (Filme, Concerto, ou Teatro):");

            switch (tipoEvento.toLowerCase()) {
                case "filme":
                    eventos[numEventosCriados] = new Filme(nome, eAcessivel, horario, data);
                    tipoValido = true;
                    break;
                case "concerto":
                    eventos[numEventosCriados] = new Concerto(nome, eAcessivel, horario, data);
                    tipoValido = true;
                    break;
                case "teatro":
                    eventos[numEventosCriados] = new Teatro(nome, eAcessivel, horario, data);
                    tipoValido = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

            numEventosCriados++;


            int escolha1 = JOptionPane.showConfirmDialog(null, "Deseja adicionar outro evento?", "Adicionar Evento", JOptionPane.YES_NO_OPTION);
            if (escolha1 != JOptionPane.YES_OPTION) {
                break;
            }
        }

        return eventos;
    }

    // Solicitar ao usuário que selecione um evento da lista
    public static Eventos selecionarEvento(Eventos[] eventos) {
        if (eventos != null && numEventosCriados > 0) {
            String[] opcoesEventos = new String[numEventosCriados];
            for (int i = 0; i < numEventosCriados; i++) {
                opcoesEventos[i] = eventos[i].nome;
            }
            String eventoSelecionado = (String) JOptionPane.showInputDialog(null,
                    "Selecione um evento:", "Selecionar Evento", JOptionPane.PLAIN_MESSAGE, null, opcoesEventos,
                    opcoesEventos[0]);
            for (Eventos evento : eventos) {
                if (evento != null && evento.nome.equals(eventoSelecionado)) {
                    return evento;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum evento criado ainda!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // Método para vender ingressos para evento selecionado
    public void VenderIngressos() {

        String[] tiposIngresso = {"Ingresso Padrão", "Meia Entrada", "VIP"};
        String tipoIngresso = (String) JOptionPane.showInputDialog(null,
                "Selecione o tipo de ingresso:", "Vender Ingresso", JOptionPane.PLAIN_MESSAGE, null, tiposIngresso,
                tiposIngresso[0]);

        // Comparando o tipo inserido com os tipos presentes
        switch (tipoIngresso) {
            case "Ingresso Padrão":
                vendasIngressos[numIngressos] = new IngressoPadrao(500);
                break;
            case "Meia Entrada":
                vendasIngressos[numIngressos] = new MeiaEntrada(500);
                break;
            case "VIP":
                vendasIngressos[numIngressos] = new VIP(500);
                break;
            default:
                System.out.println("Tipo de evento inválido!");
                return; // Sair do método se o tipo de ingresso for inválido
        }


        // Conferindo se o numero de ingressos vai ultrapassar o limite
        if (numIngressos >= LIMITE_INGRESSOS) {

            JOptionPane.showMessageDialog(null, "Ingressos Esgotados!",
                    "Erro", JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Ingresso comprado com sucesso para\n" + this.nome + " - " + this.getTipo(), "Venda Concluída",
                    JOptionPane.INFORMATION_MESSAGE);

            // Adiciona a quantidade de ingressos vendidos até atingir o limite
            numIngressos++;
        }
    }
}