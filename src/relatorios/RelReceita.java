package relatorios;

public class RelReceita {

    private String data;
    private String paciente;
    private String medico;
    private String medicamento;
    private String observacao;

    public RelReceita(){
    }
    
    public RelReceita(String data, String paciente, String medico, String medicamento, String observacao) {
        this.data = data;
        this.paciente = paciente;
        this.medico = medico;
        this.medicamento = medicamento;
        this.observacao = observacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
    
}
