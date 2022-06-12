package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetFuncionario {

    public void cadastrar(Funcionario f) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO funcionario(func_nome, func_cpf, func_sexo, func_telefone, func_email) VALUES(?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, f.getNome());
            pst.setString(2, f.getCpf());
            pst.setString(3, f.getSexo());
            pst.setString(4, f.getTelefone());
            pst.setString(5, f.getEmail());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }

    public void atualizar(Funcionario f) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "UPDATE funcionario SET func_nome = ?, func_cpf = ?, func_sexo = ?, func_telefone = ?, func_email = ? WHERE func_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, f.getNome());
            pst.setString(2, f.getCpf());
            pst.setString(3, f.getSexo());
            pst.setString(4, f.getTelefone());
            pst.setString(5, f.getEmail());
            pst.setInt(6, f.getId_funcionario());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro!"+ex.getMessage());
        }
    }

    public void excluir(Funcionario f) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM funcionario WHERE func_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, f.getId_funcionario());
                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!"+ex.getMessage());
            }
        }

    }

    public List<Funcionario> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario ORDER BY func_nome";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {//enquanto tiver um proximo, faz a repeticao
                Funcionario f = new Funcionario();
                f.setId_funcionario(resultado.getInt("func_id"));
                f.setNome(resultado.getString("func_nome"));
                f.setCpf(resultado.getString("func_cpf"));
                f.setTelefone(resultado.getString("func_telefone"));
                f.setEmail(resultado.getString("func_email"));
                f.setSexo(resultado.getString("func_sexo"));
                lista.add(f);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!" + ex.getMessage());
        }
        return lista;
    }
    
    public List<Funcionario> ListarNome(String nome) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario WHERE func_nome LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+nome+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Funcionario f = new Funcionario();
                f.setId_funcionario(resultado.getInt("func_id"));
                f.setNome(resultado.getString("func_nome"));
                f.setCpf(resultado.getString("func_cpf"));
                f.setTelefone(resultado.getString("func_telefone"));
                f.setEmail(resultado.getString("func_email"));
                f.setSexo(resultado.getString("func_sexo"));
                lista.add(f);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!" + ex.getMessage());
        }
        return lista;
    }
}
