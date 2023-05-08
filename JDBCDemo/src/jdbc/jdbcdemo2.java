package jdbc;

import java.sql.*;
public class jdbcdemo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//sp();
		//sp2();
		sp3();

	}
	public static void sp() throws Exception{ 
		String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
		String userName = "root"; 
		String passWord = "root"; 
		
		Connection con = DriverManager.getConnection(url,userName,passWord);  
		CallableStatement cst=con.prepareCall("{call GetStu()}");  
		ResultSet rs=cst.executeQuery();
		while(rs.next()) { 
			System.out.println("Id is :" + rs.getInt(1));  
			System.out.println("Name is :" + rs.getString(2));  
			System.out.println("CGPA is :" + rs.getDouble(3));
			System.out.println();
			}
		con.close();
		
	} 
		public static void sp2() throws Exception{ 
			String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
			String userName = "root"; 
			String passWord = "root"; 
			
			int id=5;
			Connection con = DriverManager.getConnection(url,userName,passWord);  
			CallableStatement cst=con.prepareCall("{call GetStuById(?)}");  
			cst.setInt(1, id);
			ResultSet rs=cst.executeQuery();
			while(rs.next()) { 
				System.out.println("Id is :" + rs.getInt(1));  
				System.out.println("Name is :" + rs.getString(2));  
				System.out.println("CGPA is :" + rs.getDouble(3));
				System.out.println();
				}
			con.close();
			
		} 
		
		public static void sp3() throws Exception{ 
			String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
			String userName = "root"; 
			String passWord = "root"; 
			
			int id=5;
			Connection con = DriverManager.getConnection(url,userName,passWord);  
			CallableStatement cst=con.prepareCall("{call GetNameById(?,?)}");  
			cst.setInt(1, id);
			cst.registerOutParameter(2, Types.VARCHAR);
		    cst.executeUpdate();
	
		    System.out.println(cst.getString(2));
			
			con.close();
			
	
		
		}
}


