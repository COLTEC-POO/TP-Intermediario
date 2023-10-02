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
    public Eventos(String nome, Boolean eAcessivel, Ingresso ingresso) {
        this.nome = nome;
        this.data = new Date();
        this.eAcessivel = eAcessivel;
        this.ingresso = ingresso;

        // Inicializa um array para armazenar vendas de ingressos, necessario para imprimir os diferentes tipos juntos
        this.vendasIngressos = new Ingresso[1000];
        // Inicializa o número de ingressos vendidos como 0, necessario para "extrato" depois
        this.numIngressos = 0;
        // Inicializa 0 número limite de ingressos vendidos como 0, para obter seu limite real em cada subclasse de evento
        this.LIMITE_INGRESSOS = 0;


        // Inicializando a quantidade de ingressos para cada tipo
        int totalNormal = 0;
        int totalMeia = 0;
        int totalVIP = 0;
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

    // Métodos para pegar o total de vendas de cada tipo de ingresso
    public int getTotalNormal() {
        return totalNormal;
    }

    public int getTotalMeia() {
        return totalMeia;
    }

    // Método para obter o total de vendas de ingressos VIP
    public int getTotalVIP() {
        return totalVIP;
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
        return "Nome: " + this.nome + " \nData: " + this.data + "\nÉ acessível? " + eAcessivel() + "\nIngresso: " + ingresso.toString();
    }

    // Método para obter a quantidade de ingressos vendidos
    public int getNumIngressos() {
        return numIngressos;
    }

    // Método para delimitar o limite dos ingressos dos Eventos
    public void VenderIngressos(Ingresso tipoIngresso){
        if(numIngressos >= LIMITE_INGRESSOS){
            System.out.println("Limite de ingressos atingido!");
        } else{
            // Salvando o ingresso vendido no array de ingressos
            vendasIngressos[numIngressos] = tipoIngresso;

            // Adiciona a quantidade de ingressos vendidos até atingir o limite
            numIngressos++;

            // Checando qual tipo de ingresso vai aumentar
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
        System.out.println("Extrato do Evento: " + tipoEvento + " - " + this.nome);

        double receitaTotal = 0;

        // Loop para imprimir detalhes de cada ingresso vendido
        for (int i = 0; i < numIngressos; i++) {
            Ingresso ingresso = vendasIngressos[i];
            System.out.println(" " + ingresso.data + " | " + ingresso.getTipoIngresso() + " - " + ingresso.getPreco());
            receitaTotal += ingresso.getPreco();
        }

        System.out.println();
        System.out.println("Total de ingressos vendidos: " + numIngressos);
        System.out.println("Receita total gerada: " + receitaTotal);
    }


    public static class Filme extends Eventos{

        public Filme(String nome, Boolean eAcessivel, Ingresso ingresso){
            //Atributos da superclasse
            super(nome,eAcessivel, ingresso);

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

        public Concerto(String nome, Boolean eAcessivel, Ingresso ingresso){
            //Atributos da superclasse
            super(nome,eAcessivel, ingresso);

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

        public Teatro(String nome, Boolean eAcessivel, Ingresso ingresso){
            //Atributos da superclasse
            super(nome,eAcessivel, ingresso);

            // Define o limite de ingressos específico para Teatro
            this.LIMITE_INGRESSOS = 1;
        }

        @Override
        // Método para obter o tipo de evento (será implementado nas subclasses)
        public String getTipo() {
            return " Teatro ";
        }
    }

}