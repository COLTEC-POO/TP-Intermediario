import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Classe principal para testar ingressos e eventos
public class mainOption {
    public static void main(String[] args) {
        // Obtendo a data e hora atual
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataAtual = new Date();

        // Criando um novo evento
        Eventos evento = new Eventos(null, false);
        evento.criarEvento();

        // Vendendo ingressos usando JOptionPane
        String[] tiposIngresso = { "Normal", "Meia Entrada", "VIP" };
        String tipoIngresso = (String) JOptionPane.showInputDialog(null,
                "Selecione o tipo de ingresso:", "Vender Ingresso", JOptionPane.PLAIN_MESSAGE, null, tiposIngresso,
                tiposIngresso[0]);

        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do ingresso:"));

        Ingresso ingresso = null;
        if (tipoIngresso.equalsIgnoreCase("Normal")) {
            ingresso = new Ingresso.ingressoPadrao(preco);
        } else if (tipoIngresso.equalsIgnoreCase("Meia Entrada")) {
            ingresso = new Ingresso.meiaEntrada(preco);
        } else if (tipoIngresso.equalsIgnoreCase("VIP")) {
            ingresso = new Ingresso.VIP(preco);
        }

        evento.VenderIngressos(ingresso);

        // Exibindo detalhes do evento usando JOptionPane
        JOptionPane.showMessageDialog(null, "Detalhes do Evento:\n" + evento.toString());

        // Exibindo detalhes do ingresso usando JOptionPane
        assert ingresso != null;
        JOptionPane.showMessageDialog(null, "Detalhes do Ingresso:\n" + ingresso.toString());
    }
}
