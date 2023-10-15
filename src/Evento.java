import java.util.Date;
import javax.swing.JOptionPane;

public abstract class Evento {

    private String nome;
    private Date data;
    private int capacidade;
    private int qtdIngressosVendidos = 0;
    private Ingresso[] ingressos;
    private double precoIngresso;

    public Evento(String nome, Date data, int capacidade, double precoIngresso) {
        this.nome = nome;
        this.data = data;
        this.capacidade = capacidade;
        this.ingressos = new Ingresso[capacidade];
        this.precoIngresso = precoIngresso;
    }

    public void venderIngresso(TipoIngresso tipoIngresso) {
        if (qtdIngressosVendidos + 1 == capacidade) {
            JOptionPane.showMessageDialog(null, "Ingressos esgotados!");
        } else {
            double valor = 0;
            if (tipoIngresso == TipoIngresso.NORMAL) {
                valor = precoIngresso;
            } else if (tipoIngresso == TipoIngresso.MEIA) {
                valor = precoIngresso / 2;
            } else {
                valor = precoIngresso * 2;
            }

            Ingresso ingresso = new Ingresso(new Date(), tipoIngresso, valor);
            this.ingressos[qtdIngressosVendidos] = ingresso;
            qtdIngressosVendidos++;

            JOptionPane.showMessageDialog(null, "Ingresso vendido com sucesso:\n"
                    + "Data: " + ingresso.getDataVenda()
                    + "\nValor: " + ingresso.getValor()
                    + "\nTipo: " + ingresso.getTipoIngresso()
            );
        }
    }

    public String listarIngressos() {
        String ingressosStr = "";
        if (qtdIngressosVendidos > 0) {
            for (int i = 0; i < qtdIngressosVendidos; i++) {
                Ingresso ingresso = ingressos[i];
                ingressosStr += i+1 + "º Ingresso:\n"
                        + "Data: " + ingresso.getDataVenda() +"\n"
                        + "Valor: " + ingresso.getValor() + "\n"
                        + "Tipo: " + ingresso.getTipoIngresso() + "\n";
            }
        } else {
            ingressosStr = "Nenhum ingresso vendido.";
        }

        return ingressosStr;
    }

    public double calcReceita() {
        double receita = 0;
        if (qtdIngressosVendidos > 0) {
            for (int i = 0; i < qtdIngressosVendidos; i++) {
                Ingresso ingresso = ingressos[i];
                if (ingresso.getTipoIngresso() == TipoIngresso.NORMAL) {
                    receita += precoIngresso;
                } else if (ingresso.getTipoIngresso() == TipoIngresso.MEIA) {
                    receita += precoIngresso / 2;
                } else {
                    receita += precoIngresso * 2;
                }
            }
        }
        return receita;
    }

    @Override
    public String toString() {
        return "Evento: " + nome + "\nData: " + data + "\nPreço do Ingresso: " + precoIngresso
                + "\nCapacidade: " + capacidade + "\nReceita: " + calcReceita() + "\n";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Ingresso[] getIngressos() {
        return ingressos;
    }

    public void setIngressos(Ingresso[] ingressos) {
        this.ingressos = ingressos;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }
}
