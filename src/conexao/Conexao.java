package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {
    
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String url = "jdbc:mysql://localhost/bancoconsultorio";    
    public static Connection getConexao(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados "+ex.getMessage());
            return null;
        }        
        return con;
    }    
}
