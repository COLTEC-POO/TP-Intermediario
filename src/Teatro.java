public class Teatro extends Eventos {

    // Método construtor da subclasse

    Teatro(String nome, String data, String hora, double preco, String local){
        super(nome, data, hora, preco, local, "Teatro", 250);
    }
}