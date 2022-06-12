package dados;

public class Consulta {
    private int id_consulta;
    private String data;
    private String hora;
    private String status;
    private Paciente pac;
    private Medico med;
    private TipoConsulta tipcon;

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public TipoConsulta getTipcon() {
        return tipcon;
    }

    public void setTipcon(TipoConsulta tipcon) {
        this.tipcon = tipcon;
    }
    
}