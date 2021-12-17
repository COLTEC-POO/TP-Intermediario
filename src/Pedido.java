public class Pedido {

    //atributos
    private String descreve_pedido;
    private double  valor_pedido;
    public static int totaldepedidos=0;

    //construtor
    public Pedido(){
        this.descreve_pedido="INVALIDO";
        this.valor_pedido=0.0;
        totaldepedidos++;
    }

    //metodos getters e setters
    public String getDescreve_pedido(){
        return this.descreve_pedido;
    }

    public void setDescreve_pedido(String descreve_pedido) {
        this.descreve_pedido = descreve_pedido;
    }

    public void setValor_pedido(double valor_pedido) {
        this.valor_pedido = valor_pedido;
    }

    public double getValor_pedido() {
        return valor_pedido;
    }



}
