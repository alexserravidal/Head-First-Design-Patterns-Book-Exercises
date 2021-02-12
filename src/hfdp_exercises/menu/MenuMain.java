package hfdp_exercises.menu;

public class MenuMain extends Menu {

	@Override
	void printHeader() {
		System.out.println("\n");
		System.out.println("---------------------------------------------------" + "\n");
		System.out.println("      Welcome to the Head First Design Patterns    ");
		System.out.println("                exercises demo                     " + "\n");
		System.out.println("---------------------------------------------------");		
	}

	@Override
	void printMenu() {
		System.out.println("\n" + "Please make a selection: " + "\n");
		System.out.println("     1) Exercise 1: Strategy Pattern" + "\n");
		System.out.println("     2) Exercise 2: Observer pattern" + "\n");
		System.out.println("     0) Exit");
	}

	@Override
	void performAction(int choice) {
		switch(choice) {
			case 0:
				exit();
				System.out.println("Thank you for using me. I love being used.");
				break;
			case 1:
				swapMenu(MenusEnum.EX1_MENU);
				break;
			case 2:
				swapMenu(MenusEnum.EX2_MENU);
				break;
			default:
				System.out.println("Unexpected error occurred");
				break;
		}
	}

	@Override
	boolean isChoiceValid(int choice) {
		return choice >= 0 && choice <= 2;	
	}
}
