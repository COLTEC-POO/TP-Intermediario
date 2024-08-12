import javax.swing.*;

public class Teatro extends Evento{

    public Teatro(String nome, String data, String hora, String local, double preco) {
        super(nome, data, hora, local, preco);
        this.capacidade = 250;
    }

    @Override
    public void extratoReceita() {
        System.out.println("===== Extrato da Receita do Teatro '" + this.getNome() + "' =====");
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
            if ((newIngresso.tipo == 'm' && ingressoMeiaDisp() <= capacidade * 0.2 && ingressoMeiaDisp() > 0) || (newIngresso.tipo != 'm')) {
                this.ingressos.add(newIngresso);
                JOptionPane.showMessageDialog(null, "<< COMPRA REALIZADA >>","Operção concluída com sucesso", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não há mais ingresso Meia-Entrada disponível!!","<< ERRO 563 >>", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há mais ingressos disponíveis","<< ERRO 564 >>", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int ingressoMeiaDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'm') {
                i++;
            }
        }
        return (int)(capacidade * 0.2 - i);
    }
}
