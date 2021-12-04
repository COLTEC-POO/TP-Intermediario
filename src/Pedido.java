
public class Pedido {
    String description;
    int value;
    static int order_number = 0;

    public Pedido(String description, int value) {
        this.description = description;
        this.value = value;
        order_number++;
    }
}
