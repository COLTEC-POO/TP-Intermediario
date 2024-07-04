import java.io.FileWriter;
import java.io.IOException;

public class SalvandoEventos {
    public boolean salvarEvantos(Evento Eve){
        try {
            // Create a FileWriter object specifying the file name
            FileWriter Escrevedor = new FileWriter("Eventos.txt");

            Escrevedor.write(Eve.toString());
            Escrevedor.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
