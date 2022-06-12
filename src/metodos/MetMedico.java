package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetMedico {

    public void cadastrar(Medico m) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO medico(med_nome, med_cpf, med_crm, med_telefone, med_especializacao, med_email) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, m.getNome());
            pst.setString(2, m.getCpf());
            pst.setInt(3, m.getCrm());
            pst.setString(4, m.getTelefone());
            pst.setString(5, m.getEspecializacao());
            pst.setString(6, m.getEmail());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }

    public void atualizar(Medico m) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "UPDATE medico SET med_nome = ?, med_cpf = ?, med_crm = ?, med_telefone = ?, med_especializacao = ?, med_email = ? WHERE med_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, m.getNome());
            pst.setString(2, m.getCpf());
            pst.setInt(3, m.getCrm());
            pst.setString(4, m.getTelefone());
            pst.setString(5, m.getEspecializacao());
            pst.setString(6, m.getEmail());
            pst.setInt(7, m.getId_medico());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro!"+ex.getMessage());
        }
    }

    public void excluir(Medico m) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM medico WHERE med_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, m.getId_medico());
                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!"+ex.getMessage());
            }
        }

    }

    public List<Medico> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico ORDER BY med_nome";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Medico m = new Medico();
                m.setId_medico(resultado.getInt("med_id"));
                m.setNome(resultado.getString("med_nome"));
                m.setCpf(resultado.getString("med_cpf"));
                m.setCrm(resultado.getInt("med_crm"));
                m.setTelefone(resultado.getString("med_telefone"));
                m.setEspecializacao(resultado.getString("med_especializacao"));
                m.setEmail(resultado.getString("med_email"));
                lista.add(m);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public List<Medico> ListarNome(String nome) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico WHERE med_nome LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+nome+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Medico m = new Medico();
                m.setId_medico(resultado.getInt("med_id"));
                m.setNome(resultado.getString("med_nome"));
                m.setCpf(resultado.getString("med_cpf"));
                m.setCrm(resultado.getInt("med_crm"));
                m.setTelefone(resultado.getString("med_telefone"));
                m.setEspecializacao(resultado.getString("med_especializacao"));
                m.setEmail(resultado.getString("med_email"));
                lista.add(m);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!" + ex.getMessage());
        }
        return lista;
    }

}
