package Java.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    private static String URL = "jdbc:mysql://localhost:3306/projeto_contabilidade";
    private static final String USUARIO = "root";
    private static final String SENHA = "123";
    private static Connection conn;

    public static Connection getConexao(){
        try {
            if(conn == null){
                conn = DriverManager.getConnection(URL,USUARIO,SENHA);
                return conn;
            }else {
                return conn;
            }
        }catch (SQLException e){

            throw new RuntimeException(e);

        }


    }




}
