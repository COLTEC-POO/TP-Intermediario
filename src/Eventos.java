import javax.swing.*;
import java.util.Date;

// A classe Eventos representa eventos que podem ocorrer em uma data específica.
public class Eventos {

    // Atributos base
    String nome;
    Date data;
    Boolean eAcessivel;
    Ingresso ingresso;

    Ingresso[] vendasIngressos;

    // Contador para o número de ingressos vendidos para este evento
    int numIngressos;

    // Limitador de ingressos que será utilizado nas subclasses de Eventos
    int LIMITE_INGRESSOS;

    // Inicializando para calcular o total de cada tipo de ingresso
    private int totalNormal, totalMeia, totalVIP;

    // Constructor de Eventos
    public Eventos(String nome, Boolean eAcessivel) {
        this.nome = nome;
        this.data = new Date();
        this.eAcessivel = eAcessivel;

        // Inicializa um array para armazenar vendas de ingressos, necessario para imprimir os diferentes tipos juntos
        this.vendasIngressos = new Ingresso[1000];

        // Inicializa o número de ingressos vendidos como 0, necessario para "extrato" depois
        this.numIngressos = 0;

        // Inicializa 0 número limite de ingressos vendidos como 0, para obter seu limite real em cada subclasse de evento
        this.LIMITE_INGRESSOS = 0;

    }

    // Método para obter o tipo de evento (será implementado nas subclasses)
    public String getTipo() {
        return "Evento Inválido";
    }

    // Métodos para incrementar o total de vendas de cada tipo de ingresso
    public void incrementarTotalNormal() {
        totalNormal++;
    }
    public void incrementarTotalMeia() {
        totalMeia++;
    }
    public void incrementarTotalVIP() {
        totalVIP++;
    }

    // Métodos para incrementar o total de vendas de cada tipo de ingresso
    public int getTotalNormal() {
        return totalNormal;
    }
    public int getTotalMeia() {
        return totalMeia;
    }
    public int getTotalVIP() {
        return totalVIP;
    }

    public void criarEvento() {
        this.nome = JOptionPane.showInputDialog("Digite o nome do evento:");
        this.eAcessivel = JOptionPane.showInputDialog("O evento é acessível? (Sim ou Não)")
                .equalsIgnoreCase("sim");
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
        return "Nome: " + this.nome + " \nData: " + this.data + "\nÉ acessível? " + eAcessivel();
    }

    public static void imprimirEventos(Eventos[] eventos) {
        for (Eventos evento : eventos) {
            System.out.println("Detalhes do Evento:");
            System.out.println(evento.toString());
            System.out.println();
            evento.imprimirExtrato();
            System.out.println("----------------------------------------");
        }
    }

    // Método para obter a quantidade de ingressos vendidos
    public int getNumIngressos() {
        return numIngressos;
    }

    // Vendendo Ingressos
    public void VenderIngressos(Ingresso tipoIngresso){
        // Conferindo se o numero de ingressos vai ultrapassar o limite by P.
        if(numIngressos >= LIMITE_INGRESSOS){
            System.out.println("Limite de ingressos atingido!");
        } else{
            // Salvando o ingresso vendido no array de ingressos by P.
            vendasIngressos[numIngressos] = tipoIngresso;

            // Adiciona a quantidade de ingressos vendidos até atingir o limite by P.
            numIngressos++;

            // Checando qual tipo de ingresso vai aumentar, usando logica de equals by D.
            if(tipoIngresso instanceof  Ingresso.ingressoPadrao) {
                incrementarTotalNormal();
            } else if (tipoIngresso instanceof Ingresso.meiaEntrada) {
                incrementarTotalMeia();
            } else if (tipoIngresso instanceof  Ingresso.VIP) {
                incrementarTotalVIP();
            }
        }
    }

    public void imprimirExtrato() {
        String tipoEvento = getTipo(); // Obtém o tipo de evento
        System.out.println("Extrato do Evento: " + this.nome + " - " + tipoEvento);

        double receitaTotal = 0;

        // Loop para imprimir detalhes de cada ingresso vendido
        for (int i = 0; i < numIngressos; i++) {
            Ingresso ingresso = vendasIngressos[i];
            System.out.println(ingresso.data + " | " + ingresso.getTipoIngresso() + " - " + ingresso.getPreco());
            receitaTotal += ingresso.getPreco();
        }
        // Imprimindo o total
        System.out.println();
        System.out.println("Total de ingressos vendidos: " + numIngressos);
        System.out.println("Receita total gerada: " + receitaTotal);
        System.out.println();

        System.out.println("Total de ingressos Padrao: " + getTotalNormal());
        System.out.println("Total de ingressos MeiaEntrada " + getTotalMeia());
        System.out.println("Total de ingressos VIP " + getTotalVIP());
    }


    public static class Filme extends Eventos{

        public Filme(String nome, Boolean eAcessivel){
            //Atributos da superclasse
            super(nome,eAcessivel);

            // Define o limite de ingressos específico para Filme
            this.LIMITE_INGRESSOS = 2;
        }

        @Override
        // Método para obter o tipo de evento (será implementado nas subclasses)
        public String getTipo() {
            return " Filme ";
        }
    }

    public static class Concerto extends Eventos{

        public Concerto(String nome, Boolean eAcessivel){
            //Atributos da superclasse
            super(nome,eAcessivel);

            // Define o limite de ingressos específico para Concerto
            this.LIMITE_INGRESSOS = 3;
        }

        @Override
        // Método para obter o tipo de evento (será implementado nas subclasses)
        public String getTipo() {
            return " Concerto ";
        }
    }

    public static class Teatro extends Eventos{

        public Teatro(String nome, Boolean eAcessivel){
            //Atributos da superclasse
            super(nome,eAcessivel);

            // Define o limite de ingressos específico para Teatro
            this.LIMITE_INGRESSOS = 2;
        }

        @Override
        // Método para obter o tipo de evento (será implementado nas subclasses)
        public String getTipo() {
            return " Teatro ";
        }
    }

}