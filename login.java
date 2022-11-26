package usecase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login {
	final static String DB_URL="jdbc:mysql://localhost:3306/htday2";
	final static String DB_user="root";
	final static String DB_pass="pass@word1";
	static Scanner sc=new Scanner(System.in);
	final static String query2="update  register set Login_status=1 where email=?;";
	
	static String username;
	//"insert into login values(?,?);";;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection conn=DriverManager.getConnection(DB_URL,DB_user,DB_pass);
				 PreparedStatement ps=conn.prepareStatement("select * from register where email=? and password=?;");)
			 {
				
				 
				 System.out.println("Enter email address");
				 String lemail=sc.nextLine();
				 
				 System.out.println("Enter password");
				 String lpass=sc.nextLine();
				 
				 ps.setString(1, lemail);			 
				 ps.setString(2, lpass);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					
				  PreparedStatement ps1=conn.prepareStatement(query2);
				  ps1.setString(1, lemail);
				  //ps1.setString(2,"logged in");
				  ps1.executeUpdate();
				  System.out.println("\n----Login successfull!!!----\n");
				  
				  //Post a tweet
				  String username=rs.getString(1);
				  post_tweet pt=new post_tweet();
				  pt.addtweet(username);
				  
				}
				else
				  System.out.println("\n----Login failed----\n");
				 				 		 
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
					 }

}
}
	
	//implement food order app with signin sign up crud operation and logout.
/*login-see particular tweet
-all tweets
-see own tweet
-new tweet
*/

/* login menu 1.post 2.viem my tewwt 3.view all tewwt 4.view all users  5.logout */
	
