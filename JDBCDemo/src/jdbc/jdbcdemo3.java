package jdbc;

import java.sql.*;

public class jdbcdemo3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		commitdemo();
		//batchdemo();
	}
		public static void commitdemo() throws Exception{ 
			String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
			String userName = "root"; 
			String passWord = "root"; 
			
	        String query1="update student set gpa= 9.90 where id=1";
	        String query2="update student set gpa= 9.90 where id=2";

			Connection con = DriverManager.getConnection(url,userName,passWord);  
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			int rows1=st.executeUpdate(query1);
		    System.out.println("rows1 affected :"+rows1);
		    
		    int rows2=st.executeUpdate(query2);
		    System.out.println("rows2 affected :"+rows2);
		    
		    if(rows1>0 && rows2>0)
		    	con.commit();
			con.close();
	}
		
		public static void batchdemo() throws Exception{ 
			String url = "jdbc:mysql://localhost:3306/ARULJOTHI"; 
			String userName = "root"; 
			String passWord = "root"; 
			
	        String query1="update student set gpa= 6.90 where id=1";
	        String query2="update student set gpa= 6.90 where id=2";
	        String query3="update student set gpa= 6.90 where id=3";
	        String query4="update student set gpa= 8.90 where id=4";

			Connection con = DriverManager.getConnection(url,userName,passWord);  
	       con.setAutoCommit(false);
			Statement st=con.createStatement();
			st.addBatch(query1);
			st.addBatch(query2);
			st.addBatch(query3);
			st.addBatch(query4);
			int res[]=st.executeBatch();
			for(int st2:res) {
				if(st2 >0)
					continue;
				else
					con.rollback();
				//System.out.println(" Rows affected: "+ st2);
			}
			con.commit();
			con.close();
		}

}
