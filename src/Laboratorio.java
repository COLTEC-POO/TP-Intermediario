import java.text.SimpleDateFormat;

public class Laboratorio extends Sala{
    Laboratorio(int numSala, int capacidade, boolean disponivel) {
        super(numSala, capacidade, disponivel);
    }

    //Função usada para listar as reservas da sala
    public String listarReservas(){
        String strReservas;

        //Verifica se existe alguma reserva na sala
        if(this.numReservas > 0) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MMM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            strReservas = "Reservas do Laboratório " + this.numSala + "\n";

            for (Reserva reserva : this.listaReservas) {
                if (reserva == null) {
                    break;
                }
                strReservas += "\nProfessor: " + reserva.getNomeProfessor()+"\nSetor: " + reserva.getSetorProfessor() +
                        "\nData: " + sdfData.format(reserva.getData() ) + "\nHorário: " + sdfHora.format(reserva.getHorarioInicio()) +
                        " às " + sdfHora.format(reserva.getHorarioFim()) + "\n";
            }
        }
        else{
            strReservas =  "Nenhuma reserva feita na sala ";
        }
        return strReservas;
    }
}
