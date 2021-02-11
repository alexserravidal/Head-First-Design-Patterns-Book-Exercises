package hfdp_exercises.menu;

import java.util.Scanner;

public abstract class Menu {
	
	private static Menu instance = null;
	
	private boolean exit = false;
	private MenusEnum swapMenu = null;
	
	public static Menu getInstance() {
		if (instance == null) instance = new MenuMain();
		return instance;
	}
	
	abstract void printHeader();
	abstract void printMenu();
	abstract void performAction(int choice);
	abstract boolean isChoiceValid(int choice);
	
	public void runMenu() {
		printHeader();
		while(!exit && swapMenu == null) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
		
		if (swapMenu != null) {
			swapMenuInstance(swapMenu);
		}
	}
	
	private int getInput() {
		Scanner kb = new Scanner(System.in);
		int choice = -1;
		
		while(!isChoiceValid(choice)) {
			try {
				System.out.println("\n\nEnter your choice: ");
				choice = Integer.parseInt(kb.nextLine());
				if (!isChoiceValid(choice)) throw new Exception("\nInvalid selection. Please try again.");
			}
			catch(NumberFormatException e) {
				System.out.println("\nInvalid selection. Please try again.");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return choice;
	}
	
	protected void swapMenu(MenusEnum menu) {
		swapMenu = menu;
	}
	
	private void swapMenuInstance(MenusEnum menu) {
		switch(menu) {
		case MAIN_MENU: 
			instance = new MenuMain();
			instance.runMenu();
			break;
		case EX1_MENU:
			instance = new MenuEx1();
			instance.runMenu();
			break;
		}
	}
	
	protected void exit() {
		exit = true;
	}
}
