public class Mesa {

    //atributos
    private int mesa;
    private int Numcliente;
    private Pedido[] pedidos;//fiquei na dúvida se era público ou privado**perguntar o professor
    private Funcionario donodamesa;
    public static int totaldemesas=0;
    public static int numeromesa=0;
    private int cont=0;

    //construtor
    public Mesa(Funcionario donodamesa,int Numcliente){
        this.mesa=numeromesa++;
        this.Numcliente=Numcliente;
        this.pedidos=new Pedido[100];
        this.donodamesa=donodamesa;
        totaldemesas++;
    }

    //metodos getters e setters
    public int getmesa(){
        return this.mesa;
    }

    public void setmesa(int mesa){
        this.mesa=mesa;
    }

    public int getcliente(){
        return this.Numcliente;
    }

    public void setcliente(int cliente){
        this.Numcliente=cliente;
    }

    public void setDonodamesa(String nome){
        donodamesa.setNome(nome);

    }

    public String getDonodamesa(){
        return donodamesa.getNome();
    }


    public Pedido[] getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(Pedido pedido) {
        this.pedidos[cont] = pedido;
        cont++;
    }

    public int getcont(){
        return this.cont;
    }
}
