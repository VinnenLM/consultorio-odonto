package dados;

public class Receita {
    
    private int id_receita;
    private String data;
    private String observacao;
    private Medicamento medc;
    private Paciente pac;
    private Medico med;

    public int getId_receita() {
        return id_receita;
    }

    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Medicamento getMedc() {
        return medc;
    }

    public void setMedc(Medicamento medc) {
        this.medc = medc;
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
