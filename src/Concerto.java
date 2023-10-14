public class Concerto extends Eventos {

    // Método construtor da subclasse

    Concerto(String nome, String data, String hora, double preco, String local) {
        super(nome, data, hora, preco, local, "Concerto", 150);
    }

}