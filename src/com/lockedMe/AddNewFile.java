package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddNewFile {

	public void newFile() throws IOException {

		System.out.println("Add a new file to the folder");
		System.out.println("============================\n\n");

		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the location/path of the file: ");
			System.out.println("Example: D://TestFolder");
			String dirPath = sc.next();
			File userPath = new File(dirPath);
			if(userPath.isDirectory()) {
			System.out.println("\n\nEnter the file name to be created, followed by extension: ");
			System.out.println("Example: File_Name.txt");
			String fileName = sc.next();

			String filePath = dirPath + "//" + fileName;

			File f = new File(filePath);
			if(f.createNewFile()==true) {
				System.out.println("\n\nFile Created\n\n\n");
			}
			else {
				System.out.println("\n\nFile not created\n\n\n");
			}
			endMenuOptions();
			}
			else {
				System.out.println(dirPath + " is NOT a  valid Directory\n\n");
				newFile();
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input. Please select a number related to given options.\n\n");
			newFile();
		}
	}
	
	public void endMenuOptions() throws IOException {

		System.out.println("=======================");
		
		System.out.println("Enter 1 to go back to main menu");
		System.out.println("Enter 2 to add another file");
		try {
			Scanner sc = new Scanner(System.in); 
			int option = sc.nextInt();
			
			switch (option) {
			case 1: {
				System.out.println("\n\n\n");
				MenuMainScreen.chooseOption();
				break;
			}
			case 2: {
				System.out.println("\n\n\n");
				newFile();
				break;
			}
			default:
				System.out.println("\n\n");
				System.out.println("Invalid input. Please select a number related to given options.\n\n");
				endMenuOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("\n\n");
			System.out.println("Invalid input. Please select a number related to given options.\n\n");
			endMenuOptions();
		}
	}
}
