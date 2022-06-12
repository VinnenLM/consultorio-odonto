package dados;

public class Prontuario {
    
    private int id_prontuario;
    private String data;
    private String inicio;
    private String fim;
    private String resultado;
    private String observacao;
    private Paciente pac;
    private Medicamento medc;

    public int getId_prontuario() {
        return id_prontuario;
    }

    public void setId_prontuario(int id_prontuario) {
        this.id_prontuario = id_prontuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Paciente getPac() {
        return pac;
    }

    public void setPac(Paciente pac) {
        this.pac = pac;
    }

    public Medicamento getMedc() {
        return medc;
    }

    public void setMedc(Medicamento medc) {
        this.medc = medc;
    }
    
}
