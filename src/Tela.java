import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
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
    private void PaneComOQuest(Evento Evento) {
        // Crie um novo painel com o questionário
        JPanel Quest = new JPanel();
        JButton Nome = new JButton("Nome");
        JButton Data = new JButton("Data");
        JButton Hora = new JButton("Hora");
        JButton Local = new JButton("Local");
        JButton PreIn = new JButton("Preço de Ingressos");
        Nome.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                Evento.setNome(JOptionPane.showInputDialog("Digite qual vai ser o nome do seu evento"));
             }
        });
        Data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = 0;
                while(a == 0) {
                    a = 1;
                    Evento.setData(JOptionPane.showInputDialog(
                    "Digite qual vai ser a Data do seu evento no modelo dd/mm/aaaa"));

                    try {
                        String[] Datas = Evento.getData().split("/");
                        int dia = Integer.valueOf(Datas[0]);
                        int mes = Integer.valueOf(Datas[1]);

                        if((dia <= 31 && mes == 1) ||
                        (dia <= 31 && mes == 3) ||
                        (dia <= 31 && mes == 5) ||
                        (dia <= 31 && mes == 7) ||
                        (dia <= 31 && mes == 8) ||
                        (dia <= 31 && mes == 10) ||
                        (dia <= 31 && mes == 12) ||
                        (dia <= 30 && mes == 4) ||
                        (dia <= 30 && mes == 6) ||
                        (dia <= 30 && mes == 9) ||
                        (dia <= 30 && mes == 11) ||
                        (dia <= 28 && mes == 2) &&
                        Integer.valueOf(Datas[2]) >= Year.now().getValue()
                        ) {
                            JOptionPane.showMessageDialog(null,"Tudo certo");
                            a = 1;
                        }else
                            JOptionPane.showMessageDialog(null,
                    "Garanta que os dias são validos");
                        a = 0;
                    }catch (NumberFormatException b){
                        JOptionPane.showMessageDialog(null,
                        "Digite no modelo dd/mm/aaaa \n como no exemplo 30/03/2004");
                        a = 0;
                    }catch (IndexOutOfBoundsException b){
                        JOptionPane.showMessageDialog(null,
                "Digite no modelo dd/mm/aaaa \n como no exemplo 30/03/2004");
                        a = 0;
                    }

                }

            }
        });
        Hora.addActionListener(new ActionListener() {
                    @Override
            public void actionPerformed(ActionEvent e) {
                        int a = 0;
                        while(a == 0) {
                            a = 1;
                            Evento.setHora(JOptionPane.showInputDialog(
                            "Digite qual vai ser a Hora em que seu evento" +
                            "vai acontecer escreva no modelo HH:MM"));

                            //variavel ultilizada para varificar se a hora esta no modelo certo
                            String Veri = Evento.getHora();

                            try {
                                for (int i = 0; i < 5; i++) {
                                    if (Veri.charAt(i) != ':') {

                                        Boolean oi = Character.isDigit(Veri.charAt(i));
                                        if (oi == false) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Digite no modelo HH:MM" +
                                                            " \n como no exemplo 15:30");
                                            a = 0;

                                        }

                                    }
                                }
                            }catch (IndexOutOfBoundsException b){
                                JOptionPane.showMessageDialog(null,
                                        "Digite no modelo dd/mm/aaaa \n como no exemplo 30/03/2004");
                            }

                        }


                    }
                }
        );

        Quest.add(Nome);
        Quest.add(Data);
        Quest.add(Hora);
        Quest.add(Local);
        Quest.add(PreIn);
        // Remova o painel atual e adicione o novo painel
        TelaExibida.remove(PainelAtual);
        PainelAtual = Quest;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.revalidate();
        TelaExibida.repaint();
    }
}


