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
    }

    // Método para obter o tipo de evento (será implementado nas subclasses)
    public String getTipo() {
        return "Evento Inválido";
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
        return "Nome: " + this.nome + " \nData: " + this.data + "\nÉ acessível? " + eAcessivel() + "\nPreço: " + ingresso.getPreco() + "\n Ingresso: " + ingresso.toString();
    }

    // Método para obter a quantidade de ingressos vendidos
    public int getNumIngressos() {
        return numIngressos;
    }

    // Método para delimitar o limite dos ingressos dos Eventos
    public void VenderIngressos(){
        if(numIngressos >= LIMITE_INGRESSOS){
            System.out.println("Limite de ingressos atingido!");
        } else{
            // Adiciona a quantidade de ingressos vendidos até atingir o limite
            numIngressos++;
        }
    }

    public static class Filme extends Eventos{

        public Filme(String nome, Boolean eAcessivel, Ingresso ingresso){
            //Atributos da superclasse
            super(nome,eAcessivel, ingresso);

            // Define o limite de ingressos específico para Filme
            this.LIMITE_INGRESSOS = 200;
        }

        //Anula o método para delimitar o limite dos ingressos do Filme
        @Override
        // Método para delimitar o limite dos ingressos do Filme
        public void VenderIngressos(){

            if(numIngressos >= LIMITE_INGRESSOS){
                System.out.println("Limite de ingressos do Filme atingido!");
            } else{
                // Adiciona a quantidade de ingressos vendidos até atingir o limite
                numIngressos++;
            }
        }

        @Override
        // Obtem a quantidade de ingressos vendidos
        public int getNumIngressos() {
            return numIngressos;
        }
    }

    public static class Concerto extends Eventos{

        public Concerto(String nome, Boolean eAcessivel, Ingresso ingresso){
            //Atributos da superclasse
            super(nome,eAcessivel, ingresso);

            // Define o limite de ingressos específico para Concerto
            this.LIMITE_INGRESSOS = 3;
        }

        //Anula o método para delimitar o limite dos ingressos de Concerto
        @Override
        // Método para delimitar o limite dos ingressos de Concerto
        public void VenderIngressos(){

            if(numIngressos >= LIMITE_INGRESSOS){
                System.out.println("Limite de ingressos do Conserto atingido!");
            } else{
                // Adiciona a quantidade de ingressos vendidos até atingir o limite
                numIngressos++;
            }
        }
        @Override
        // Obtem a quantidade de ingressos vendidos
        public int getNumIngressos() {
            return numIngressos;
        }
    }

    public static class Teatro extends Eventos{

        public Teatro(String nome, Boolean eAcessivel, Ingresso ingresso){
            //Atributos da superclasse
            super(nome,eAcessivel, ingresso);

            // Define o limite de ingressos específico para Teatro
            this.LIMITE_INGRESSOS = 250;
        }

        //Anula o método para delimitar o limite dos ingressos do Teatro
        @Override
        // Método para delimitar o limite dos ingressos do Teatro
        public void VenderIngressos(){

            if(numIngressos >= LIMITE_INGRESSOS){
                System.out.println("Limite de ingressos do Teatro atingido!");
            } else{
                // Adiciona a quantidade de ingressos vendidos até atingir o limite
                numIngressos++;
            }
        }

        @Override
        // Obtem a quantidade de ingressos vendidos
        public int getNumIngressos() {
            return numIngressos;
        }
    }

}