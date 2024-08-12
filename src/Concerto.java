import javax.swing.*;

public class Concerto extends Evento{

    public Concerto(String nome, String data, String hora, String local, double preco) {
        super(nome, data, hora, local, preco);
        this.capacidade = 150;
    }

    @Override
    public void extratoReceita() {
        System.out.println("==== Extrato da Receita do Concerto '" + this.getNome() + "' ====");
        for(Ingresso atual : this.ingressos) {
            if (atual != null) {
                System.out.println(atual.toString());
            }
        }
        System.out.println("Receita total: " + totalReceita());
        System.out.println("==========================================================\n");

    }

    @Override
    public void addIngresso(Ingresso newIngresso) {
        if(ingressos.size() <= capacidade) {
            if ((newIngresso.tipo == 'v' && ingressoVIPDisp() <= capacidade * 0.1 && ingressoVIPDisp() > 0) || (newIngresso.tipo != 'v')) {
                this.ingressos.add(newIngresso);
                JOptionPane.showMessageDialog(null, "<< COMPRA REALIZADA >>","Operção concluída com sucesso", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não há mais ingresso VIP disponível!!","<< ERRO 562 >>", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há mais ingressos disponíveis","<< ERRO 564 >>", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int ingressoVIPDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'v') {
                i++;
            }
        }
        return  (int)(capacidade * 0.1 - i);
    }
}
