package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Medicamento; 
import dados.Paciente;
import dados.Prontuario;
import dados.Receita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MetProntuario {
    
    public void cadastrar(Prontuario pront) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO prontuario(pront_data, pront_inicio, pront_fim, pront_resultado, pront_observacao, pac_id, medc_id) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, pront.getData());
            pst.setString(2, pront.getInicio());
            pst.setString(3, pront.getFim());
            pst.setString(4, pront.getResultado());
            pst.setString(5, pront.getObservacao());;
            pst.setInt(6, pront.getPac().getId_paciente());
            pst.setInt(7, pront.getMedc().getId_medicamento());
            pst.executeUpdate();
            pst.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }
    
    public List<Prontuario> ListarTodos() {
        Connection con = ConexaoPSQL.dbConnection();
        List<Prontuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM prontuario INNER JOIN paciente ON paciente.pac_id = prontuario.pac_id"
                + " INNER JOIN medicamento ON medicamento.medc_id = prontuario.medc_id ORDER BY pront_data";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Prontuario pront = new Prontuario();
                pront.setId_prontuario(resultado.getInt("pront_id"));
                pront.setData(resultado.getString("pront_data"));
                pront.setInicio(resultado.getString("pront_inicio"));
                pront.setFim(resultado.getString("pront_fim"));
                pront.setResultado(resultado.getString("pront_resultado"));
                pront.setObservacao(resultado.getString("pront_observacao"));
                Paciente pac = new Paciente();
                pac.setId_paciente(resultado.getInt("pac_id"));
                pac.setNome(resultado.getString("pac_nome"));
                pront.setPac(pac); 
                Medicamento medc = new Medicamento();
                medc.setId_medicamento(resultado.getInt("medc_id"));
                medc.setNome(resultado.getString("medc_nome"));
                pront.setMedc(medc);
                lista.add(pront);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public List<Prontuario> ListarNome(String nome) {
        Connection con = ConexaoPSQL.dbConnection();
        List<Prontuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM prontuario INNER JOIN paciente ON paciente.pac_id = prontuario.pac_id"
                + " INNER JOIN medicamento ON medicamento.medc_id = prontuario.medc_id WHERE paciente.pac_nome LIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%"+nome+"%");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Prontuario pront = new Prontuario();
                pront.setId_prontuario(resultado.getInt("pront_id"));
                pront.setData(resultado.getString("pront_data"));
                pront.setInicio(resultado.getString("pront_inicio"));
                pront.setFim(resultado.getString("pront_fim"));
                pront.setResultado(resultado.getString("pront_resultado"));
                pront.setObservacao(resultado.getString("pront_observacao"));
                Paciente pac = new Paciente();
                pac.setId_paciente(resultado.getInt("pac_id"));
                pac.setNome(resultado.getString("pac_nome"));
                pront.setPac(pac); 
                Medicamento medc = new Medicamento();
                medc.setId_medicamento(resultado.getInt("medc_id"));
                medc.setNome(resultado.getString("medc_nome"));
                pront.setMedc(medc);
                lista.add(pront);
            }
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os registros!"+ex.getMessage());
        }
        return lista;
    }
    
    public void excluir(Prontuario pront) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "DELETE FROM prontuario WHERE pront_id = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, pront.getId_prontuario());
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
