package hfdp_exercises.menu;

import java.util.Scanner;

public abstract class Menu {
	
	private static Menu instance = null;
	
	private boolean exit = false;
	private boolean menuVisibility = true;
	
	private MenusEnum swapMenu = null;
	
	public static Menu getInstance() {
		if (instance == null) instance = new MenuMain();
		return instance;
	}
	
	abstract void printHeader();
	abstract void printMenu();
	abstract void performAction(int choice);
	abstract boolean isChoiceValid(int choice);
	
	public void runMenu() throws Exception {
		printHeader();
		while(!exit && swapMenu == null) {
				if (menuVisibility) printMenu();
				int choice = getInput();
				performAction(choice);
		}
		
		if (swapMenu != null) {
			swapMenuInstance(swapMenu);
		}
	}
	
	public void setMenuVisibility(boolean mv) {
		menuVisibility = mv;
		if (mv) {
			printHeader();
			printMenu();
		}
	}
	
	private int getInput() {
		Scanner kb = new Scanner(System.in);
		int choice = -1;
		
		while(!isChoiceValid(choice)) {
			try {
				if (menuVisibility) System.out.println("\n\nEnter your choice: ");
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
	
	private void swapMenuInstance(MenusEnum menu) throws Exception {
		switch(menu) {
			case MAIN_MENU: 
				instance = new MenuMain();
				instance.runMenu();
				break;
			case EX1_MENU:
				instance = new MenuEx1();
				instance.runMenu();
				break;
			case EX2_MENU:
				instance = new MenuEx2();
				instance.runMenu();
				break;
			default:
				throw new Exception("This menu doesn't exist");
		}
	}
	
	protected void exit() {
		exit = true;
	}
}
