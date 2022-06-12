package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.TipoConsulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetTipoConsulta {

    public void cadastrar(TipoConsulta tipcon) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO tipoconsulta(tipcon_tipo, tipcon_valor) VALUES(?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, tipcon.getTipo_consulta());
            pst.setString(2, tipcon.getValor());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }

    public void atualizar(TipoConsulta tipcon) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "UPDATE tipoconsulta SET tipcon_tipo = ?, tipcon_valor = ? WHERE tipcon_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, tipcon.getTipo_consulta());
            pst.setString(2, tipcon.getValor());
            pst.setInt(3, tipcon.getId_tipoConsulta());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro!"+ex.getMessage());
        }
    }

    public void excluir(TipoConsulta tipcon) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM tipoconsulta WHERE tipcon_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, tipcon.getId_tipoConsulta());
                pst.executeUpdate();
                pst.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!"+ex.getMessage());
            }
        }

    }

    public List<TipoConsulta> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<TipoConsulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipoconsulta ORDER BY tipcon_tipo";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                TipoConsulta tipcon = new TipoConsulta();
                tipcon.setId_tipoConsulta(resultado.getInt("tipcon_id"));
                tipcon.setTipo_consulta(resultado.getString("tipcon_tipo"));
                tipcon.setValor(resultado.getString("tipcon_valor"));
                lista.add(tipcon);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public List<TipoConsulta> ListarTipCon(String listtipcon) {
        Connection con = ConexaoPSQL.dbConnection();
        List<TipoConsulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipoconsulta WHERE tipcon_tipo LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+listtipcon+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                TipoConsulta tipcon = new TipoConsulta();
                tipcon.setId_tipoConsulta(resultado.getInt("tipcon_id"));
                tipcon.setTipo_consulta(resultado.getString("tipcon_tipo"));
                tipcon.setValor(resultado.getString("tipcon_valor"));
                lista.add(tipcon);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!" + ex.getMessage());
        }
        return lista;
    }
}
