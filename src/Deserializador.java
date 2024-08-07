import java.io.File;
import java.util.Arrays;

public class Deserializador {
    //Tipo Deve ser .Filme .Concerto .Teatro

    //Funciona só falta dá uma adptada
    String[] ListarArquivos(){
        String caminhoDiretorio = "Eventos/";

        File diretorio = new File(caminhoDiretorio);

        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles();

            if (arquivos != null){
                String[] TodosOsNomes = new String[0];
                int i = 0;
                for (File arquivo : arquivos) {
                    //parte responsavel por alocar dinamicamente o array de Strings
                    String[] novoArray = Arrays.copyOf(TodosOsNomes,(i + 1));
                    TodosOsNomes = novoArray;
                    //

                    if (arquivo.isFile()) {
                        TodosOsNomes[i] = arquivo.getName();
                    }
                    i++;
                }
                return TodosOsNomes;
            }else{
                String[] Errou = new String[]{"Arquivo","Não","Encontrado"};
                return Errou;
            }
        } else {
            String[] Errou = new String[]{"Diretório não existe"," ou não é um diretório válido."};
            return Errou;
        }
    }
    //

}

