package dados;

public class TipoConsulta {
    private int id_tipoConsulta;
    private String tipo_consulta;
    private String valor;

    public int getId_tipoConsulta() {
        return id_tipoConsulta;
    }

    public void setId_tipoConsulta(int id_tipoConsulta) {
        this.id_tipoConsulta = id_tipoConsulta;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
