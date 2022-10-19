import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

public class mainSystem {
    
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Sector> sectors = new ArrayList<>();
    public static ArrayList<Classrooms> classrooms = new ArrayList<>();
    public static void main(String[] args) throws ParseException{


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

        //Setting some laboratorys
        classrooms.add(new LaboratoryClass(101, 40));
        classrooms.add(new LaboratoryClass(102, 40));
        classrooms.add(new LaboratoryClass(103, 40));
        classrooms.add(new LaboratoryClass(104, 40));

        //Setting some classrooms
        classrooms.add(new ConventionalClass(201, 60));
        classrooms.add(new ConventionalClass(202, 60));
        classrooms.add(new ConventionalClass(203, 60));
        classrooms.add(new ConventionalClass(204, 60));
        classrooms.add(new ConventionalClass(205, 60));
        classrooms.add(new ConventionalClass(206, 60));
        classrooms.add(new ConventionalClass(207, 60));
        classrooms.add(new ConventionalClass(208, 60));

        classrooms.get(11).getReservation()[2] = new BookingClass(users.get(8) , users.get(8).getDiscipline(), new Date(122, 10 - 1, 28, 11, 50),new Date(122, 10 - 1, 28, 12, 50));

        //Software starts
        JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de reserva!");

        Object[] buttons = {"Cadastrar usuário", "Selecionar usuário", "Sair"};

        do{
            JPanel panel = new JPanel();
            panel.add(new JLabel("Selecione o que deseja fazer"));
        
            int result = JOptionPane.showOptionDialog(null, panel, "SISTEMA DE RESERVA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);

            if (result == JOptionPane.YES_OPTION){//Sign in
                
                mainSignIn signin = new mainSignIn();
                User newuser = signin.singIn(users, sectors);
                if(newuser != null)
                    users.add(newuser);

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
                    
                    if ( chosenUser.contains(user.toString()) )
                        login = user;
                }

                mainUser reservation = new mainUser();
                if(login == null){
                    JOptionPane.showMessageDialog(null, "Usuário selecionado invalido!");
                }
                else{
                    reservation.login(login, classrooms);
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