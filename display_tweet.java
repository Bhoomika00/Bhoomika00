package usecase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class display_tweet {
	final static String DB_URL="jdbc:mysql://localhost:3306/htday2";
	final static String DB_user="root";
	final static String DB_pass="pass@word1";
	static Scanner sc=new Scanner(System.in);
	
	
	public void my_tweets() {
		try (Connection conn=DriverManager.getConnection(DB_URL,DB_user,DB_pass);
				 Statement st=conn.createStatement();
				 ResultSet rs =st.executeQuery("select * from customers");)
			 {
			List<String> mtweets = new ArrayList<String>();
			while(rs.next())
			    mtweets.add(rs.getString(1));
				mtweets.add(rs.getString(2));				
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
					 }

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
