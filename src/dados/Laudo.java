package dados;

public class Laudo {
    
    private int id_laudo;
    private String descricao;
    private String data;
    private String hora;
    private Paciente pac;
    private Medico med;

    public int getId_laudo() {
        return id_laudo;
    }

    public void setId_laudo(int id_laudo) {
        this.id_laudo = id_laudo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Paciente getPac() {
        return pac;
    }

    public void setPac(Paciente pac) {
        this.pac = pac;
    }

    public Medico getMed() {
        return med;
    }

    public void setMed(Medico med) {
        this.med = med;
    }
    
}
