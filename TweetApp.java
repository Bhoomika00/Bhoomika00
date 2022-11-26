package usecase;

import java.util.Scanner;


public class TweetApp {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		signup signobj=new signup();
		System.out.println("-----------TWEET APP-----------/n");
		System.out.println("***WELCOME***");
		
		while(true)
		{
			
			System.out.println("1.REGISTER");
			System.out.println("2.LOGIN");
			System.out.println("3.CHANGE PASSWORD");
			System.out.println("!!Please select any one option to proceed further!!");
			//System.out.println("");
			String option=sc.next();
			
			switch(option) {
			case "1":
				signobj.register();
				break;
				
			}
			
			
			
			
		}
	}
}
