package usecase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class display_tweet {
	final static String DB_URL="jdbc:mysql://localhost:3306/htday2";
	final static String DB_user="root";
	final static String DB_pass="pass@word1";
	static Scanner sc=new Scanner(System.in);
	
	
	public void my_tweets(String name) {
		try (Connection conn=DriverManager.getConnection(DB_URL,DB_user,DB_pass);
				 PreparedStatement ps=conn.prepareStatement("select tweet_time,tweet_msg from tweets where username=? order by tweet_time desc;");)
				//ResultSet rs =st.executeQuery("select tweet_time,tweet_msg from tweets where email=?");)
			 {
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getString("tweet_time")+ " #You posted: '"+rs.getString("tweet_msg")+"'" );
			}
			 }
				
			 catch(SQLException e) {
				 e.printStackTrace();
					 }
	
	}
	
	public void all_tweets() {
		try (Connection conn=DriverManager.getConnection(DB_URL,DB_user,DB_pass);
				 PreparedStatement ps=conn.prepareStatement("select * from tweets order by tweet_time desc;");)
				//ResultSet rs =st.executeQuery("select tweet_time,tweet_msg from tweets where email=?");)
			 {
			//ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getString("tweet_time")+"  "+rs.getString("username") +" posted: '"+rs.getString("tweet_msg")+"'" );
			}
			 }
				
			 catch(SQLException e) {
				 e.printStackTrace();
					 }
	
		
	}
	
	public void all_users() {
		try (Connection conn=DriverManager.getConnection(DB_URL,DB_user,DB_pass);
				 PreparedStatement ps=conn.prepareStatement("select distinct(first_name) from register;");)
				//ResultSet rs =st.executeQuery("select tweet_time,tweet_msg from tweets where email=?");)
			 {
			//ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			System.out.println("People you may know....");
			while(rs.next()) {
			System.out.println(rs.getString("first_name"));
			}
			 }
				
			 catch(SQLException e) {
				 e.printStackTrace();
					 }
	
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display_tweet dt=new display_tweet();
		dt.my_tweets("Bhoomika");
		dt.all_tweets();
		dt.all_users();
		

	}

}
