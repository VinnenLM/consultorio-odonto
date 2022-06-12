package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetMedicamento {

    public void cadastrar(Medicamento medc) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO medicamento(medc_nome) VALUES(?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, medc.getNome());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + ex.getMessage());
        }
    }

    public void excluir(Medicamento medc) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM medicamento WHERE medc_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, medc.getId_medicamento());
                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!" + ex.getMessage());
            }
        }

    }

    public List<Medicamento> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicamento ORDER BY medc_nome";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Medicamento medc = new Medicamento();
                medc.setId_medicamento(resultado.getInt("medc_id"));
                medc.setNome(resultado.getString("medc_nome"));
                lista.add(medc);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!" + ex.getMessage());
        }
        return lista;
    }

    public List<Medicamento> ListarNome(String nome) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicamento WHERE medc_nome LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+nome+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Medicamento medc = new Medicamento();
                medc.setId_medicamento(resultado.getInt("medc_id"));
                medc.setNome(resultado.getString("medc_nome"));
                lista.add(medc);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!" + ex.getMessage());
        }
        return lista;
    }

}
