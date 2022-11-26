package usecase;
import java.sql.*;
import java.util.Scanner;
public class signup {
	final static String DB_URL="jdbc:mysql://localhost:3306/htday2";
	final static String DB_user="root";
	final static String DB_pass="pass@word1";
	static Scanner sc=new Scanner(System.in);

	public static void register(){
		// TODO Auto-generated method stub
		try (Connection conn=DriverManager.getConnection(DB_URL,DB_user,DB_pass);
				 PreparedStatement ps=conn.prepareStatement("insert into register values(?,?,?,?)");)
			 {
				
				 System.out.println("Enter first name");
				 String lname=sc.nextLine();
				 
				 System.out.println("Enter email address");
				 String lemail=sc.nextLine();
				 
				 System.out.println("Enter password");
				 String lpass=sc.nextLine();
				 
				 
				 
				 ps.setString(1, lname);
				 
				 ps.setString(2,lemail);
				 
				 ps.setString(3, lpass);
				 ps.setInt(4, 0);
				 ps.executeUpdate();
				 System.out.println("\n----Signup successfull!!!----\n");
				 				 		 
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
					 }
		
			
	}

}
