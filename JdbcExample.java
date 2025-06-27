package JDBC;

import java.sql.*;

public class JdbcExample {
// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
static final String DB_URL = "jdbc:mysql://localhost/java";

//Database credentials
static final String USER = "root";
static final String PASS = "Root";
	   
public static void main(String[] args) {
Connection conn = null;
Statement stmt = null;

try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	     // STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Creating a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT employeeId, employeeName, employeeSalary FROM employee";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      System.out.println("Fetching & Displaying the data...");
	      while(rs.next()){
	         //Retrieve by column name
	    	 System.out.println("");
	    	 int id  = rs.getInt("employeeId");
	         String name = rs.getString("employeeName");
	         float salary = rs.getFloat("employeeSalary");

	         //Display values
	         System.out.print(id + "\t");
	         System.out.print(name + "\t");
	         System.out.print(salary + "\t");
	      }
	      System.out.println("");
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   		}
	   finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Completion done...");
	}//end main
	}//end FirstExample
	
	
