import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SalvandoEventos {
    SalvandoEventos(Evento Eve){salvarEvantos(Eve);}

    public boolean salvarEvantos(Evento Eve){
        try {
            String LocalDeSalvamento = "Eventos/";
            // Serializando o objeto em um arquivo
            FileOutputStream fileOut = new FileOutputStream(LocalDeSalvamento + Eve.getNome() + "." + Eve.getTipo());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Eve);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
