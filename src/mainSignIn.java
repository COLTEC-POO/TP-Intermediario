import java.util.ArrayList;

import javax.swing.*;

public class mainSignIn {

    public User singIn(ArrayList<User> users, ArrayList<Sector> sectors){
        
        User newUser = null;
        Object[] options = {"Estudante", "Professor", "Adminstrador"};

        String choice = (String) JOptionPane.showInputDialog(null, "Qual tipo de usuário?", "Escolha o tipo", JOptionPane.PLAIN_MESSAGE, null, options, "Estudante");

        if ( choice == null || choice == "null"){
        }
        else {

            String name = JOptionPane.showInputDialog("Qual o seu nome?");
    
            if(choice == "Estudante"){
                String data = JOptionPane.showInputDialog("Qual sua matricula?");
                
                newUser = new Student(name, data);
            }
            else if(choice == "Professor"){
                Sector data = null;
                Integer indice = 0;
                Object[] foundSector = {"", "", "", "", "", "", "", "", "", "", ""};

                for (Sector sector : sectors) {
                    if (sector !=null )
                        foundSector[indice++] = sector.toString(true);
                }

                String dataString = (String) JOptionPane.showInputDialog(null, "Qual sua disciplina", "Escolha sua materia", JOptionPane.PLAIN_MESSAGE, null, foundSector, "");
    
                for (Sector sector : sectors) {
                    if (dataString == sector.toString(true) )
                        data = sector;
                }

                newUser = new Teacher(name, data);
            }
            else{
                String data = JOptionPane.showInputDialog("Qual sua ?");
                newUser = new Student(name, data);
            }
        }
        for (User user : users) {
            if (user.equals(newUser) ){
                JOptionPane.showMessageDialog(null, "Esse usuário já está cadastrado!");
                return null;
            }
        }
        
        return newUser;
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