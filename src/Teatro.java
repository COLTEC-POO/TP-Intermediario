import java.time.LocalDate;

public class Teatro extends Eventos{

    public Teatro(String nome, Boolean eAcessivel, String horario, LocalDate data){
        //Atributos da superclasse
        super(nome,eAcessivel, horario, data);

        // Define o limite de ingressos específico para Teatro
        this.LIMITE_INGRESSOS = 250;
    }

    @Override
    // Método para obter o tipo de evento (será implementado nas subclasses)
    public String getTipo() {
        return " Teatro ";
    }
}