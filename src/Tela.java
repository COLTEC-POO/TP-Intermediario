import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;

public class Tela {
    private final JFrame TelaExibida;

    private JPanel PainelAtual;

    JPanel PainelCriaEvento = new JPanel();

    JPanel PainelTipoDeEvento = new JPanel();

    String pride = "\uD83C\uDFF3️\u200D\uD83C\uDF08";

    public Tela() {
        TelaExibida = new JFrame("Entretenimento" + pride + "?" );
        TelaExibida.setResizable(false);
        TelaExibida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int telaWidth = 1080;
        int telaHeight = 720;
        TelaExibida.setSize(telaWidth, telaHeight);


        // Crie o painel inicial
        PainelCriaEvento = new JPanel();
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
        PainelTipoDeEvento = new JPanel();
        JButton Filme = new JButton("Filme");
        JButton Show = new JButton("Show");
        JButton Teatro = new JButton("Teatro");
        JButton Voltar = new JButton("Voltar");

        // Adicione um ActionListener ao botão


        Filme.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação do eveto filme
                Evento x = new Filme();
                if(JOptionPane.showConfirmDialog(TelaExibida,"Tem certeza que você quer criar um evento filme?"
                        ," ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    PaneComOQuest(x);
                }else
                    SelctTipoEven();
            }
        });

        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação do evento concerto/show
                Evento x = new Concerto();
                if(JOptionPane.showConfirmDialog(TelaExibida,"Tem certeza que você quer criar um evento Show?"
                ," ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                PaneComOQuest(x);
                }else
                    SelctTipoEven();
            }

        });
        Teatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação do evento Teatro
                Evento x = new Teatro();
                if(JOptionPane.showConfirmDialog(TelaExibida,"Tem certeza que você quer criar um evento teatro?"
                ," ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    PaneComOQuest(x);
                }else
                SelctTipoEven();
            }

        });


        //coloca os botões no painel
        PainelTipoDeEvento.add(Filme);
        PainelTipoDeEvento.add(Show);
        PainelTipoDeEvento.add(Teatro);
        PainelTipoDeEvento.add(Voltar);


        // Remova o painel atual e adicione o novo painel
        TelaExibida.remove(PainelAtual);
        PainelAtual = PainelTipoDeEvento;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.revalidate();
        TelaExibida.repaint();

        Voltar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 TelaExibida.remove(PainelAtual);
                 PainelAtual = PainelCriaEvento;
                 PainelAtual.setBackground(Color.GREEN);
                 TelaExibida.add(PainelAtual);
                 TelaExibida.revalidate();
                 TelaExibida.repaint();

             }
         }

        );
    }

    private void PaneComOQuest(Evento Evento) {
        // Crie um novo painel com o questionário
        JPanel Quest = new JPanel();
        JButton Nome = new JButton("Nome");
        JButton Data = new JButton("Data");
        JButton Hora = new JButton("Hora");
        JButton Local = new JButton("Local");
        JButton PreIn = new JButton("Preço de Ingressos");
        JButton Salv = new JButton("Salvar evento");
        JButton Voltar = new JButton("Voltar");
        Nome.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                Evento.setNome(JOptionPane.showInputDialog(TelaExibida,"Digite qual vai ser o nome do seu evento"));
                JOptionPane.showMessageDialog(TelaExibida, "Nome: " + Evento.getNome());
             }
        });

        Data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a;
                do {

                    Evento.setData(JOptionPane.showInputDialog(TelaExibida,
                    "Digite qual vai ser a Data do seu evento no modelo dd/mm/aaaa"));

                    try {
                        String[] Datas = Evento.getData().split("/");
                        int dia = Integer.parseInt(Datas[0]);
                        int mes = Integer.parseInt(Datas[1]);

                        if(((dia <= 31 && mes == 1) ||
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
                        (dia <= 28 && mes == 2)) &&
                        Integer.parseInt(Datas[2]) >= Year.now().getValue()
                        ) {
                            JOptionPane.showMessageDialog(TelaExibida,"Tudo certo");
                            a = 1;
                        }else {
                            JOptionPane.showMessageDialog(TelaExibida,
                            "Garanta que os dias são validos", "Data invalida", JOptionPane.ERROR_MESSAGE);
                            a = 0;
                        }
                    }catch (NumberFormatException b){
                        JOptionPane.showMessageDialog(TelaExibida,
                        "Digite no modelo dd/mm/aaaa \n como no exemplo 30/03/2004",
                                "Sintaxe Errada",JOptionPane.ERROR_MESSAGE);
                        a = 0;
                    }catch (IndexOutOfBoundsException b){
                        JOptionPane.showMessageDialog(TelaExibida,
                "Digite no modelo dd/mm/aaaa \n como no exemplo 30/03/2004",
                                "Sintaxe Errada",JOptionPane.ERROR_MESSAGE);
                        a = 0;
                    }
                }while(a == 0);

            }
        });

        Hora.addActionListener(new ActionListener() {
                    @Override
            public void actionPerformed(ActionEvent e) {
                        int a = 0;
                        while(a == 0) {
                            a = 1;
                            Evento.setHora(JOptionPane.showInputDialog(TelaExibida,
                            "Digite qual vai ser a Hora em que seu evento" +
                                    "vai acontecer escreva no modelo HH:MM"));

                            //variavel ultilizada para varificar se a hora esta no modelo certo
                            String Veri = Evento.getHora();

                            try {
                                String[] Horas = Veri.split(":");
                                if(Integer.parseInt(Horas[0]) >= 24 || Integer.parseInt(Horas[1]) >= 60) {
                                    JOptionPane.showMessageDialog(TelaExibida,
                                            "Digite no modelo HH:MM" +
                                                    " \n como no exemplo 15:30","Syntaxe Errada",JOptionPane.ERROR_MESSAGE);
                                    a = 0;
                                }
                            }catch (IndexOutOfBoundsException b){
                                JOptionPane.showMessageDialog(TelaExibida,
                                "Digite no modelo HH:MM" +
                                        " \n como no exemplo 15:30");
                                a = 0;
                            }catch (NumberFormatException b){
                                JOptionPane.showMessageDialog(TelaExibida,
                                "Digite no modelo HH:MM" +
                                        " \n como no exemplo 15:30","Syntaxe Errada",JOptionPane.ERROR_MESSAGE);
                                a = 0;
                            }

                        }


                    }
                }
        );
        Local.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Evento.setLocal(JOptionPane.showInputDialog(TelaExibida,
                    "Digite qual vai ser a Local do evento"));
                }
            }
        );
        PreIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = 0;
                while(a == 0) {
                    try {
                        Evento.setPreIn(Float.parseFloat(JOptionPane.showInputDialog(TelaExibida,
                                "Defina o preço para os ingressos")));
                        a = 1;
                    } catch (NumberFormatException b) {
                        JOptionPane.showMessageDialog(TelaExibida,
                                "Digite um preço valido no modelo 20.30");
                        a = 0 ;
                    }
                }
            }
        });
        Salv.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               SalvandoEventos Salvar = new SalvandoEventos(Evento);
           }
       }

        );

        Quest.add(Nome);
        Quest.add(Data);
        Quest.add(Hora);
        Quest.add(Local);
        Quest.add(PreIn);
        Quest.add(Salv);
        Quest.add(Voltar);

        // Remova o painel atual e adicione o novo painel
        TelaExibida.remove(PainelAtual);
        PainelAtual = Quest;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.revalidate();
        TelaExibida.repaint();

        Voltar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 TelaExibida.remove(PainelAtual);
                 PainelAtual = PainelTipoDeEvento ;
                 PainelAtual.setBackground(Color.GREEN);
                 TelaExibida.add(PainelAtual);
                 TelaExibida.revalidate();
                 TelaExibida.repaint();


             }
         }

        );
    }

}


