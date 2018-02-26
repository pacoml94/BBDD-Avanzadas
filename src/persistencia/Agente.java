package persistencia;

import java.sql.*;

public class Agente {
	
	private Connection connection;
    private String nombreBD = "fifa18";
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:8080/"+nombreBD;
     
    private Agente() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, "", "");     
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Fallo al conectar con BD");
            e.printStackTrace();
        }
    }
     
    public static Agente getAgente() {
        return new Agente();
    }
     
    public Connection getConection() {
        return connection;
    }
     
    public int insert(String sql) throws SQLException {
        Statement statement;
        int rs;
         
        statement = connection.createStatement();
        rs = statement.executeUpdate(sql);
         
        return rs;
    }
     
    public ResultSet read(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
         
        return rs;
    }
     
    public int insert(PreparedStatement ps) throws SQLException {
        int rs;
        rs = ps.executeUpdate();
         
        return rs;
    }
     
    public int update(PreparedStatement ps) throws SQLException {
        int rs = ps.executeUpdate();
         
        return rs;
    }
     
    public int update(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        int rs = statement.executeUpdate(sql);
         
        return rs;
    }
     
    public int delete(PreparedStatement ps) throws SQLException {
        int rs = ps.executeUpdate();
         
        return rs;
    }
     
    public int delete(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        int rs = statement.executeUpdate(sql);
         
        return rs;
    }
}
