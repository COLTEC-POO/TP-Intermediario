import javax.swing.*;

public class Main {
    public static void main(String[] args){
        boolean continuar = true;
        Filme[] films = new Filme[3];
        Concerto[] Concert = new Concerto[3];
        Teatro[] Teat = new Teatro[2];

        for (int i = 0; i < films.length; i++) {
            films[i] = new Filme();
        }

        films[0].setNome("Deadpool & Wolverine");
        films[0].setData("08/08/2024");
        films[0].setHora("15:20");
        films[0].setPreIn(20.30);
        films[0].setLocal("Cinemark DelRey");
        films[0].setOrcamento("300M");

        films[1].setNome("Coringa 2");
        films[1].setData("06/09/2024");
        films[1].setHora("12:20");
        films[1].setPreIn(25.30);
        films[1].setLocal("Cinemark DelRey");
        films[1].setOrcamento("200M");

        films[2].setNome("Meu Malvado Favorito 4");
        films[2].setData("26/07/2024");
        films[2].setHora("18:20");
        films[2].setPreIn(18.30);
        films[2].setLocal("Cinemark DelRey");
        films[2].setOrcamento("250M");

        for (int i = 0; i < Concert.length; i++) {
            Concert[i] = new Concerto();
        }

        Concert[0].setNome("Sakira");
        Concert[0].setData("17/06/2025");
        Concert[0].setHora("15:20");
        Concert[0].setPreIn(200.30);
        Concert[0].setLocal("Mineirão");
        Concert[0].setOrcamento("20M");

        Concert[1].setNome("Kenny west");
        Concert[1].setData("06/09/2024");
        Concert[1].setHora("21:20");
        Concert[1].setPreIn(250.30);
        Concert[1].setLocal("Mineirão");
        Concert[1].setOrcamento("15M");

        Concert[2].setNome("Taylor Swift");
        Concert[2].setData("26/07/2024");
        Concert[2].setHora("20:20");
        Concert[2].setPreIn(180.30);
        Concert[2].setLocal("Mineirão");
        Concert[2].setOrcamento("25M");

        for (int i = 0; i < Teat.length; i++) {
            Teat[i] = new Teatro();
        }

        Teat[0].setNome("Cats");
        Teat[0].setData("17/03/2025");
        Teat[0].setHora("19:20");
        Teat[0].setPreIn(50.30);
        Teat[0].setLocal("Broodway");
        Teat[0].setOrcamento("10M");

        Teat[1].setNome("Harry Potter e A criança amaldiçoada");
        Teat[1].setData("25/04/2024");
        Teat[1].setHora("17:20");
        Teat[1].setPreIn(25.30);
        Teat[1].setLocal("Broodway");
        Teat[1].setOrcamento("7M");


        while(continuar) {
            continuar = false;
            Object[] options = {"Filme", "Concerto", "Teatro", "Listar ingressos"};
            int escolhido = JOptionPane.showOptionDialog(null,
                    "Qual tipo de evento você vai Comprar o ingreso ",
                    "Bilheteria Cinemark",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            if (escolhido == 0) {




                Object[] Filmes = {films[0].getNome(), films[1].getNome(), films[2].getNome(),"Voltar"};
                int FilmeEsc = JOptionPane.showOptionDialog(null,
                        "Qual filme você quer ver",
                        "Bilheteria Cinemark",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, Filmes, Filmes[0]);
                //filme 1
                if (FilmeEsc == 0) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun","Voltar"};
                    int ing = JOptionPane.showOptionDialog(null,
                            films[0].getNome() + "\n" +
                                    "Lançamento:" + films[0].getData() + "\n" +
                                    "Hora:" + films[0].getHora() + "\n" +
                                    "Preço do ingresso: R$" + films[0].getPreIn() + "\n" +
                                    "Orçamento: $" + films[0].getOrcamento() + "\n" +
                                    "Quantidade de ingressos: " + films[0].getQuanIn() + "\n",
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]
                    );
                    if (ing == 0) {
                            films[0].vetorIngressos[films[0].ingressosVendidos] = new InGreMeia((float) films[0].getPreIn());
                            films[0].ingressosVendidos++;
                            films[0].ingressosMeia++;
                        continuar = true;
                    }
                    if(ing == 1){
                        films[0].vetorIngressos[films[0].ingressosVendidos] = new InGreNormal((float) films[0].getPreIn());
                        films[0].ingressosVendidos++;
                        films[0].ingressosPadrao++;
                        System.out.println(films[0].ingressosVendidos);
                        continuar = true;
                    }
                    if(ing == 2){
                        continuar = true;
                    }
                }
                //filme 2
                if (FilmeEsc == 1) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun","Voltar"};
                    int ing = JOptionPane.showOptionDialog(null,
                            films[1].getNome() + "\n" +
                                    "Lançamento:" + films[1].getData() + "\n" +
                                    "Hora:" + films[1].getHora() + "\n" +
                                    "Preço do ingresso: R$" + films[1].getPreIn() + "\n" +
                                    "Orçamento: $" + films[1].getOrcamento() + "\n" +
                                    "Quantidade de ingressos: " + films[1].getQuanIn() + "\n",
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]
                    );
                    if (ing == 0) {
                        films[1].vetorIngressos[films[1].ingressosVendidos] = new InGreMeia((float) films[1].getPreIn());
                        films[1].ingressosVendidos++;
                        films[1].ingressosMeia++;
                        System.out.println(films[1].ingressosVendidos);
                        continuar = true;
                    }
                    if(ing == 1){
                        films[1].vetorIngressos[films[1].ingressosVendidos] = new InGreNormal((float) films[1].getPreIn());
                        films[1].ingressosVendidos++;
                        films[1].ingressosPadrao++;
                        System.out.println(films[1].ingressosVendidos);
                        continuar = true;
                    }
                    if(ing == 2){
                        continuar = true;
                    }
                }
                //Filme 3
                if (FilmeEsc == 2) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun"};
                    int ing = JOptionPane.showOptionDialog(null,
                            films[2].getNome() + "\n" +
                                    "Lançamento:" + films[2].getData() + "\n" +
                                    "Hora:" + films[2].getHora() + "\n" +
                                    "Preço do ingresso: R$" + films[2].getPreIn() + "\n" +
                                    "Orçamento: $" + films[2].getOrcamento() + "\n" +
                                    "Quantidade de ingressos: " + films[2].getQuanIn() + "\n",
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]
                    );
                    if (ing == 0) {
                        films[2].vetorIngressos[films[2].ingressosVendidos] = new InGreMeia((float) films[2].getPreIn());
                        films[2].ingressosVendidos++;
                        films[2].ingressosMeia++;
                        continuar = true;
                    }
                    if(ing == 1){
                        films[2].vetorIngressos[films[2].ingressosVendidos] = new InGreNormal((float) films[2].getPreIn());
                        films[2].ingressosVendidos++;
                        films[2].ingressosPadrao++;
                        continuar = true;
                    }
                }
                if(FilmeEsc == 3){
                    continuar = true;
                }
            }

            //concertos
            if (escolhido == 1) {


                Object[] Conc = {Concert[0].getNome(), Concert[1].getNome(), Concert[2].getNome(),"Voltar"};
                int ConceEsc = JOptionPane.showOptionDialog(null,
                        "A qual concerto você quer ir",
                        "Bilheteria Mineirão",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, Conc, Conc[0]);
                if (ConceEsc == 0) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun", "Ingresso Vip","Voltar"};
                    int ing = JOptionPane.showOptionDialog(null,
                            Concert[0].getNome() + "\n" +
                                    "Lançamento:" + Concert[0].getData() + "\n" +
                                    "Hora:" + Concert[0].getHora() + "\n" +
                                    "Preço do ingresso: R$" + Concert[0].getPreIn() + "\n" +
                                    "Orçamento: $" + Concert[0].getOrcamento() + "\n" +
                                    "Quantidade de ingressos: " + Concert[0].getQuanIn() + "\n",
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]
                    );
                    if (ing == 0) {
                            Concert[0].vetorIngressos[Concert[0].ingressosVendidos] = new InGreMeia((float) Concert[0].getPreIn());
                            Concert[0].ingressosVendidos++;
                            Concert[0].ingressosMeia++;
                        continuar = true;
                    }
                    if(ing == 1){
                            Concert[0].vetorIngressos[Concert[0].ingressosVendidos] = new InGreNormal((float) Concert[0].getPreIn());
                            Concert[0].ingressosVendidos++;
                            Concert[0].ingressosPadrao++;
                        continuar = true;
                    }
                    if(ing == 2){
                        if (Concert[0].verificaIngresso()) {
                            Concert[0].vetorIngressos[Concert[0].ingressosVendidos] = new InGreVip();
                            Concert[0].ingressosVendidos++;
                            Concert[0].ingressosVip++;
                            continuar = true;
                        }else {
                            JOptionPane.showMessageDialog(null,"todos os ingressos vip foram vendidos");
                            continuar = true;
                        }
                    }
                    if(ing == 3){
                        continuar = true;
                    }
                }
                if (ConceEsc == 1) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun", "Ingresso Vip","Voltar"};
                    int ing = JOptionPane.showOptionDialog(null,
                            Concert[1].getNome() + "\n" +
                                    "Lançamento:" + Concert[1].getData() + "\n" +
                                    "Hora:" + Concert[1].getHora() + "\n" +
                                    "Preço do ingresso: R$" + Concert[1].getPreIn() + "\n" +
                                    "Orçamento: $" + Concert[1].getOrcamento() + "\n" +
                                    "Quantidade de ingressos: " + Concert[1].getQuanIn() + "\n",
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]

                    );
                    if (ing == 0) {
                        Concert[1].vetorIngressos[Concert[1].ingressosVendidos] = new InGreMeia((float) Concert[1].getPreIn());
                        Concert[1].ingressosVendidos++;
                        Concert[1].ingressosMeia++;
                        continuar = true;
                    }
                    if(ing == 1){
                        Concert[1].vetorIngressos[Concert[1].ingressosVendidos] = new InGreNormal((float) Concert[1].getPreIn());
                        Concert[1].ingressosVendidos++;
                        Concert[1].ingressosPadrao++;
                        continuar = true;
                    }
                    if(ing == 2){
                    if (Concert[1].verificaIngresso()) {
                        Concert[1].vetorIngressos[Concert[1].ingressosVendidos] = new InGreVip();
                        Concert[1].ingressosVendidos++;
                        Concert[1].ingressosVip++;
                        continuar = true;
                    }else {
                        JOptionPane.showMessageDialog(null,"todos os ingressos vip foram vendidos");
                        continuar = true;
                    }

                    }
                    if(ing == 3){
                        continuar = true;
                    }
                }
                if (ConceEsc == 2) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun", "Ingresso Vip","Voltar"};
                    int ing = JOptionPane.showOptionDialog(null,
                            Concert[2].getNome() + "\n" +
                                    "Lançamento:" + Concert[2].getData() + "\n" +
                                    "Hora:" + Concert[2].getHora() + "\n" +
                                    "Preço do ingresso: R$" + Concert[2].getPreIn() + "\n" +
                                    "Orçamento: $" + Concert[2].getOrcamento() + "\n" +
                                    "Quantidade de ingressos: " + Concert[2].getQuanIn() + "\n",
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]
                    );
                    if (ing == 0) {
                        Concert[2].vetorIngressos[Concert[2].ingressosVendidos] = new InGreMeia((float) Concert[2].getPreIn());
                        Concert[2].ingressosVendidos++;
                        Concert[2].ingressosMeia++;
                        continuar = true;
                    }
                    if(ing == 1){
                        Concert[2].vetorIngressos[Concert[2].ingressosVendidos] = new InGreNormal((float) Concert[2].getPreIn());
                        Concert[2].ingressosVendidos++;
                        Concert[2].ingressosPadrao++;
                        continuar = true;
                    }
                    if(ing == 2){
                        if (Concert[2].verificaIngresso()) {
                            Concert[2].vetorIngressos[Concert[2].ingressosVendidos] = new InGreVip();
                            Concert[2].ingressosVendidos++;
                            Concert[2].ingressosVip++;
                            continuar = true;
                        }else {
                            JOptionPane.showMessageDialog(null,"todos os ingressos vip foram vendidos");
                            continuar = true;
                        }
                    }
                    if(ing == 3){
                        continuar = true;
                    }
                }
                if(ConceEsc == 3){
                    continuar = true;
                }
            }
            if (escolhido == 2) {

                Object[] teatre = {Teat[0].getNome(), Teat[1].getNome(),"Voltar"};
                int TeatEsc = JOptionPane.showOptionDialog(null,
                        "A qual concerto você quer ir",
                        "Bilheteria Broodway",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, teatre, teatre[0]);
                if (TeatEsc == 0) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun", "Ingresso Vip","Voltar"};
                    int ing = JOptionPane.showOptionDialog(null,
                            Teat[0].getNome() + "\n" +
                                    "Lançamento:" + Teat[0].getData() + "\n" +
                                    "Hora:" + Teat[0].getHora() + "\n" +
                                    "Preço do ingresso: R$" + Teat[0].getPreIn() + "\n" +
                                    "Orçamento: $" + Teat[0].getOrcamento() + "\n" +
                                    "Quantidade de Ingressos:" + Teat[0].getQuanIn(),
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]
                    );
                    if (ing == 0) {
                        if (Teat[0].verificaIngresso()) {
                            Teat[0].vetorIngressos[Teat[0].ingressosVendidos] = new InGreMeia((float) Teat[0].getPreIn());
                            Teat[0].ingressosVendidos++;
                            Teat[0].ingressosMeia++;
                            continuar = true;
                        }else {
                            JOptionPane.showMessageDialog(null,"todos os ingressos meia foram vendidos");
                            continuar = true;
                        }

                    }
                    if(ing == 1){
                        Teat[0].vetorIngressos[Teat[0].ingressosVendidos] = new InGreNormal((float) Teat[0].getPreIn());
                        Teat[0].ingressosVendidos++;
                        Teat[0].ingressosPadrao++;
                        continuar = true;
                    }
                    if(ing == 2){
                        Teat[0].vetorIngressos[Teat[0].ingressosVendidos] = new InGreVip();
                        Teat[0].ingressosVendidos++;
                        Teat[0].ingressosVip++;
                        continuar = true;
                    }
                    if(ing == 3){
                        continuar = true;
                    }
                }
                if (TeatEsc == 1) {
                    Object[] Ingressos = {"Ingresso Meia", "Ingresso Comun", "Ingresso Vip","Voltar"};
                    int ing = JOptionPane.showOptionDialog(null,
                            Teat[1].getNome() + "\n" +
                                    "Lançamento:" + Teat[1].getData() + "\n" +
                                    "Hora:" + Teat[1].getHora() + "\n" +
                                    "Preço do ingresso: R$" + Teat[1].getPreIn() + "\n" +
                                    "Orçamento: $" + Teat[1].getOrcamento() + "\n" +
                                    "Quantidade de Ingressos:" + Teat[1].getQuanIn(),
                            "Informações do filme",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, Ingressos, Ingressos[0]
                    );
                    if (ing == 0) {
                        if (Teat[1].verificaIngresso()) {
                            Teat[1].vetorIngressos[Teat[1].ingressosVendidos] = new InGreMeia((float) Teat[1].getPreIn());
                            Teat[1].ingressosVendidos++;
                            Teat[1].ingressosMeia++;
                            continuar = true;
                        }else {
                            JOptionPane.showMessageDialog(null,"todos os ingressos meia foram vendidos");
                            continuar = true;
                        }


                    }
                    if(ing == 1){
                        Teat[1].vetorIngressos[Teat[1].ingressosVendidos] = new InGreNormal((float) Teat[1].getPreIn());
                        Teat[1].ingressosVendidos++;
                        Teat[1].ingressosPadrao++;
                        continuar = true;
                    }
                    if(ing == 2){
                        Teat[1].vetorIngressos[Teat[1].ingressosVendidos] = new InGreVip();
                        Teat[1].ingressosVendidos++;
                        Teat[1].ingressosVip++;
                        continuar = true;
                    }
                    if(ing == 3){
                        continuar = true;
                    }
                }
                if(TeatEsc == 2){
                    continuar = true;
                }
            }
            if (escolhido == 3){
                Object[] Ingressos = {"Deadpool e wolverine", "Coringa 2", "Meu malvado favorito4", "Shakira", "Kaine West", "Tailor Swift", "Cats", "Harry potter e a criança amaldiçoada"};
                int esc = JOptionPane.showOptionDialog(null,
                        "Você quer ver",
                        "Informações do filme",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, Ingressos, Ingressos[0]
                );
                switch (esc){
                    case 0:
                        films[0].imprimirIngressos();
                        continuar = true;
                        break;
                    case 1:
                        films[1].imprimirIngressos();
                        continuar = true;
                        break;
                    case 2:
                        films[2].imprimirIngressos();
                        continuar = true;
                        break;
                    case 3:
                        Concert[0].imprimirIngressos();
                        continuar = true;
                        break;
                    case 4:
                        Concert[1].imprimirIngressos();
                        continuar = true;
                        break;
                    case 5:
                        Concert[2].imprimirIngressos();
                        continuar = true;
                        break;
                    case 6:
                        Teat[0].imprimirIngressos();
                        continuar = true;
                        break;
                    case 7:
                        Teat[1].imprimirIngressos();
                        continuar = true;
                        break;
                }
            }

        }
    }
}
