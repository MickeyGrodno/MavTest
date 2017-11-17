import java.sql.*;

public class MavTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        String name = "root";
        String password = "12345";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, name, password);
            Statement start = connection.createStatement();

//            start.executeUpdate("INSERT INTO table_name (ID, NAME) VALUES (777, 'OLE')");

            ResultSet result = start.executeQuery("SELECT * FROM table_name WHERE ID = 777");

            while (result.next()) {
                System.out.println(result.getString("ID") + " " + result.getString("NAME"));
            }
        }
        finally {
            connection.close();
        }
    }
}
