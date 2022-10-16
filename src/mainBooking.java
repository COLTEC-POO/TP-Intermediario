import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

public class mainBooking{
    

    public void seeBookings(User user, ArrayList<Classrooms> classrooms){

        String option = "";

        Object[] buttons = {"Visualizar salas disponiveis", "Visualizar horarios de uma sala", "Voltar"};

        do{
            JPanel panel = new JPanel();
            panel.add(new JLabel("Selecione o que deseja fazer"));
        
            int result = JOptionPane.showOptionDialog(null, panel, "SISTEMA DE RESERVA - Login: " + user.toString(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);

            Integer indice = 0;
            Object[] freeroom = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

            for (Classrooms rooms : classrooms) {
                Classrooms temp = null;
                if(rooms instanceof LaboratoryClass){
                     temp = (LaboratoryClass) rooms;
                }
                else if(rooms instanceof ConventionalClass){
                     temp = (ConventionalClass) rooms;
                }
                if(temp.CountFreeReservation() > 0){
                    freeroom[indice++] = temp.getNumber();
                }
            }

            if (result == JOptionPane.YES_OPTION){//Ver salas disponiveis
                
                String salas = "";

                for (Object object : freeroom) {
                    salas += object.toString() + "\n";
                }

                JOptionPane.showMessageDialog(null, "As salas disponiveis para reserva são:              \n\n" + salas);
            }
            else if (result == JOptionPane.NO_OPTION){//Ver horarios de uma sala
                
            }
            else if (result == JOptionPane.CANCEL_OPTION){//Voltar
                option = "exit";
            }
            else{//Other

            }
        }while(option != "exit");
    }
}
