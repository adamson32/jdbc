
package zadanie1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
    
     public void addEmployee(Employee p)
    {
        String query = "insert into pracownicy(prac_imie,prac_nazwisko,prac_wiek,prac_nr_telefonu,prac_email) values(?,?,?,?,?)";
        PreparedStatement pst;
         try {
             pst = con.prepareStatement(query);
             pst.setString(1, p.getPracImie());
             pst.setString(2, p.getPracNazwisko());
             pst.setInt(3, p.getPracWiek());
             pst.setString(4, p.getPracNrTelefonu());
             pst.setString(5, p.getPracEmail());
             pst.executeUpdate();
         } catch (Exception ex) {
             System.out.println(ex);
         }
        
        
    }
     
     public List<Employee> getAllEmployeesList() throws SQLException
     {
        
         String query = "SELECT * FROM pracownicy";
         List<Employee> list = new ArrayList<Employee>();
         Employee p=null;
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query);
         while (rs.next())
         {
             p=new Employee();
             p.setPracId(rs.getInt("prac_id"));
             p.setPracImie(rs.getString("prac_imie"));
             p.setPracNazwisko(rs.getString("prac_nazwisko"));
             p.setPracWiek(rs.getInt("prac_wiek"));
             p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
             p.setPracEmail(rs.getString("prac_email"));
             list.add(p);
         }
         return list;
         
        
     }
    
     public void getAllEmployees() {
        
        List<Employee> employee;
        try {
            employee =getAllEmployeesList();
            for (Employee p : employee) {
                displayEmployee(p);
                //System.out.println(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }
     
     private static void displayEmployee(Employee p) {
        System.out.println("prac_id:" + p.getPracId());
        System.out.println("prac_imie:" + p.getPracImie());
        System.out.println("prac_nazwisko:" + p.getPracNazwisko());
        System.out.println("prac_wiek:" + p.getPracWiek());
        System.out.println("prac_nr_telefonu:" + p.getPracNrTelefonu());
        System.out.println("prac_email:" + p.getPracEmail());
        System.out.println();
    } 
     
    public Employee getEmployeeByID(int prac_id)
    {
        try {
            String query ="select * from pracownicy where prac_id="+prac_id;
            Employee p = new Employee();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
             p.setPracId(rs.getInt("prac_id"));
             p.setPracImie(rs.getString("prac_imie"));
             p.setPracNazwisko(rs.getString("prac_nazwisko"));
             p.setPracWiek(rs.getInt("prac_wiek"));
             p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
             p.setPracEmail(rs.getString("prac_email"));
            return p;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
     
     
      public Employee dropEmployeeByID(int prac_id)
    {
        try {
            String query ="delete from pracownicy where prac_id="+prac_id;
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
      
      public List<Employee> getEmployeesByEmail_List(String s) throws SQLException
     {
       
         
         String query = "select * from pracownicy where prac_email like '%"+s+"'";
         List<Employee> list = new ArrayList<Employee>();
         Employee p=null;
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query);
         while (rs.next())
         {
             p=new Employee();
             p.setPracId(rs.getInt("prac_id"));
             p.setPracImie(rs.getString("prac_imie"));
             p.setPracNazwisko(rs.getString("prac_nazwisko"));
             p.setPracWiek(rs.getInt("prac_wiek"));
             p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
             p.setPracEmail(rs.getString("prac_email"));
             list.add(p);
         }
         return list;
         
        
     }
     
       public void getEmployeesByEmail(String s) {
       
        List<Employee> employee;
        try {
            employee =getEmployeesByEmail_List(s);
            for (Employee p : employee) {
                displayEmployee(p);
                //System.out.println(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }
       
       public void updateEmployee(int prac_id,String prac_imie,String prac_nazwisko,int prac_wiek,String prac_nr_telefon,String prac_email)
    {
        String query = "update pracownicy\n" +
                        "set prac_imie='"+prac_imie+"',prac_nazwisko='"+prac_nazwisko+"',prac_wiek="+prac_wiek+",prac_nr_telefonu='"+prac_nr_telefon+"',prac_email='"+prac_email+"'\n" +
                        "where prac_id="+prac_id;
        
         try {
             Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
             Employee p=new Employee();
             p.setPracId(rs.getInt("prac_id"));
             p.setPracImie(rs.getString("prac_imie"));
             p.setPracNazwisko(rs.getString("prac_nazwisko"));
             p.setPracWiek(rs.getInt("prac_wiek"));
             p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
             p.setPracEmail(rs.getString("prac_email"));
            
             
         } catch (Exception ex) {
             System.out.println(ex);
         }
        
        
    }
}
