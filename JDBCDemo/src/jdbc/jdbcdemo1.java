package jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcdemo1 {
	
public static void main(String args[]) throws Exception {
	 //readRecords();
	//insertRecords();
	//insertVarRecords();
	//insertusingPst();
	//delete();
	//update();
	//readRecords();

}
	public static void readRecords() throws Exception{ 
		String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
		String userName = "root"; 
		String passWord = "root"; 
		String query = "select * from student";    
		Connection con = DriverManager.getConnection(url,userName,passWord);  
		Statement st = con.createStatement(); 
		ResultSet rs = st.executeQuery(query);   
		while(rs.next()) { 
			System.out.println("Id is :" + rs.getInt(1));  
			System.out.println("Name is :" + rs.getString(2));  
			System.out.println("CGPA is :" + rs.getDouble(3));
			System.out.println();
			}  
		con.close();
		
	} 

	public static void insertRecords() throws Exception{ 
		String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
		String userName = "root"; 
		String passWord = "root"; 
		String query = "insert into student values(12,'rani',8.80)"; 
		try {
		Connection con = DriverManager.getConnection(url,userName,passWord);  
		Statement st = con.createStatement(); 
        int rows=st.executeUpdate(query);
	    System.out.println("number of rows affected: "+ rows);
	     con.close();
		}catch(Exception e) {
		   System.out.println("duplicate entry.pls check your entry");
			  
		}
	}
	
	public static void insertVarRecords() throws Exception{ 
		String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
		String userName = "root"; 
		String passWord = "root";
		try {
		int id=14;
		String name="premalatha";
		double  gpa=8.89;
		
		String query = "insert into student values( "+ id + ",'" + name +"'," + gpa + ");"; 
		
		Connection con = DriverManager.getConnection(url,userName,passWord);  
		Statement st = con.createStatement(); 
        int rows=st.executeUpdate(query);
		
	   System.out.println("number of rows affected: "+ rows);
	   con.close();
		 
	}catch(Exception e) {
		   System.out.println("duplicate entry.pls check your entry");
			  
		}
	}
	
	
	public static void insertusingPst() throws Exception{ 
		String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
		String userName = "root"; 
		String passWord = "root";
		try {
		int id=18;
		String name="divya";
		double gpa=6.69;
		
		String query = "insert into student values(?,?,?)"; 
		
		Connection con = DriverManager.getConnection(url,userName,passWord);  
		PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,id);
		pst.setString(2, name);
		pst.setDouble(3, gpa);
		int rows=pst.executeUpdate();
	   System.out.println("number of rows affected: "+ rows);
	   con.close();
		}
		catch(Exception e) {
		   System.out.println("duplicate entry.pls check your entry");
		  }
		
		} 
	public static void delete() throws Exception{ 
		String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
		String userName = "root"; 
		String passWord = "root";
		try {
		int id=18;
	    String query = "delete from student where id =" +id ; 
		
		Connection con = DriverManager.getConnection(url,userName,passWord);  
		Statement st = con.createStatement(); 
        int rows=st.executeUpdate(query);
		
	   System.out.println("number of rows affected: "+ rows);
	   con.close();
		 
	    }catch(Exception e) {
		   System.out.println("duplicate entry.pls check your entry");
			  
		}
	}
	public static void update() throws Exception{ 
		String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
		String userName = "root"; 
		String passWord = "root";
		
	    String query = "update student set gpa=6.50 where  id=17"; 
		
		Connection con = DriverManager.getConnection(url,userName,passWord);  
		Statement st = con.createStatement(); 
        int rows=st.executeUpdate(query);
		
	   System.out.println("number of rows affected: "+ rows);
	   con.close();
	
}
}










