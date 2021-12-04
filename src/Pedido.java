
public class Pedido {
    private String description;
    private int value;
    private static int totalOrders;

    public Pedido(String description, int value) {
        this.description = description;
        this.value = value;
        totalOrders++;
    }

    public String getDescription() {
        return this.description;
    }

    public int getValue() {
        return this.value;
    }

    static int getTotalOrders() {
        return Pedido.totalOrders;
    }

}
