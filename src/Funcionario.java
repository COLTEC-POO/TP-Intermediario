
abstract public class Funcionario {
    String name;
    String code;

    public Funcionario(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void abrirMesa(int numClientes) {
        System.out.println("Abrindo mesa para " + numClientes + " clientes");

    }

    public void fecharMesa(Mesa mesa) {

    }
}
