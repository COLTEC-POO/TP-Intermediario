import javax.swing.*;

public class mainUser{
    

    public void login(User user){

        String option = "";

        Object[] buttons = {"Visualizar salas disponiveis", "Fazer uma reserva", "Logoff"};

        do{
            JPanel panel = new JPanel();
            panel.add(new JLabel("Selecione o que deseja fazer"));
        
            int result = JOptionPane.showOptionDialog(null, panel, "SISTEMA DE RESERVA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);

            if (result == JOptionPane.YES_OPTION){//Ver salas disponiveis
                
                

            }
            else if (result == JOptionPane.NO_OPTION){//Fazer uma reserva
                
            }
            else if (result == JOptionPane.CANCEL_OPTION){//Leave
                JOptionPane.showMessageDialog(null, "Você fez logoff do sistema!!");
                option = "exit";
            }
            else{//Other

            }
        }while(option != "exit");
    }
}
