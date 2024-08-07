public class Main {
    public static void main(String[] args){
        Tela Exibir = new Tela();
        Deserializador oi = new Deserializador();
        String[] Socorro;
        Socorro = oi.ListarArquivos();
        for(String Sos : Socorro){
            System.out.println(Sos);
        }
    }
}
