public abstract class Funcionario  {

    //Um funcionário nunca deverá ser inicializado diretamente.

    //Atributos
    //Nome do funcionário
    //Código do funcionário
    //-----------------------------------------------------------------------------------------------------//
    private String nome;
    private int id;
    //-----------------------------------------------------------------------------------------------------//

    //Getters
    public String getNome() {return nome;}
    public int getId() {return id;}
    //-----------------------------------------------------------------------------------------------------//

    //Setters
    public void setNome(String nome) {this.nome = nome;}
    public void setCodigo(int id) {this.id = id;}
    //-----------------------------------------------------------------------------------------------------//

    //  Métodos
    Mesa novaMesa(int numClientes){
        Mesa mesa;
        mesa = new Mesa(nome, numClientes);
        mesa.infoMesas();
        return mesa;
    }
    void fecharMesa(Mesa mesa){
        mesa.setQtyClientes(0);
        mesa.setHistPedidos(new Pedido[100]);
        mesa.setK(0);
    }
    //-----------------------------------------------------------------------------------------------------//
}
