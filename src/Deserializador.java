import java.io.File;

public class Deserializador {
    //Tipo Deve ser .Filme .Concerto .Teatro

    //Funciona só falta dá uma adptada
    void ListarArquivos(){
        String caminhoDiretorio = "Eventos/";

        File diretorio = new File(caminhoDiretorio);

        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles();

            if (arquivos != null){
                for (File arquivo : arquivos) {
                    if (arquivo.isFile())
                        System.out.println(arquivo.getName());
                }
            }else
                System.out.println("Nenhum arquivo encontrado no diretório.");
        } else
            System.out.println("Diretório não existe ou não é um diretório válido.");
    }
    //

}

