package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoPSQL {
public static Connection connection;
public static String url = "jdbc:postgresql://localhost:5432/consultorio";
public static String user = "postgres";
public static String password = "admin";

public static Connection dbConnection() {

try {

Class.forName("org.postgresql.Driver");

} catch(ClassNotFoundException e ){
//e.getMessage();
}

try {
connection = DriverManager.getConnection(url, user, password);
//JOptionPane.showMessageDialog(null, "Connected");
} catch (SQLException ex) {
Logger.getLogger(ConexaoPSQL.class.getName()).log(Level.SEVERE, null, ex);
JOptionPane.showMessageDialog(null, "Falha ao Conectar");
}

return connection;
}
public static void main(String[] args) {
ConexaoPSQL db = new ConexaoPSQL();
db.dbConnection();
}

}