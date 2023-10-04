// Classe principal para testar ingressos e eventos
public class mainTestes {
    public static void main(String[] args) {
        double preco = 500;

        Ingresso.ingressoPadrao padrao = new Ingresso.ingressoPadrao(preco);

        Ingresso.meiaEntrada meia = new Ingresso.meiaEntrada(preco);

        Ingresso.VIP  vip = new Ingresso.VIP(preco);

        Eventos[] eventos = new Eventos[1];

        eventos[0] = Eventos.criarEvento();
//
//        eventos[0] = new Eventos.Concerto("Tyler", true, "15:30");
//        eventos[1] = new Eventos.Filme("Anjos Da Lei", true, "20:30");

        // Limite de 3, então o último ingresso não é contabilizado
        eventos[0].VenderIngressos(padrao);
        eventos[0].VenderIngressos(meia);
        eventos[0].VenderIngressos(vip);
        eventos[0].VenderIngressos(padrao);

        // Chamando a função para imprimir os eventos com os respectivos extratos
        System.out.println();
        Eventos.imprimirEventos(eventos);
    }
}
