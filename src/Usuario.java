public abstract class Usuario {
    String nome;
    char tipoUsuario;
    public static int qntUsuarios = 0;

    public Usuario(char tipoUsuario, String nome) {
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        qntUsuarios++;
    }
}