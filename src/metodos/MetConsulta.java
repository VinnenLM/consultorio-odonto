package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Consulta;
import dados.Medico;
import dados.Paciente;
import dados.TipoConsulta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetConsulta {

    public void cadastrar(Consulta c) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO consulta(cons_data, cons_horario, cons_status, "
                + "pac_id, med_id, tipcon_id) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, c.getData());
            pst.setString(2, c.getHora());
            pst.setString(3, c.getStatus());
            pst.setInt(4, c.getPac().getId_paciente());
            pst.setInt(5, c.getMed().getId_medico());
            pst.setInt(6, c.getTipcon().getId_tipoConsulta());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }
    
    public void atualizar(Consulta c) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "UPDATE consulta SET cons_data = ?, cons_horario = ?, cons_status = ?,"
                + " pac_id = ?, med_id = ?,"
                + " tipcon_id = ? WHERE cons_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, c.getData());
            pst.setString(2, c.getHora());
            pst.setString(3, c.getStatus());
            pst.setInt(4, c.getPac().getId_paciente());
            pst.setInt(5, c.getMed().getId_medico());
            pst.setInt(6, c.getTipcon().getId_tipoConsulta());
            pst.setInt(7, c.getId_consulta());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro!"+ex.getMessage());
        }
    }
    
    public void excluir(Consulta c) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM consulta WHERE cons_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, c.getId_consulta());
                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!"+ex.getMessage());
            }
        }
    }
    
    public List<Consulta> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta"
                + " INNER JOIN paciente ON paciente.pac_id = consulta.pac_id"
                + " INNER JOIN medico ON medico.med_id = consulta.med_id"
                + " INNER JOIN tipoconsulta ON tipoConsulta.tipcon_id = consulta.tipcon_id";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Consulta c = new Consulta();
                c.setId_consulta(resultado.getInt("cons_id"));
                c.setData(resultado.getString("cons_data"));
                c.setHora(resultado.getString("cons_horario"));
                c.setStatus(resultado.getString("cons_status"));
                Paciente p = new Paciente();
                p.setId_paciente(resultado.getInt("pac_id"));
                p.setNome(resultado.getString("pac_nome"));
                c.setPac(p);
                Medico m = new Medico();
                m.setId_medico(resultado.getInt("med_id"));
                m.setNome(resultado.getString("med_nome"));
                c.setMed(m);             
                TipoConsulta tipcon = new TipoConsulta();
                tipcon.setId_tipoConsulta(resultado.getInt("tipcon_id"));
                tipcon.setTipo_consulta(resultado.getString("tipcon_tipo"));
                tipcon.setValor(resultado.getString("tipcon_valor"));
                c.setTipcon(tipcon);
                lista.add(c);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public List<Consulta> ListarData(String data) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta"
                + " INNER JOIN paciente ON paciente.pac_id = consulta.pac_id"
                + " INNER JOIN medico ON medico.med_id = consulta.med_id"
                + " INNER JOIN tipoconsulta ON tipoConsulta.tipcon_id = consulta.tipcon_id WHERE consulta.cons_data = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, data);
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Consulta c = new Consulta();
                c.setId_consulta(resultado.getInt("cons_id"));
                c.setData(resultado.getString("cons_data"));
                c.setHora(resultado.getString("cons_horario"));
                c.setStatus(resultado.getString("cons_status"));
                Paciente p = new Paciente();
                p.setId_paciente(resultado.getInt("pac_id"));
                p.setNome(resultado.getString("pac_nome"));
                c.setPac(p);
                Medico m = new Medico();
                m.setId_medico(resultado.getInt("med_id"));
                m.setNome(resultado.getString("med_nome"));
                c.setMed(m);             
                TipoConsulta tipcon = new TipoConsulta();
                tipcon.setId_tipoConsulta(resultado.getInt("tipcon_id"));
                tipcon.setTipo_consulta(resultado.getString("tipcon_tipo"));
                tipcon.setValor(resultado.getString("tipcon_valor"));
                c.setTipcon(tipcon);
                lista.add(c);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
}
