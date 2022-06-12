package relatorios;

public class RelProntuario {

    private String data;
    private String inicio;
    private String fim;
    private String resultado;
    private String observacao;
    private String paciente;
    private String medicamento;

    public RelProntuario(){
        
    }
    
    public RelProntuario(String data, String inicio, String fim, String resultado, String observacao, String paciente, String medicamento) {
        this.data = data;
        this.inicio = inicio;
        this.fim = fim;
        this.resultado = resultado;
        this.observacao = observacao;
        this.paciente = paciente;
        this.medicamento = medicamento;
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

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
    
    
    
}