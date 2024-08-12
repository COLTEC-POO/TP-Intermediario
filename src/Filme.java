import javax.swing.*;

public class Filme extends Evento{

    public Filme(String nome, String data, String hora, String local, double preco) {
        super(nome, data, hora, local, preco);
        super.capacidade = 200;
    }

    @Override
    public void extratoReceita() {
        System.out.println("===== Extrato da Receita do Filme '" + this.getNome() + "' =====");
        for(Ingresso atual : this.ingressos) {
            if (atual != null) {
                System.out.println(atual.toString());
            }
        }
        System.out.println("Receita total: " + totalReceita());
        System.out.println("=========================================================\n");

    }

    @Override
    public void addIngresso(Ingresso newIngresso) {
        if(ingressos.size() <= capacidade) {
            if (newIngresso.tipo != 'v') {
                this.ingressos.add(newIngresso);
                JOptionPane.showMessageDialog(null, "<< COMPRA REALIZADA >>","Operção concluída com sucesso", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não há ingresso VIP no cinema!!","<< ERRO 561 >>", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há mais ingressos disponíveis","<< ERRO 564 >>", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int ingressoVIPDisp() {
        return 0;
    }
}
