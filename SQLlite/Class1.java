package project1;
import java.sql.*;

public class Class1 {
    String sDriverName = "org.sqlite.JDBC";
    String sTempDb = "E:\\1\\sqlite\\test.db";
    String sJdbc = "jdbc:sqlite";
    String sDbUrl = sJdbc + ":" + sTempDb;
    Connection conn =null;
    Statement stmt = null;
    ResultSet rs =null;
    String sMakeSelect = "SELECT * from tbl1";
    
    public Class1() {
    }

    public void Polaczenie_do_DB() {
        
        try {
            Class.forName(sDriverName);
        } catch (ClassNotFoundException e) {
            System.err.print(e);
            System.exit(1);
        }
        try {
            conn = DriverManager.getConnection(sDbUrl);
        } catch (SQLException e) {
            System.err.print(e);
            System.exit(1);
        }
    }
    
    public void Zapytanie_SQL()  {

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
             System.err.print(e);
        }


        try {
            rs = stmt.executeQuery(sMakeSelect);
        } catch (SQLException e) {
            System.err.print(e);
        }
        
        try {
        while(rs.next())
        {
        System.out.println(rs.getString("id")+" "+rs.getString("imie")+" "+rs.getString("nazwisko"));
        }
        } catch (SQLException e) {
             System.err.print(e);
        } finally {
            try { rs.close();  stmt.close(); } catch (Exception ignore) {}
        } 
        
    }

    public void Odlacz_DB() {
        try { conn.close(); } catch (Exception ignore) {}
    }

    public static void main(String[] args) {
        Class1 class1 = new Class1();
        class1.Polaczenie_do_DB();
        class1.Zapytanie_SQL();
        class1.Odlacz_DB();
        
    }
}
