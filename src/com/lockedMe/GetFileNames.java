package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GetFileNames {
	public void getList() throws IOException {

		System.out.println("List of files and folders in a given folder");
		System.out.println("===========================================\n\n");

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the location/path of the folder: ");
			System.out.println("Example: D://TestFolder");
			String enteredPath = sc.next();
			System.out.println("\n\n");
			File userPath = new File(enteredPath);

			if (userPath.isDirectory()) {
				File[] filesList = userPath.listFiles();
				Arrays.sort(filesList);

				List<String> fileList = new ArrayList<String>();
				List<String> directoryList = new ArrayList<String>();

				for (int i = 0; i < filesList.length; i++) {
					if (filesList[i].isFile()) {
						fileList.add(filesList[i].getName());
					} else if (filesList[i].isDirectory()) {
						directoryList.add(filesList[i].getName());
					}
				}

				System.out.println("\n\n==============================================");
				System.out.println("Files in the directory " + enteredPath);
				System.out.println("==============================================");
				if (fileList.size() >= 0) {
					for (int i = 0; i < fileList.size(); i++) {
						System.out.println(fileList.get(i));
					}
				} else {
					System.out.println("NO FILES in the directory.");
				}

				System.out.println("\n\n==============================================");
				System.out.println("Directories in the directory " + enteredPath);
				System.out.println("==============================================");
				if (directoryList.size() > 0) {
					for (int i = 0; i < directoryList.size(); i++) {
						System.out.println(directoryList.get(i));
					}
				} else {
					System.out.println("NO DIRECTORIES in the directory.");
				}
			} else {
				System.out.println("\n" + enteredPath + " is NOT a directory.");
			}
			endMenuOptions();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please select a number related to given options.\n\n");
			getList();
		}
	}

	public void endMenuOptions() throws IOException {

		System.out.println("\n\n=======================\n");

		System.out.println("Enter 1 to go back to main menu");
		System.out.println("Enter 2 to get another list");
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
				getList();
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
