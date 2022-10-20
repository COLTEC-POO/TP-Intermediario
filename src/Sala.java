import java.util.Date;

import javax.swing.JOptionPane;

public abstract class Sala {
    public static int nReservas = 20;
    public static int numMaxSalas = 5;
    public static int qntSalas = 0;


    int qtdReserva =0;
    String dataString;
    String horaIncString;
    String horaFinString;
    Date[] data;
    Date[] horaInicial;
    Date[] horaFinal;
    boolean status = true;
    String numSala;
    int capacidadeSala;
    public String recebeSala;

    Sala( String numSala, int nReservas){
        this.numSala = numSala;
        qntSalas++;
        this.data = new Date[nReservas];
        this.horaInicial = new Date[nReservas];
        this.horaFinal = new Date[nReservas];
    }
    public abstract String visualizaSalasDisponivel();
    public abstract void reservarSala();
    public abstract String visualizaReservas();



    /*public void setCont(int cont) {
        this.cont = cont;
    }
    public int getCont(){

      return cont;
    }
  */


}