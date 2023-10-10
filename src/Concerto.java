import java.time.LocalDate;

public class Concerto extends Eventos{

    public Concerto(String nome, Boolean eAcessivel, String horario, LocalDate data){
        //Atributos da superclasse
        super(nome,eAcessivel, horario, data);

        // Define o limite de ingressos específico para Concerto
        this.LIMITE_INGRESSOS = 3;
    }

    @Override
    // Método para obter o tipo de evento (será implementado nas subclasses)
    public String getTipo() {
        return " Concerto ";
    }
}