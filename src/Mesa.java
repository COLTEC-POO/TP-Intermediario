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

    public void pushOrderToHistory(Pedido order) {
        for (int i = 0; i < orderHistory.length; i++) {
            if (orderHistory[i] == null) {
                orderHistory[i] = order;
                break;
            }
        }
    }

    public Funcionario getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(Funcionario responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public int getTotalBill() {
        int totalBill = 0;

        for (int i = 0; i < this.orderHistory.length; i++) {
            if (orderHistory[i] != null) {
                totalBill += orderHistory[i].getValue();
            }
        }
        return totalBill;
    }

}
