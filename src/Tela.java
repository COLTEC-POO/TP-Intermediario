import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Tela {
    private final JFrame TelaExibida;
    private JPanel PainelAtual;
    private final int TelaWidth = 1080;
    private final int TelaHeight = 720;

    public Tela() {
        TelaExibida = new JFrame("Banco teu Money");
        TelaExibida.setResizable(false);
        TelaExibida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaExibida.setSize(TelaWidth, TelaHeight);


        // Crie o painel inicial
        JPanel PainelCriaEvento = new JPanel();
        //Cria o botão criar conta
        JButton BCriaEvento = new JButton("Criar Evento");
        PainelCriaEvento.add(BCriaEvento);
        
        // Adicione um ActionListener ao botão
        BCriaEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão for clicado
                //ira para o painel em que os botões para o input estão
                SelctTipoEven();
            }
        });

        // Defina o painel inicial como o painel atual
        PainelAtual = PainelCriaEvento;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.setVisible(true);
    }

    //painel de seleção do tipo de evento
    private void SelctTipoEven() {
        // Crie um novo painel com as opções de conta
        JPanel PainelTipoDeEvento = new JPanel();
        JButton Filme = new JButton("Filme");
        JButton Show = new JButton("Show");
        JButton Teatro = new JButton("Teatro");

        // Adicione um ActionListener ao botão


        Filme.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação do eveto filme
                Evento x = new Filme();
                PaneComOQuest(x);
            }
        });

        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação do evento concerto/show
                Evento x = new Concerto();
                PaneComOQuest(x);
            }

        });
        Teatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação do evento Teatro
                Evento x = new Teatro();
                PaneComOQuest(x);
            }

        });
        //coloca os botões no painel
        PainelTipoDeEvento.add(Filme);
        PainelTipoDeEvento.add(Show);
        PainelTipoDeEvento.add(Teatro);

        // Remova o painel atual e adicione o novo painel
        TelaExibida.remove(PainelAtual);
        PainelAtual = PainelTipoDeEvento;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.revalidate();
        TelaExibida.repaint();


    }
    private void PaneComOQuest(Evento Evetno) {
        // Crie um novo painel com as operações
        JPanel Operacoes = new JPanel();
        JButton Deposito = new JButton("Deposito");
        JButton Saque = new JButton("Saque");
        JButton Transferencia = new JButton("Transferencia");
        Operacoes.add(Deposito);
        Operacoes.add(Saque);
        Operacoes.add(Transferencia);
        // Remova o painel atual e adicione o novo painel
        TelaExibida.remove(PainelAtual);
        PainelAtual = Operacoes;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.revalidate();
        TelaExibida.repaint();
    }
}


