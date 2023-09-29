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
}