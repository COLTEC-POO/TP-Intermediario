
abstract public class Funcionario {
    protected String name;
    protected String code;

    public Funcionario(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Mesa abrirMesa(int numClientes) {
        System.out.println("Abrindo mesa para " + numClientes + " clientes");
        Mesa mesa = new Mesa(numClientes, this);
        System.out.println("Mesa " + mesa.getTableNumber() + " aberta");

        return mesa;
    }

    public void fecharMesa(Mesa mesa) {
        mesa.setNumberOfClients(0);
        mesa.setOrderHistory(new Pedido[100]);
        mesa.setResponsibleEmployee(null);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
