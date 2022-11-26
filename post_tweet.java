package usecase;

import java.sql.*;
import java.util.Scanner;

public class post_tweet {
	final static String DB_URL="jdbc:mysql://localhost:3306/htday2";
	final static String DB_user="root";
	final static String DB_pass="pass@word1";
	static Scanner sc=new Scanner(System.in);
	static login l=new login();
	static String tusername;
	
	
	public static void addtweet(String name){
		try (Connection conn=DriverManager.getConnection(DB_URL,DB_user,DB_pass);
				 PreparedStatement ps=conn.prepareStatement("insert into tweets values(?,?,now())");)
			 {
				 //String tname=name;
				 System.out.println("Enter your Tweet that you wish to post:");
				 String tmsg=sc.nextLine();
				 /*PreparedStatement ps1=conn.prepareStatement("select first_name from register where Login_status=1;");
				 ResultSet rs=ps1.executeQuery();
				 if(rs.next())
					 tname=rs.getString(1);
					 */
					 
				 ps.setString(1,name);
				 
				 ps.setString(2, tmsg);
				 ps.executeUpdate();
				 System.out.println("\n----Tweet Posted Successfully----\n");
				 				 		 
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
					 }
			 
	}
}
