package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetPaciente {

    public void cadastrar(Paciente p) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO paciente(pac_nome, pac_cpf, pac_datanasc, pac_sexo, pac_telefone, pac_idade, pac_email) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, p.getNome());
            pst.setString(2, p.getCpf());
            pst.setString(3, p.getDataNasc());
            pst.setString(4, p.getSexo());
            pst.setString(5, p.getTelefone());
            pst.setString(6, p.getIdade());
            pst.setString(7, p.getEmail());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }

    public void atualizar(Paciente p) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "UPDATE paciente SET pac_nome = ?, pac_cpf = ?, pac_datanasc = ?, pac_sexo = ?, pac_telefone = ?"
                + ", pac_idade = ?, pac_email = ? WHERE pac_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, p.getNome());
            pst.setString(2, p.getCpf());
            pst.setString(3, p.getDataNasc());
            pst.setString(4, p.getSexo());
            pst.setString(5, p.getTelefone());
            pst.setString(6, p.getIdade());
            pst.setString(7, p.getEmail());
            pst.setInt(8, p.getId_paciente());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro!"+ex.getMessage());
        }
    }

    public void excluir(Paciente p) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM paciente WHERE pac_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, p.getId_paciente());
                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!"+ex.getMessage());
            }
        }
    }

    public List<Paciente> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente ORDER BY pac_nome";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {//enquanto tiver um proximo, faz a repeticao
                Paciente p = new Paciente();
                p.setId_paciente(resultado.getInt("pac_id"));
                p.setNome(resultado.getString("pac_nome"));
                p.setCpf(resultado.getString("pac_cpf"));
                p.setDataNasc(resultado.getString("pac_datanasc"));
                p.setSexo(resultado.getString("pac_sexo"));
                p.setTelefone(resultado.getString("pac_telefone"));
                p.setIdade(resultado.getString("pac_idade"));
                p.setEmail(resultado.getString("pac_email"));
                lista.add(p);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public List<Paciente> ListarNome(String nome) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE pac_nome LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+nome+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Paciente p = new Paciente();
                p.setId_paciente(resultado.getInt("pac_id"));
                p.setNome(resultado.getString("pac_nome"));
                p.setCpf(resultado.getString("pac_cpf"));
                p.setDataNasc(resultado.getString("pac_datanasc"));
                p.setSexo(resultado.getString("pac_sexo"));
                p.setTelefone(resultado.getString("pac_telefone"));
                p.setIdade(resultado.getString("pac_idade"));
                p.setEmail(resultado.getString("pac_email"));
                lista.add(p);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!" + ex.getMessage());
        }
        return lista;
    }

}
