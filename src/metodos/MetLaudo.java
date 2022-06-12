package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Laudo;
import dados.Medico;
import dados.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetLaudo {
    
    public void cadastrar(Laudo laud) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO laudo(laud_descricao, laud_data, laud_hora, pac_id, med_id) VALUES(?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, laud.getDescricao());
            pst.setString(2, laud.getData());
            pst.setString(3, laud.getHora());
            pst.setInt(4, laud.getPac().getId_paciente());
            pst.setInt(5, laud.getMed().getId_medico());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }
    
    public List<Laudo> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Laudo> lista = new ArrayList<>();
        String sql = "SELECT * FROM laudo INNER JOIN paciente ON paciente.pac_id = laudo.pac_id"
                + " INNER JOIN medico ON medico.med_id = laudo.med_id order by laud_data";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Laudo laud = new Laudo();
                laud.setId_laudo(resultado.getInt("laud_id"));
                laud.setDescricao(resultado.getString("laud_descricao"));
                laud.setData(resultado.getString("laud_data"));
                laud.setHora(resultado.getString("laud_hora"));                
                Paciente pac = new Paciente();
                pac.setId_paciente(resultado.getInt("pac_id"));
                pac.setNome(resultado.getString("pac_nome"));
                laud.setPac(pac);                    
                Medico med = new Medico();
                med.setId_medico(resultado.getInt("med_id"));
                med.setNome(resultado.getString("med_nome"));
                laud.setMed(med);                
                lista.add(laud);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public List<Laudo> ListarNome(String nome) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Laudo> lista = new ArrayList<>();
        String sql = "SELECT * FROM laudo INNER JOIN paciente ON paciente.pac_id = laudo.pac_id"
                + " INNER JOIN medico ON medico.med_id = laudo.med_id WHERE paciente.pac_nome LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+nome+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Laudo laud = new Laudo();
                laud.setId_laudo(resultado.getInt("laud_id"));
                laud.setDescricao(resultado.getString("laud_descricao"));
                laud.setData(resultado.getString("laud_data"));
                laud.setHora(resultado.getString("laud_hora"));                
                Paciente pac = new Paciente();
                pac.setId_paciente(resultado.getInt("pac_id"));
                pac.setNome(resultado.getString("pac_nome"));
                laud.setPac(pac);                    
                Medico med = new Medico();
                med.setId_medico(resultado.getInt("med_id"));
                med.setNome(resultado.getString("med_nome"));
                laud.setMed(med);                
                lista.add(laud);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public void excluir(Laudo laud) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM laudo WHERE laud_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, laud.getId_laudo());
                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!"+ex.getMessage());
            }
        }

    }
    
}
