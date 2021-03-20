import java.sql.*;

public class Main {
	Connection conn = null;
	

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public void getConnection(){
			
			try
			{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			  System.out.println("Connected Successfully To Oracle XE");
			  
			}
			catch(Exception ex)
			{
			  ex.printStackTrace();
			  System.exit(1);
			}

	}
	
	public void executeSQLQuery(){
        Statement stmt = null;
        ResultSet rs = null;
		try
		{
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from employees");
		}
		catch(Exception ex)
		{
		  ex.printStackTrace();
		  System.exit(1);
		}
		try
		{
        while (rs.next()) {
            String EMPLOYEE_ID = rs.getString("EMPLOYEE_ID");
            String FIRST_NAME = rs.getString("FIRST_NAME");
            String LAST_NAME = rs.getString("LAST_NAME");
            String PHONE_NUMBER = rs.getString("PHONE_NUMBER");
            String SALARY = rs.getString("SALARY");
            String tab = "\t";
            System.out.println(EMPLOYEE_ID+tab+FIRST_NAME+tab+LAST_NAME+tab+PHONE_NUMBER+tab+SALARY);
        }
		}
		catch(Exception ex)
		{
		  ex.printStackTrace();
		  System.exit(1);
		}
		
	}
	
	public void executeSQLQueryAllColumn(){
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        int count =0;
		try
		{
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from employees");
        rsmd = rs.getMetaData();
        count = rsmd.getColumnCount();
		}
		catch(Exception ex)
		{
		  ex.printStackTrace();
		  System.exit(1);
		}
		for (int i = 1; i <= count; i++)
		{
			String name=null;
			try {
				name = rsmd.getColumnName(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
		
	}
	
    
	public void closeConnection() {
		
		try {
			conn.close();
			System.out.println("Close Oracle XE connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Main orcl = new Main();
	orcl.getConnection();
	orcl.executeSQLQueryAllColumn();
	orcl.closeConnection();
	

	}

}
