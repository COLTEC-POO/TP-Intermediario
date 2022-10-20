import javax.swing.*;

class Main {

    public static void main(String[] args) {
        String visualizaSala = "";
        char opcao;
        int verificador=0;

        Usuario[] usuarios = new Usuario[Sala.numMaxSalas];
        usuarios[Usuario.qntUsuarios] = new Professor("Joao");
        usuarios[Usuario.qntUsuarios] = new Aluno("Diniz");
        usuarios[Usuario.qntUsuarios] = new Aluno("titanbr0202");


        Sala[] salas = new Sala[Sala.numMaxSalas];
        salas[Sala.qntSalas] = new SalaNormal("Sala", "100", 15);
        salas[Sala.qntSalas] = new Laboratorio("Laboratorio","101", 15);
        salas[Sala.qntSalas] = new SalaNormal("Sala","102", 15);
        salas[Sala.qntSalas] = new Laboratorio("Laboratorio","201", 15);
        do{
            verificador = verificaUsuario(usuarios);
            if(verificador==1){


                do{
                    opcao = JOptionPane.showInputDialog(null, "Bem vindo ao sistema de Reserva de salas\n " +
                            "01 - Sair\n 02 - Visualizar Salas Disponiveis\n 03 - Visualizar Salas Reservadas\n ").charAt(0);

                    switch (opcao) {
                        case '1':

                            break;
                        case '2':
                            visualizarDisponiveis(salas);
                            break;
                        case '3':
                            visualizarReservas(salas);
                            break;
                    }
                }while(opcao != '1');
            }
            else if(verificador==2){
                do{
                    opcao = JOptionPane.showInputDialog(null, "Bem vindo ao sistema de Reserva de salas\n " +
                            "01 - Sair\n 02 - Visualizar Salas Disponiveis\n 03 - Visualizar Salas Reservadas\n 04- Reservar Sala\n").charAt(0);

                    switch (opcao) {
                        case '1':

                            break;
                        case '2':
                            visualizarDisponiveis(salas);
                            break;
                        case '3':
                            visualizarReservas(salas);
                            break;
                        case '4':
                            int numSala = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da sala a ser reservada:\n"));
                            salas[numSala].reservarSala();
                            break;
                    }
                }while(opcao != '1');
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario invalido");
            }
        }while(verificador!=0);
    }
    public static String visualizarDisponiveis(Sala salas[]){
        String visualizaSala = "";
        for(int i = 0; i < Sala.qntSalas; i++){
            visualizaSala = visualizaSala + salas[i].visualizaSalasDisponivel();
        }
        JOptionPane.showMessageDialog(null,visualizaSala);
        return visualizaSala;
    }
    public static String visualizarReservas(Sala salas[]){
        String visualizaSala = "";
        for(int i = 0; i < Sala.qntSalas; i++){
            visualizaSala = visualizaSala + salas[i].visualizaReservas();
        }
        JOptionPane.showMessageDialog(null,visualizaSala);
        return visualizaSala;
    }

    public static int verificaUsuario(Usuario usuarios[]){
        int verifica =0;
        String UsuarioDigitado = JOptionPane.showInputDialog(null, "Digite o nome do usuario\n");
        for(int i =0;i<Usuario.qntUsuarios;i++){
            if(usuarios[i].nome.equals(UsuarioDigitado)){
                verifica = 1;
                if(usuarios[i].tipoUsuario == 'P'){
                    verifica = 2;
                }
            }

        }
        return verifica;
    }
}
