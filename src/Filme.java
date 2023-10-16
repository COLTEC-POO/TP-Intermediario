import java.time.LocalDate;

public class Filme extends Eventos{

    public Filme(String nome, Boolean eAcessivel, String horario, LocalDate data){
        //Atributos da superclasse
        super(nome,eAcessivel, horario, data);

        // Define o limite de ingressos específico para Filme
        this.LIMITE_INGRESSOS = 200;
    }

    @Override
    // Método para obter o tipo de evento (será implementado nas subclasses)
    public String getTipo() {
        return " Filme ";
    }
}