import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Deserializador {


    //Funciona só falta dá uma adptada
    public String[] ListarArquivos(){
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
    //Tipo Deve ser Filme Concerto Teatro

    //

    public Evento[] Deserializa(String Tipo){
        String[] EventosCriados;
        EventosCriados = ListarArquivos();
        Evento[] Criados = new Evento[0];
        Tipo.replace("/n","/0");
        int i=0;
        for(String arquivo : EventosCriados ){
            String[] partes = arquivo.split(".",2);

            for (String parte : partes) {
                if (parte.equals(Tipo)){
                    Evento atual = null;

                    try (FileInputStream fileIn = new FileInputStream(arquivo);
                         ObjectInputStream in = new ObjectInputStream(fileIn)) {
                         atual = (Evento) in.readObject();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Evento[] novoArray = Arrays.copyOf(Criados,(i + 1));
                    Criados = novoArray;
                    Criados[i] = atual;
                    i++;

                }
            }
        }
        return Criados;

    }
    //

}

