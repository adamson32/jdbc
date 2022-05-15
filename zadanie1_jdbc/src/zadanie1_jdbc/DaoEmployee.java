
package zadanie1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoEmployee {
    Connection con=null;
    public void connect()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-442E11CB\\SQLEXPRESS:1433;databaseName=company;selectMethod=cursor","adam", "adam");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void close() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                
            }
        }
    }
    
}
