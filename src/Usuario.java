import javax.swing.*;

public class Usuario {
    public void listarSalas(Sala[] salas){
        String strSalas = "Salas disponíveis\n";
        for(int i = 0; i < Sala.numSalasRegistradas; i++){
            if(salas[i].isDisponivel() && salas[i].getNumReservas() < Reserva.numMaxReservas){
                strSalas += ("Sala " + salas[i].getNumSala() + "\n");
            }
        }
        JOptionPane.showMessageDialog(null, strSalas);
    }

    public void listarReservas(Sala[] salas){
        String strReservas = "Lista de salas reservadas\n\n";
        for(Sala sala: salas){
            if (sala == null) {
                break;
            }
            if(sala.getNumReservas() > 0){
                strReservas += sala.listarReservas() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, strReservas);

    }

    public void listarReserva(Sala sala){
        String strReserva = sala.listarReservas();
        JOptionPane.showMessageDialog(null, strReserva);
    }

    public void reservarSala(String data, String horario, Sala sala, int duracao){
        JOptionPane.showMessageDialog(null, "Usuário não possui permissão para executar essa ação\n");
    }

}
