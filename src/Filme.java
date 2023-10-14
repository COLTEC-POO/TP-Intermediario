public class Filme extends Eventos {

    // Método construtor da subclasse

    Filme (String nome, String data, String hora, double preco, String local) {
        super(nome, data, hora, preco, local, "Filme", 200);
    }

}