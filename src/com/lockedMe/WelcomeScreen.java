package com.lockedMe;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeScreen 
{

	public static void displayWelcome() throws IOException 
	{
		String appHeader = String.format("*****************************************************\n"
				+ "** Welcome to LockedMe.com. \n" + "** This application was developed by Prerna Dewangan.\n"
				+ "*****************************************************\n");

		String appDetails = "You can use this application to :-\n" + "--> Retrieve all file names in a given folder.\n"
				+ "--> Search, add, or delete files in a folder.\n"
				+ "\n**Please be careful to ensure the correct filename is provided for searching or deleting files.**\n";

		String welcomeMenu = "\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Display menu for various operations\n" + "2) Exit program\n";

		System.out.println(appHeader);

		System.out.println(appDetails);

		System.out.println(welcomeMenu);

		try 
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Please enter the number provided for the function you want to perform: ");
			int option = sc.nextInt();

			switch (option) 
			{
				case 1: 
				{
					System.out.println("\n\n\n");
					MenuMainScreen.chooseOption();
					break;
				}
				case 2: 
				{
					System.out.println("\n\nProgram is Terminated.");
					System.exit(1);
					break;
				}
				default:
					System.out.println("\n\n");
					System.out.println("Invalid input. Please select a number related to given options.\n\n");
					displayWelcome();
			}
			sc.close();
		} 
		catch (Exception e) 
		{
			System.out.println("\n\n");
			System.out.println("Invalid input. Please select a number related to given options.\n\n");
			displayWelcome();
		}
	}
}
