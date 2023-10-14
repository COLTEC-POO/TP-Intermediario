import javax.swing.JOptionPane;
import java.util.*;


public abstract class Eventos  {

    private static final int MAX_INGRESSOS = 250; // Capacidade máxima dos tipos de evento criados

    protected String nome;
    protected String data;
    protected String hora;
    protected double preco;
    protected String local;
    protected String tipoEvento;
    protected int capacidade;
    protected Ingresso[] totalIngressos = new Ingresso[MAX_INGRESSOS]; // Vetor que salva todos os ingressos de um determinado evento
    protected int ingressosVendidos = 0;

    // Construtor de Eventos

    Eventos (String nome, String data, String hora, double preco, String local, String tipoEvento, int capacidade){
        setNome(nome);
        setData(data);
        setHora(hora);
        setPreco(preco);
        setLocal(local);
        setTipoEvento(tipoEvento);
        setCapacidade(capacidade);
    }

    // Getters e Setters

    public String getNome() {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public String getHora( ){
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public double getPreco () {
        return this.preco;
    }

    public void setPreco (double preco) {
        this.preco = preco;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipoEvento() {
        return this.tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getIngressosVendidos() {
        return this.ingressosVendidos;
    }

    public int getIngressosDisponiveis() {
        return (this.capacidade - this.ingressosVendidos);
    }

    // Método que atualiza o total de ingressos vendidos do evento apenas se o ingresso for válido e houverem ingressos disponíveis.

    public boolean checkIngresso(Ingresso novoIngresso) {       // Limita a quantidade de ingressos de acordo com a capacidade de cada evento
        if (ingressosVendidos < capacidade){
            totalIngressos[ingressosVendidos] = novoIngresso;  // Cria um novo ingresso com os dados obtidos na posição correta do array
            if (novoIngresso != null) {   
                ingressosVendidos++;                           // Só incrementa o contador se o objeto recebido por parâmetro for válido (caso o default do switch seja alcançado)
            }
            return true;
        } else {
            return false;
        }
    }

    // Override de toString da classe Object para imprimir as informações do evento em uma única string

    @Override
    public String toString() {

        String info = 
                    "===========================================================" + "\n" + 
                    "Tipo do evento: " + this.getTipoEvento() + "\n" +
                    "Nome: " + this.getNome() + "\n" +
                    "Data: " + this.getData() + "\n" +
                    "Horário: " + this.getHora() + "\n" +
                    "Preço do ingresso: " + this.getPreco() + "\n" +
                    "Local do evento: " + this.getLocal() + "\n" +
                    "Ingressos vendidos: " + this.getIngressosVendidos() + "\n" +
                    "Ingressos disponíveis: " + this.getIngressosDisponiveis() + "\n" +
                    "Receita gerada pelo evento: " + this.calculaReceitaIndividual() + "\n" +
                    "===========================================================" + "\n";
        return info;
    }

    // Método que realiza a compra de ingressos para um evento específico

    public static Ingresso compraIngresso(Eventos[] totalEventos, int qntEventos) {

        if(qntEventos > 0) {
            for (int i = 0; i < qntEventos; i++) {
                System.out.println("Evento " + (i + 1) + ":" + "\n" + totalEventos[i].toString());
            }
            
            int escolhaEvento = Integer.parseInt(JOptionPane.showInputDialog("Escolha o evento que deseja comprar ingressos"));

            Eventos eventoEscolhido = totalEventos[escolhaEvento - 1];

            System.out.println("Evento escolhido: " + eventoEscolhido.getNome());

            int ingressosDisponiveis = eventoEscolhido.getIngressosDisponiveis();

                if (ingressosDisponiveis > 0) {

                    JOptionPane.showMessageDialog(
                    null,
                    "Quantidade de ingressos disponíveis para " + eventoEscolhido.getNome() +": " + ingressosDisponiveis,
                    "Ingressos disponíveis",
                    JOptionPane.INFORMATION_MESSAGE);

                    String[] options = { "Normal", "Meia Entrada", "VIP"};

                    int tipoIngresso = JOptionPane.showOptionDialog(
                    null,
                    "Qual tipo de ingresso você deseja comprar?",
                    "Tipos de ingresso",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
                    );

                    // Evita com que o usuário perca tempo tentando comprar ingressos de tipos inválidos

                    if (tipoIngresso == JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(
                    null,
                    "A janela foi fechada durante a seleção dos ingressos! Tente novamente.",
                    "Erro ao selecionar o tipo dos ingressos!",
                    JOptionPane.ERROR_MESSAGE);
                    return null;
                    }

                    double valor = eventoEscolhido.getPreco();
                
                    int qntIngressos = Integer.parseInt(JOptionPane.showInputDialog("Escolha quantos ingressos deseja comprar"));
    
                    if (qntIngressos <= ingressosDisponiveis && qntIngressos > 0) {
                        double valorTotal = 0;
                        for (int i = 0; i < qntIngressos; i++) {
                            Ingresso novoIngresso = null;
                            switch (tipoIngresso) {
                                case 0:
                                    novoIngresso = new Normal(new Date(), valor, "Normal");
                                    break;
                                case 1:
                                    novoIngresso = new MeiaEntrada(new Date(), valor, "Meia Entrada");
                                    break;
                                case 2:
                                    novoIngresso = new VIP(new Date(), valor, "VIP");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(
                                    null,
                                    "Tipo de ingresso inválido!",
                                    "Opção inválida!",
                                    JOptionPane.ERROR_MESSAGE);
                                    return null;
                            }
    
                            if (eventoEscolhido.checkIngresso(novoIngresso)) {       // Confere se o objeto criado dentro do switch é válido (caso não seja, não atualiza ingressoVendidos e não salva o novoIngresso em totalIngressos)
                            System.out.println("Ingresso comprado com sucesso!");  // Não utilizei JOptionPane aqui por motivos de spam de abas de confirmação
                            valorTotal += novoIngresso.calculaPreco();               // Eu não tava conseguindo utilizar o calculaPreco() na criação do objeto e o workaround foi calcular depois
                            }                                                        // Era mais fácil só atribuir os diferentes valores em cada construtor de subclasse e fazer novoIngresso.valor

                        }
                            JOptionPane.showMessageDialog(
                            null,
                            "Valor total da compra de "+ qntIngressos+ " ingressos: " + valorTotal,
                            "Total do pedido",
                            JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                        null,
                        "A quantidade desejada excedeu a quantidade de ingressos disponíveis ou o valor é inválido!",
                        "Quantidade indisponível!",
                        JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Não há ingressos disponíveis para o evento =(",
                    "Evento esgotado!",
                    JOptionPane.ERROR_MESSAGE);
                }
        } else {
            JOptionPane.showMessageDialog(
            null,
            "Não há nenhum evento disponível no momento =(",
            "Nenhum evento ativo!",
            JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // Método que calcula a receita de um evento específico

    public double calculaReceitaIndividual() {
        double receitaIndividual = 0;
        for (int i = 0; i < ingressosVendidos; i++) {
            receitaIndividual += totalIngressos[i].calculaPreco();
        }
        return receitaIndividual;
    }

    // Método que imprime as informações de ingressos comprados de um evento específico (data, tipo e valor pago)

    public void imprimeIngressos() {
        for (int i = 0; i < ingressosVendidos; i++) {
            String ingressoString = totalIngressos[i].toString();
            System.out.println(ingressoString);
        }
    }
}