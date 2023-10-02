// Classe principal para testar ingressos e eventos
public class mainTestes {
    public static void main(String[] args) {

        // Cria 3 eventos diferentes para testar a venda de ingressos
        Eventos tylerConcerto = new Eventos.Concerto("Tyler", true, new Ingresso.meiaEntrada(700));
        Eventos filmeEvento = new Eventos.Filme("Filme1", false, new Ingresso.meiaEntrada(500));
        Eventos teatroEvento = new Eventos.Teatro("Teatro1", true, new Ingresso.VIP(800));

        // Venda ingressos para os eventos
        tylerConcerto.VenderIngressos();
        tylerConcerto.VenderIngressos();
        tylerConcerto.VenderIngressos();
        tylerConcerto.VenderIngressos();

        //Vendi 4 e coloquei 3 no limite no Concerto para testar se o LIMITE estava funcionando

        filmeEvento.VenderIngressos();
        filmeEvento.VenderIngressos();
        filmeEvento.VenderIngressos();
        filmeEvento.VenderIngressos();
        filmeEvento.VenderIngressos();
        filmeEvento.VenderIngressos();

        teatroEvento.VenderIngressos();

        // Imprimindo a quantidade de ingressos vendidos para cada evento
        System.out.println("Quantidade de ingressos vendidos para Concerto: " + tylerConcerto.getNumIngressos());
        System.out.println("Quantidade de ingressos vendidos para Filme: " + filmeEvento.getNumIngressos());
        System.out.println("Quantidade de ingressos vendidos para Teatro: " + teatroEvento.getNumIngressos());
    }
}
