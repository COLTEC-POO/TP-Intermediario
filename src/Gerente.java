
public class Gerente extends Funcionario {

    public Gerente(String nome, String code) {
        super(nome, code);
    }

    void visualizarPedidos(Mesa mesa) {
        System.out.println("Pedidos da mesa ");
    }

}
