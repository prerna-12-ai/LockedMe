package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Search_File {

	public void searchFile() throws IOException {

		System.out.println("Search for a file from the folder");
		System.out.println("============================\n\n");

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the location/path of the file: ");
			System.out.println("Example: D://TestFolder");
			String dirPath = sc.next();

			System.out.println("\n\nEnter the file name to be searched, followed by extension: ");
			System.out.println("Example: File_Name.txt");
			String fileName = sc.next();

			String filePath = dirPath + "//" + fileName;

			File f = new File(filePath);
			if (f.exists() == true) {
				System.out.println("\n\nFile " + fileName + " EXISTS\n\n");
			} else {
				System.out.println("\n\nFile " + fileName + " NOT FOUND\n\n");
			}
			endMenuOptions();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please select a number related to given options.\n\n");
			searchFile();
		}
	}

	public void endMenuOptions() throws IOException {

		System.out.println("=======================");

		System.out.println("Enter 1 to go back to main menu");
		System.out.println("Enter 2 to search another file");
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
				searchFile();
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

