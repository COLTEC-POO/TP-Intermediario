import javax.swing.*;

// Classe principal para testar ingressos e eventos
public class mainTestes {
    public static void main(String[] args) {
        double preco = 500;

        Ingresso.ingressoPadrao padrao = new Ingresso.ingressoPadrao(preco);
        Ingresso.meiaEntrada meia = new Ingresso.meiaEntrada(preco);
        Ingresso.VIP  vip = new Ingresso.VIP(preco);

        Eventos[] eventos = new Eventos[3];

        int escolha = -1;

        while (escolha != 0) {

            escolha = Integer.parseInt(JOptionPane.showInputDialog("1) Criar eventos \n 2) Comprar ingressos \n 3) Ver receita total de cada evento \n 4) Exibir eventos \n  "));

            switch(escolha) {
                case 1:
                    eventos = Eventos.criarEvento();
                    break;

                case 2:

                    break;

                case 3:
                    Eventos.imprimirExtrato();

                case 4:
                    if(eventos != null) {
                        Eventos.imprimirEventos(eventos);
                    } else {
                        System.out.println("baah");
                    }
                    break;

            }
        }

    }
}
