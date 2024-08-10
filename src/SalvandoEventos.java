import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SalvandoEventos {
    SalvandoEventos(Evento Eve){
        salvarEvantos(Eve);
    }

    public boolean salvarEvantos(Evento Eve){
        try {
            // Serializando o objeto em um arquivo
            FileOutputStream fileOut = new FileOutputStream(Eve.getNome() );
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
