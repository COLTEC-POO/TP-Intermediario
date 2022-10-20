import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SalaNormal extends Sala{
    //variaveis
    public String tipo = "Sala";
    boolean status = true; /*disponivel*/

    public String visualizarReserva = "";
    long horaInicialM;
    long horaFinalM;
    long horaInicialI;
    long horaFinalI;
    //contrutor
    public SalaNormal(String tipo,String nome,int nReservas){
        super(nome,nReservas);
    }

    //metodos
    public String visualizaSalasDisponivel(){
        if(status == true) {
            recebeSala = this.tipo +" " + this.numSala + " disponivel\n";
            return recebeSala;
        }
        return null;
    }
    public String visualizaReservas(){
        if(qtdReserva > 0){

            visualizarReserva = "Sala "+ this.numSala+" tem "+this.qtdReserva+" reservas";
        }
        return visualizarReserva;
    }
    public void reservarSala(){

        //trabalhar essa parte//
        if(status == true){

            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfHoraI = new SimpleDateFormat("hh:mm");
            SimpleDateFormat sdfHoraF = new SimpleDateFormat("hh:mm");

            dataString = JOptionPane.showInputDialog("Digite a data da reserva(dd/MM/yy): \n");
            horaIncString = JOptionPane.showInputDialog("Digite a hora que deseja reservar: \n");
            horaFinString = JOptionPane.showInputDialog("Digite a hora que a reserva deve acabar: \n");
            try{
                data[qtdReserva] = sdfData.parse(dataString);
                horaInicial[qtdReserva]= sdfHoraI.parse(horaIncString);
                horaFinal[qtdReserva]= sdfHoraF.parse(horaFinString);
                JOptionPane.showMessageDialog(null, data[qtdReserva]);
                ///hora = sdfHora.parse(horString);

            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Formato errado");
                e.printStackTrace();
            }

        }
        else{
            System.out.println("Sala já reservada \n");
        }
        horaInicialM =horaInicial[qtdReserva].getTime();
        horaFinalM =horaFinal[qtdReserva].getTime();
        for(int i =0;i<qtdReserva;i++){

            if(data[qtdReserva].equals(data[i])){
                horaInicialI =horaInicial[i].getTime();
                horaFinalI =horaFinal[i].getTime();
                if(horaInicialM<horaInicialI&&horaFinalM<horaFinalI){
                    JOptionPane.showMessageDialog(null, "Essa data não está disponível");
                    return;

                }
                else if ((horaInicialM>horaInicialI&&horaFinalM<horaFinalI)) {
                    JOptionPane.showMessageDialog(null, "Essa data não está disponível");
                    return;
                }
                else if((horaInicialM>horaInicialI&&horaInicialM<horaFinalI)){
                    JOptionPane.showMessageDialog(null, "Essa data não está disponível");
                    return;
                }

            }

        }
        qtdReserva++;
        if(qtdReserva == Sala.nReservas){
            status = false;
        }

    }
}