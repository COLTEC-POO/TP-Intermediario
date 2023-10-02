// Classe principal para testar ingressos e eventos
public class mainTestes {
    public static void main(String[] args) {
        double preco = 500;

        Ingresso.ingressoPadrao padrao = new Ingresso.ingressoPadrao(preco);

        Ingresso.meiaEntrada meia = new Ingresso.meiaEntrada(preco);

        Ingresso.VIP  vip = new Ingresso.VIP(preco);


        // Cria 3 eventos diferentes para testar a venda de ingressos
        Eventos tylerConcerto = new Eventos.Concerto("Tyler", true, padrao);

        tylerConcerto.VenderIngressos(padrao);
        tylerConcerto.VenderIngressos(meia);
        tylerConcerto.VenderIngressos(vip);
        tylerConcerto.VenderIngressos(padrao);



        System.out.println(tylerConcerto.toString());
        System.out.println();
        tylerConcerto.imprimirExtrato();

    }
}
