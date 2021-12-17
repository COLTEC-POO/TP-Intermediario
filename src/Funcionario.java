import java.util.Random;

public abstract class Funcionario {
    //atributos
    private String nome;
    private int  codigo_funcionario;

    //metodos getters e setters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public int getNumero(){
        return this.codigo_funcionario;
    }

    public void setNumero(int numero){
        this.codigo_funcionario=numero;
    }

    //outros métodos


    public Mesa abrirMesa(int numClientes) {
        Mesa novamesa = new Mesa(this,numClientes);
        return novamesa;
    }


    //continuar daqui
    void fecharMesa(Mesa mesa){
        Pedido[ ]auxiliar= mesa.getPedidos();
        for(int i=0;i<mesa.getcont();i++){

            auxiliar[i].setDescreve_pedido("NULL");
            auxiliar[i].setValor_pedido(0.0);
        }
        mesa.setcliente(0);
        mesa.totaldemesas--;
    }




}
