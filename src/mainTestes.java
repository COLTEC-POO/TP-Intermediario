// Classe principal para testar ingressos e eventos
public class mainTestes {
    public static void main(String[] args) {

        // Cria um evento chamado JCole com preço 700, acessível, usando ingresso de meia entrada
        Eventos JCole = new Eventos("J.Cole", true, new Ingresso.meiaEntrada(700));

        // Cria um evento chamado Joji com preço 700, não acessível, usando ingresso VIP
        Eventos Joji = new Eventos("Drake", false, new Ingresso.VIP(700));

        // Imprime detalhes do evento JCole
        System.out.println(JCole.toString());
        System.out.println(); // Adiciona uma linha em branco
        // Imprime detalhes do evento Joji
        System.out.println(Joji.toString());
    }
}
