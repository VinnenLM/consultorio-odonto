package relatorios;

public class RelLaudo {
    
    private String descricao;
    private String data;
    private String hora;
    private String paciente;
    private String medico;

    public RelLaudo(){
        
    }
    
    public RelLaudo(String descricao, String data, String hora, String paciente, String medico) {
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
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
    
    
    
}
