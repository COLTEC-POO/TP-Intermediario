import javax.lang.model.type.NullType;

public class Mesa {
    private int tableNumber;
    private int numberOfClients;
    private Pedido[] orderHistory = new Pedido[100];
    private Funcionario responsibleEmployee;
    private static int tablesTotal = 0;

    public Mesa(int numberOfClients, Funcionario responsibleEmployee) {
        this.tableNumber = Mesa.tablesTotal;
        this.numberOfClients = numberOfClients;
        this.responsibleEmployee = responsibleEmployee;
        Mesa.tablesTotal++;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public Pedido[] getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(Pedido[] orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Funcionario getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(Funcionario responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public void closeTable() {
        this.numberOfClients = 0;
        this.orderHistory = new Pedido[100];
        this.responsibleEmployee = null;
    }

}
