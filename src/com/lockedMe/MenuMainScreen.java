package com.lockedMe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMainScreen 
{
	public static void chooseOption() throws IOException 
	{
		System.out.println("Please follow the instructions provided below to use the application.");

		System.out.println("1.	List all the files in a specified directory.");
		System.out.println("2.	Add a new file.");
		System.out.println("3.	Remove an existing file.");
		System.out.println("4.	Search a specific file.");
		System.out.println("8.	Go back to Welcome Page.");
		System.out.println("9.	Close the application.");

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
					GetFileNames listEntries = new GetFileNames();
					listEntries.getList();
					break;
				}
				case 2: 
				{
					System.out.println("\n\n\n");
					AddNewFile addFile = new AddNewFile();
					addFile.newFile();
					break;
				}
				case 3: 
				{
					System.out.println("\n\n\n");
					DeleteFile removeFile = new DeleteFile();
					removeFile.deleteFile();
					break;
				}
				case 4:
				{
					System.out.println("\n\n\n");
					Search_File searchFile = new Search_File();
					searchFile.searchFile();
					break;
				}
				case 8:
				{
					System.out.println("\n\n\n");
					WelcomeScreen.displayWelcome();
					break;
				}
				case 9:
				{
					System.exit(1);
				}
				default:
					System.out.println("\n\n");
					System.out.println("Invalid input. Please select a number related to given options.\n\n");
					chooseOption();
			}
			sc.close();
		} 
		catch (InputMismatchException e) 
		{
			System.out.println("\n\n");
			System.out.println("Invalid input. Please select a number related to given options.\n\n");
			chooseOption();
		}
	}
}