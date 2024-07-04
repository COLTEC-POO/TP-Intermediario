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
                ColocaAsInfo();
            }
        });

        // Defina o painel inicial como o painel atual
        PainelAtual = PainelCriaEvento;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.setVisible(true);
    }

    private void ColocaAsInfo() {
        // Crie um novo painel com as opções de conta
        JPanel PainelTipoDeConta = new JPanel();
        JButton nome = new JButton("Nome");
        JButton data = new JButton("Data");
        JButton hora = new JButton("hora");
        JButton local = new JButton("local");
        // Adicione um ActionListener ao botão
        nome.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação da conta
                String nome = JOptionPane.showInputDialog("Digite seu nome:\n");
                String endereco = JOptionPane.showInputDialog("Digite seu endereço:\n");
                String CPF = JOptionPane.showInputDialog("Digite seu CPF:\n");
                int idade = -1;
                while(idade == -1) {
                    try {
                        idade = Integer.valueOf(JOptionPane.showInputDialog("Digite sua idade:\n"));
                    } catch (NumberFormatException g) {
                        JOptionPane.showMessageDialog(null, "Digite um numero valido:\n",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                char sexo = JOptionPane.showInputDialog("Digite seu sexo:\n").charAt(0);
                PessoaFisica Usuario1 = new PessoaFisica(nome,endereco,new Date(), CPF, idade,sexo);
                System.out.println(Usuario1.toString());
                Painel_De_Operacao();
            }
        });

        data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão for clicado ira
                //abrir um  questionario para a criação da conta
                String nome = JOptionPane.showInputDialog("Digite seu nome:\n");
                String endereco = JOptionPane.showInputDialog("Digite seu endereço:\n");
                String CNPJ = JOptionPane.showInputDialog("Digite seu CNPJ:\n");
                int NumFun = -1;
                while(NumFun == -1) {
                    try {
                        NumFun = Integer.valueOf(JOptionPane.showInputDialog("Digite seu numero de funcionarios:\n"));
                    } catch (NumberFormatException g) {
                        JOptionPane.showMessageDialog(null, "Digite um numero:\n",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                String departamento = JOptionPane.showInputDialog("Digite seu departamento:\n");
                PessoaJuridica Usuario1 = new PessoaJuridica(nome,endereco,new Date(), CNPJ, NumFun,departamento);
                System.out.println(Usuario1.toString());
                Painel_De_Operacao();
            }
        });

        PainelTipoDeConta.add(nome);
        PainelTipoDeConta.add(data);

        // Remova o painel atual e adicione o novo painel
        TelaExibida.remove(PainelAtual);
        PainelAtual = PainelTipoDeConta;
        PainelAtual.setBackground(Color.GREEN);
        TelaExibida.add(PainelAtual);
        TelaExibida.revalidate();
        TelaExibida.repaint();


    }
    private void Painel_De_Operacao() {
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


