import java.util.ArrayList;

import javax.swing.*;

public class mainSystem {

    public static void main(String[] args){

        ArrayList<User> users = new ArrayList<User>();

        String option = "";

        JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de reserva!");

        Object[] buttons = {"Cadastrar usuário", "Selecionar usuário", "Sair"};

        do{
            JPanel panel = new JPanel();
            panel.add(new JLabel("Selecione o que deseja fazer"));
        
            int result = JOptionPane.showOptionDialog(null, panel, "SISTEMA DE RESERVA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);

            if (result == JOptionPane.YES_OPTION){//Sign in
                
                SignIn signin = new SignIn();
                users.add(signin.singIn());

            }
            else if (result == JOptionPane.NO_OPTION){//Log in
                Integer indice = 0;
                Object[] foundUsers = {};
                for (User user : users) {
                    foundUsers[indice++] = user.getUserID();
                }

                Integer chosenUser = (Integer) JOptionPane.showInputDialog(null, "Deseja acessar com qual usuário?", "Escolha seu usuário", JOptionPane.PLAIN_MESSAGE, null, foundUsers, "");

                for (User user : users) {
                    if(user.getUserID() == chosenUser){
                        if(user instanceof Student){

                        }
                        else if(user instanceof Teacher){
                            
                        }
                        else{

                        }
                    }
                }
            }
            else if (result == JOptionPane.CANCEL_OPTION){//Leave
                JOptionPane.showMessageDialog(null, "Obrigado por utilizar o sistema!!");
                option = "exit";
            }
            else{//Other

            }
        }while(option != "exit");
    }
}