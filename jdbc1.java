package JDBC;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class jdbc1 {
	  
	  public static void main(String[] args) throws SQLException {

	    String url ="jdbc:mysql://localhost/student"; //update connection string
	    
	    String user = "root";//add your db user id here
	    String password = "Root";//add your db password here
	    
	    Connection conn = DriverManager.getConnection(url, user, password);
	    System.out.println("Successfully connected");
	    
	    //insert employee record into database
	    Statement stmt = conn.createStatement();
	    int rows = stmt.executeUpdate("insert into studentdatabase(studentid,studentname) values(34,'James')");
	    System.out.println("Rows inserted = "+ rows);
	    
	    //update employee record
	    rows= stmt.executeUpdate("Update studentdatabase set studentmarks=31 where studentname='James'");
	    System.out.println("Rows updated = "+ rows);
	    
	    //read employee records
	    ResultSet rs = stmt.executeQuery("Select * from studentdatabase");
	    while(rs.next()){
	      System.out.println("studentid : " + rs.getInt("studentid") + ", Name : " + rs.getString("studentname") + ", marks : " + rs.getInt("studentmarks"));
	    }
	    
	    //delete employee record
	    rows = stmt.executeUpdate("delete from studentdatabase where studentname = 'James'");
	    System.out.println("Rows deleted = "+ rows);
	  }
	  

	}


	 
	 
	