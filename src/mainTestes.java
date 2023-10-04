// Classe principal para testar ingressos e eventos
public class mainTestes {
    public static void main(String[] args) {
        double preco = 500;

        Ingresso.ingressoPadrao padrao = new Ingresso.ingressoPadrao(preco);

        Ingresso.meiaEntrada meia = new Ingresso.meiaEntrada(preco);

        Ingresso.VIP  vip = new Ingresso.VIP(preco);

        Eventos tylerConcerto = new Eventos.Concerto("Tyler", true);
        Eventos tylerFilme = new Eventos.Filme("TylerFilme", true);


        Eventos[] eventos = { tylerConcerto, tylerFilme };

        // Limite de 3, então o último ingresso não é contabilizado
        tylerConcerto.VenderIngressos(padrao);
        tylerConcerto.VenderIngressos(meia);
        tylerConcerto.VenderIngressos(vip);
        tylerConcerto.VenderIngressos(padrao);

        // Chamando a função para imprimir os eventos
        Eventos.imprimirEventos(eventos);
    }
}
