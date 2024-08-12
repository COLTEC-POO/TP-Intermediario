public class IngressoVIP extends Ingresso{
    public IngressoVIP(double valor) {
        super(valor*2);
        this.tipo = 'v';
    }
}
