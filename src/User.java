import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//A classe User realiza a autenticação de usuários em um banco de dados MySQL.
public class User {

    /**
     * Método para estabelecer uma conexão com o banco de dados.
     *
     * @return Uma conexão com o banco de dados ou null se a conexão falhar.
     * @throws Exception Se ocorrer um erro durante a conexão.
     * @see ClassNotFoundException
     */
    public Connection conectarBD() throws Exception {
        Connection conn = null;
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // URL de conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1/test7?user=lopes&password=123";

            // Estabelece a conexão
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Lida com exceções durante a conexão
            throw e;
        }
        return conn;
    }

    /**
     * Verifica se um usuário com o login e senha fornecidos existe no banco de dados.
     *
     * @param login O nome de usuário fornecido.
     * @param senha A senha fornecida.
     * @return true se o usuário foi autenticado com sucesso, false caso contrário.
     * @throws Exception Se ocorrer um erro durante a autenticação.
     * @see //SQLException
     */
    public boolean verificarUsuario(String login, String senha) throws Exception {
        // Inicializa a consulta SQL
        String sql = "SELECT nome FROM usuarios " +
                "WHERE login = '" + login + "' AND senha = '" + senha + "';";

        Connection conn = null;
        try {
            // Estabelece a conexão com o banco de dados
            conn = conectarBD();

            // Criação do Statement para execução da consulta
            Statement st = conn.createStatement();

            // Executa a consulta SQL
            ResultSet rs = st.executeQuery(sql);

            // Verifica se a consulta retornou algum resultado
            if (rs.next()) {
                // O usuário foi autenticado com sucesso
                return true;
            }
        } catch (Exception e) {
            // Lida com exceções durante a autenticação
            throw e;
        } finally {
            // Fecha a conexão com o banco de dados após a execução
            if (conn != null) {
                conn.close();
            }
        }
        // Autenticação falhou
        return false;
    }
}

