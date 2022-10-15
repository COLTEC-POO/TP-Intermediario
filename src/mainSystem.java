import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class mainSystem {

    public static void main(String[] args){

        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Sector> sectors = new ArrayList<Sector>();

        String option = "";

        //Setting some disciplines
        sectors.add(new Sector("Matematica")); //0
        sectors.add(new Sector("Portugues")); //1
        sectors.add(new Sector("Biologia")); //2
        sectors.add(new Sector("Fisica")); //3
        sectors.add(new Sector("Quimica")); //4
        sectors.add(new Sector("Historia")); //5
        sectors.add(new Sector("Geografia")); //6
        sectors.add(new Sector("Filosofia")); //7

        //Setting some students
        users.add(new Student("Raphael", "2022954160"));
        users.add(new Student("Pedro", "2022954062"));
        users.add(new Student("Mariana", "2022954216"));
        users.add(new Student("Wallace", "2022953600"));
        users.add(new Student("Gabriela", "2022954186"));
        users.add(new Student("Jefferson", "2022953430"));
        
        //Setting some teachers
        users.add(new Teacher("Marcão", sectors.get(3)));
        users.add(new Teacher("Irmão", sectors.get(7)));
        users.add(new Teacher("Luciene", sectors.get(4)));
        users.add(new Teacher("Clebinho", sectors.get(6)));
        users.add(new Teacher("Andreia", sectors.get(5)));


        //Software starts
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