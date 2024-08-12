import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

abstract class Evento implements IReceita{
    private String nome;
    private Date data;
    private String hora;
    private String local;
    protected int capacidade;
    private double preco;
    public SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); // Para converter String para Date
    protected ArrayList<Ingresso> ingressos;

    public Evento (String nome, String data, String hora, String local, double preco) {
        this.nome = nome;
        try{ // Converte String para Date
            this.data = formatoData.parse(data);
        }catch (Exception e){
            System.out.println("<< Date Error >>");
        }
        this.hora = hora;
        this.local = local;
        this.preco = preco;
        this.ingressos = new ArrayList<>();
    }

    public abstract void addIngresso(Ingresso newIngresso);

    public double totalVendas() {
        double total = 0;

        for (Ingresso atual : this.ingressos) {
            if(atual != null) {
                total += atual.valor;
            }
        }
        return total;
    }

    public int lugaresDisp() {
        return capacidade - ingressos.size();
    }

    public int ingressoNormalDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'n') {
                i++;
            }
        }
        return lugaresDisp() - i;
    }

    public int ingressoMeiaDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'm') {
                i++;
            }
        }
        return lugaresDisp() - i;
    }

    public int ingressoVIPDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'v') {
                i++;
            }
        }
        return  lugaresDisp() - i;
    }

    @Override
    public double totalReceita() {
        double total = 0;
        for (Ingresso ingresso : ingressos) {   //ingresso percorre cada item do array de ingressos
            if(ingresso != null) {
                total += ingresso.getValor();     //soma valor total dos ingressos comprados
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "<< EVENTO " + nome + " >> \nData: " + data + "\nHorário: " + hora + "\nLocal: " + local + "\nReceita Total: " + totalReceita();
    }

    public static double receitaTotalAcumulada(List<Evento> eventos) {
        double receitaTotal = 0;
        for (Evento evento : eventos) {
            if (evento != null) {
                receitaTotal += evento.totalReceita();
            }
        }
        return receitaTotal;
    }

    public void ingressosVendidos() {
        System.out.println("\n<< Ingressos vendidos para o evento: " + nome + " >>");
        for (Ingresso ingresso : ingressos) {
            if (ingresso != null) {
                System.out.println(ingresso.toString());
            }
        }
    }

    public double getPreco () {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }

    public Ingresso getIngresso(int i) {
        return this.ingressos.get(i);
    }
}
