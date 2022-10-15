import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class mainSystem {

    public static void main(String[] args){

        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Sector> sectors = new ArrayList<Sector>();

        String option = "";

        users.add(new Student();

        sectors.add(new Sector("Matematica"));
        sectors.add(new Sector("Portugues"));
        sectors.add(new Sector("Biologia"));
        sectors.add(new Sector("Fisica"));
        sectors.add(new Sector("Quimica"));
        sectors.add(new Sector("Historia"));
        sectors.add(new Sector("Geografia"));
        sectors.add(new Sector("Filosofia"));

        JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de reserva!");

        Object[] buttons = {"Cadastrar usuário", "Selecionar usuário", "Sair"};

        do{
            JPanel panel = new JPanel();
            panel.add(new JLabel("Selecione o que deseja fazer"));
        
            int result = JOptionPane.showOptionDialog(null, panel, "SISTEMA DE RESERVA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);

            if (result == JOptionPane.YES_OPTION){//Sign in
                
                SignIn signin = new SignIn();
                users.add(signin.singIn(users, sectors));

            }
            else if (result == JOptionPane.NO_OPTION){//Log in
                Integer indice = 0;
                Object[] foundUsers = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

                for (User user : users) {
                    if (user !=null )
                        foundUsers[indice++] = user.toString();
                }

                String chosenUser = (String) JOptionPane.showInputDialog(null, "Deseja acessar com qual usuário?", "Escolha seu usuário", JOptionPane.PLAIN_MESSAGE, null, foundUsers, "");
                
                
                User login = null;
                for (User user : users) {
                    //JOptionPane.showMessageDialog(null, "'" + chosenUser + "'" + "\n'" + user.toString() + "'"); Ambos textos estão iguais
                    if ( chosenUser == user.toString() )
                        login = user;
                }

                mainUser reservation = new mainUser();
                if(login == null){
                    JOptionPane.showMessageDialog(null, "Usuário selecionado invalido!");
                }
                else{
                    reservation.login(login);
                }


                /*for (User user : users) {
                    if(user.getUserID() == chosenUser){
                        if(user instanceof Student){

                        }
                        else if(user instanceof Teacher){
                            
                        }
                        else{

                        }
                    }
                }*/
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