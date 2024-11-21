package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    //Método para retornar conexões com o banco de dados
    public static Connection openConnection() throws  Exception {

        // nome do Driver JBDC para conexão com o banco de dados
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Abrindo conexãocom o banco de dados
        return DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/projeto04", "root", "Antonio2@");
    }
    
}
