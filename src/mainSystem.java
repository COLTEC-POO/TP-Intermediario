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
















/* 
        // diálogo padrão
        JOptionPane.showMessageDialog(null, "Exemplo diálogo de informação");
        // diálogo de erro
        JOptionPane.showMessageDialog(null, "Exemplo de diálogo de erro","Título do erro", JOptionPane.ERROR_MESSAGE);
        // diálogo de confirmação
        Integer numero = JOptionPane.showConfirmDialog(null, "Você confirma?", "Você confirma?",JOptionPane.YES_NO_OPTION); //0 = Sim //1 =Não
        JOptionPane.showMessageDialog(null, "Numero do sim" + numero);
        //diálogo de requisição de dados
        String inputValue = JOptionPane.showInputDialog("Qual o seu nome?");
        // diálogo de requisição com dados previamente definidos
        Object[] opcoes = {"20", "18", "19"};
        String s = (String) JOptionPane.showInputDialog(null, "Qual desses números é ímpar?", "Escolha o número", JOptionPane.PLAIN_MESSAGE, null, opcoes, "20");
*/


        /*JOptionPane.showOptionDialog(null,
                 "Selecione o que deseja fazer",
                 "SISTEMA DE RESERVAS",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.PLAIN_MESSAGE,
                 null,
                 buttons,
                 null);*/

                 /*
                  * 

                  Object[] options1 = { "Try This Number", "Choose A Random Number",
                "Quit" };

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter number between 0 and 1000"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if (result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, textField.getText());
        }
                  */