package metodos;

import conexao.Conexao;
import conexao.ConexaoPSQL;
import dados.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class MetUsuario {
    
    public void cadastrar(Usuario user) {
        Connection con = ConexaoPSQL.dbConnection();
        String sql = "INSERT INTO usuario(user_login, user_senha, user_perfil) VALUES(?,MD5(?),?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getSenha());
            pst.setString(3, user.getPerfil());
            pst.executeUpdate();
            pst.close();
            con.close();
            //JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex.getMessage());
        }
    }    
}
