
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Javaselect {
		public static void main(String[] args) throws Exception {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/CTS_DB","userName","password");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root");

			Statement stmt = con.createStatement();//create query
			ResultSet rs = stmt.executeQuery("select * from studentdatabase");//query execute

			while(rs.next())//rs object loop one by one iteration executed
			{
			System.out.println(rs.getInt(1)+"\t | "+rs.getString(2)+"\t | "+rs.getInt(3)+"\t | "
			+rs.getString(4));//to convert the datatype
			}
			con.close();
		}

	}



