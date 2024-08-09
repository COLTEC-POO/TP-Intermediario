public class Main {
    public static void main(String[] args){
        Tela Exibir = new Tela();
        Deserializador oi = new Deserializador();
        String[] Socorro;
        Socorro = oi.ListarArquivos();
        for(String Sos : Socorro){
            System.out.println(Sos);
        }
        Evento[] ola;
        ola = oi.Deserializa("Filme");
        String nome = ola[0].getNome();
        System.out.println(nome);

    }
}
