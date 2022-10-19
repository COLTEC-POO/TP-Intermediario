import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

public class mainBooking{
    

    public void seeBookings(User user, ArrayList<Classrooms> classrooms){

        String option = "";

        Object[] buttons = {"Visualizar salas sem agendamento", "Visualizar horarios de uma sala", "Voltar"};

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
                
                String choice = JOptionPane.showInputDialog(null, "Qual sala deseja ver os horarios?", "Selecione a sala", JOptionPane.PLAIN_MESSAGE, null, freeroom, "").toString();

                //JOptionPane.showMessageDialog(null, "Sala selecionada: " + choice);

                for (Classrooms rooms : classrooms) {
                    if (rooms.getNumber().toString().contains(choice)){

                        String horarios = "";
                        Integer indice_booking = 1;

                        for (BookingClass booking : rooms.getReservation()) {
                            if(booking.getTeacher() == null)
                                horarios += indice_booking + " - " + booking.toString() + "\n";
                            else
                                horarios += indice_booking + " - " + booking.getSchedule() + "\n";
                            indice_booking++;
                        }
                        JOptionPane.showMessageDialog(null, "Os horarios da sala" + choice + " disponiveis para reserva são:       \n\n" + horarios);
                    }
                }

            }
            else if (result == JOptionPane.CANCEL_OPTION){//Voltar
                option = "exit";
            }
            else{//Other

            }
        }while(option != "exit");
    }

    public void makeBookings(User user, ArrayList<Classrooms> classrooms) throws ParseException{

        BookingClass scheduled = null;
        String option = "";

        Object[] buttons = {"Visualizar salas com horario disponivel", "Voltar"};

        do{
            JPanel panel = new JPanel();
            panel.add(new JLabel("Selecione o que deseja fazer"));
        
            int result = JOptionPane.showOptionDialog(null, panel, "SISTEMA DE RESERVA - Login: " + user.toString(), JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);

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

            if (result == JOptionPane.YES_OPTION){//Ver salas com horario disponivel
                
                String choice = JOptionPane.showInputDialog(null, "Qual sala deseja agendar?", "Selecione uma sala", JOptionPane.PLAIN_MESSAGE, null, freeroom, "").toString();

                for (Classrooms rooms : classrooms) {
                    if (rooms.getNumber().toString().contains(choice)){

                        String horarios = "";
                        Integer indice_booking = 1;

                        for (int i = 0; i < rooms.getMaxReservation(); i++ ) {
                            if(rooms.getReservation(i).getTeacher() == null)
                                horarios += indice_booking + " - " + rooms.getReservation(i).toString() + "\n";
                            else
                                horarios += indice_booking + " - " + rooms.getReservation(i).getSchedule() + "\n";
                            indice_booking++;
                        }

                        int posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Os horarios da sala" + choice + " disponiveis para reserva são:       \n\n" + horarios));

                        if(rooms.getReservation(posicao - 1).getTeacher() != null){
                            JOptionPane.showMessageDialog(null, "O horario já está agendado");
                            continue;
                        }
                        else if(posicao <= 20 && posicao > 0){
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy;HH:mm:ss");

                            Date dBegin = null;
                            do{
                                
                            String dataBegin = JOptionPane.showInputDialog(null, "Na posição " + posicao + " será agendado a partir de (dd-MM-yyyy;HH:mm:ss): ");//28-10-2022;12:50:00
                            //JOptionPane.showMessageDialog(null, dataBegin);
                            dBegin = sdf.parse(dataBegin);
                            //JOptionPane.showMessageDialog(null, dBegin);
                            } while(dBegin == null);

                            Date dEnd = null;
                            do{
                            String dataEnd = JOptionPane.showInputDialog(null, "A reserva da sala" + choice + " na posição " + posicao + " será de " + dBegin +" até (dd-MM-yyyy;HH:mm:ss):  ");
                            dEnd =  (Date) sdf.parse(dataEnd);
                            } while (dEnd == null);

                            Teacher scheduledTeacher = (Teacher )user;

                            scheduled = new BookingClass(scheduledTeacher , scheduledTeacher.getDiscipline(), dBegin, dEnd);

                            classrooms.get(classrooms.indexOf(rooms)).getReservation()[posicao - 1] = scheduled;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Posição de agendamento invalido!");
                            continue;
                        }
                    }
                }
            }
            else if (result == JOptionPane.NO_OPTION){//Voltar
                option = "exit";   
                
            }
        }while(option != "exit");
    }
}
