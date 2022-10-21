import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reservas {

    private String nome;
    private String setor;
    private Date data;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Reservas(String nome, String setor, String data) {
        this.nome = nome;
        this.setor = setor;
        try {
            this.data = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}