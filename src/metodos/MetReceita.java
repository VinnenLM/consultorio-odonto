package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Medicamento;
import dados.Medico;
import dados.Paciente;
import dados.Receita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetReceita {
    
    public void cadastrar(Receita rec) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO receita(rec_data, rec_observacao, medc_id, pac_id, med_id) VALUES(?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, rec.getData());
            pst.setString(2, rec.getObservacao());
            pst.setInt(3, rec.getMedc().getId_medicamento());
            pst.setInt(4, rec.getPac().getId_paciente());
            pst.setInt(5, rec.getMed().getId_medico());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }
    
    public List<Receita> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Receita> lista = new ArrayList<>();
        String sql = "SELECT * FROM receita INNER JOIN medicamento ON medicamento.medc_id = receita.medc_id"
                + " INNER JOIN paciente ON paciente.pac_id = receita.pac_id"
                + " INNER JOIN medico ON medico.med_id = receita.med_id order by rec_data";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Receita rec = new Receita();
                rec.setId_receita(resultado.getInt("rec_id"));
                rec.setData(resultado.getString("rec_data"));
                rec.setObservacao(resultado.getString("rec_observacao"));
                Medicamento medc = new Medicamento();
                medc.setId_medicamento(resultado.getInt("medc_id"));
                medc.setNome(resultado.getString("medc_nome"));
                rec.setMedc(medc);
                Paciente pac = new Paciente();
                pac.setId_paciente(resultado.getInt("pac_id"));
                pac.setNome(resultado.getString("pac_nome"));
                rec.setPac(pac);             
                Medico med = new Medico();
                med.setId_medico(resultado.getInt("med_id"));
                med.setNome(resultado.getString("med_nome"));
                rec.setMed(med);
                lista.add(rec);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public List<Receita> ListarNome(String nome) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Receita> lista = new ArrayList<>();
        String sql = "SELECT * FROM receita INNER JOIN medicamento"
                + " ON medicamento.medc_id = receita.medc_id"
                + " INNER JOIN paciente ON paciente.pac_id = receita.pac_id"
                + " INNER JOIN medico ON medico.med_id = receita.med_id WHERE paciente.pac_nome LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+nome+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Receita rec = new Receita();
                rec.setId_receita(resultado.getInt("rec_id"));
                rec.setData(resultado.getString("rec_data"));
                rec.setObservacao(resultado.getString("rec_observacao"));
                Medicamento medc = new Medicamento();
                medc.setId_medicamento(resultado.getInt("medc_id"));
                medc.setNome(resultado.getString("medc_nome"));
                rec.setMedc(medc);
                Paciente pac = new Paciente();
                pac.setId_paciente(resultado.getInt("pac_id"));
                pac.setNome(resultado.getString("pac_nome"));
                rec.setPac(pac);             
                Medico med = new Medico();
                med.setId_medico(resultado.getInt("med_id"));
                med.setNome(resultado.getString("med_nome"));
                rec.setMed(med);
                lista.add(rec);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public void excluir(Receita rec) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM receita WHERE rec_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, rec.getId_receita());
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
