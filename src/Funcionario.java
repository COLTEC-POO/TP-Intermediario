public abstract class Funcionario {
    private String nome;
    private String codigo;


    //    Getters

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    //    Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //  Métodos

    Mesa abrirMesa(int numClientes){
      Mesa mesa;
      mesa = new Mesa(nome, numClientes);
      return mesa;
    }

    void fecharMesa(Mesa mesa){
        mesa.setNumeroDeClientes(0);
        mesa.setHistoricoDePedidos(new Pedido[100]);
        mesa.setNumeroDePedidosNaMesa(0);
    }
}
