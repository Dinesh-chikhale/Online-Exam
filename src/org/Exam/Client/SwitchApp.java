package org.Exam.Client;
import java.util.*;
public class SwitchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		do {
			
			int choice;
			System.out.println("1 case ----------");
			System.out.println("2 case _________");
			System.out.println("Enter the your choice");
			choice=s.nextInt();
			switch(choice)
			{
			case 1:
				do {
					System.out.println("1 case sub ");
					System.out.println("2 case sub");
					System.out.println("Enter your choice");
					int cho=s.nextInt();
					switch(cho)
					{
					case 1:
						break;
					case 2:
						break;
					case 3:
						System.out.println("in third case");
						System.exit(0);
					}
				}while(true);
			case 2:
				System.out.println("Main 2 case");
				break;
			}
		}while(true);
	}

}
