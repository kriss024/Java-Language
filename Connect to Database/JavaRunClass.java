import java.sql.*;

import static java.sql.DriverManager.*;

/**
 * Created with IntelliJ IDEA.
 * User: Superuser
 * Date: 29.07.12
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class JavaRunClass {

    public static void main(String[] args) throws SQLException {

        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe){
            System.out.println("Could not find the JDBC driver!");
            System.exit(1);
        }

        String url ="jdbc:postgresql://localhost:5432/postgres";
        String user ="postgres";
        String password ="root";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection
                    (url, user, password);
        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            System.exit(1);
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM weather ");

        while (rs.next()) {
            String city = rs.getString("city");
            String date = rs.getString("date");
            Float prcp = rs.getFloat("prcp");
            int temp_hi = rs.getInt("temp_hi");
            int temp_lo = rs.getInt("temp_lo");

            System.out.println(city+" "+date+" "+prcp+" "+temp_hi+" "+temp_lo);
        }

        conn.close();


    }
}


