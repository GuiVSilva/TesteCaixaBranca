import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    //Ponto 1
    public Connection concectarBD(){
        Connection conn = null;
        try{
            //Ponto 2
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test7user=lopes&password=123";
            //Ponto 3
            conn = DriverManager.getConnection(url);
        }catch (Exception e){
            //Ponto 4
        }
        //Ponto 5
        return conn;
    }
    //Ponto 6
    public String nome="";
    public boolean result = false;

    //Ponto 7
    public boolean verificarUsuario(String login, String senha){
        String sql = "";

        //Ponto 8
        Connection conn = concectarBD();

        //Ponto 9
        //INSTRUÇÃO SQL
        sql += "select nome from usuarios";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";
        try {
            //Ponto 10
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                //Ponto 11
                result = true;
                nome = rs.getString("nome");
            }
        }catch (Exception e){
            //Ponto 12
        }
        //Ponto 13
        return result;
    }
}
