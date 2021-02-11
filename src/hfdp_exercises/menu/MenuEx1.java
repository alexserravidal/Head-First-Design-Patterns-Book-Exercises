package hfdp_exercises.menu;

import hfdp_exercises.ex1_strategy_pattern.AxeBehavior;
import hfdp_exercises.ex1_strategy_pattern.BowAndArrowBehavior;
import hfdp_exercises.ex1_strategy_pattern.King;
import hfdp_exercises.ex1_strategy_pattern.KnifeBehavior;
import hfdp_exercises.ex1_strategy_pattern.SwordBehavior;

public class MenuEx1 extends Menu {
	
	private String[] weapons = { "Sword", "Knife", "BowAndArrow", "Axe" };
	private int selectedWeaponIndex = 0;
	private King king = new King();
	
	@Override
	void printHeader() {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------" + "\n");
		System.out.println("                     Exercise 1: Strategy Pattern                 " + "\n");
		System.out.println("");
		System.out.println("We got an instance of a King, who initially fights with a Sword.. " + "\n");
		System.out.println("------------------------------------------------------------------" + "\n\n");
	}

	@Override
	void printMenu() {
		System.out.println("     1) Fight                                                     " + "\n");
		System.out.println("     2) Change weapon                                             " + "\n");
		System.out.println("     0) Back to menu                                              ");
	}

	@Override
	void performAction(int choice) {
		switch(choice) {
			case 0:
				exit();
				swapMenu(MenusEnum.MAIN_MENU);
				break;
			case 1:
				king.fight();
				break;
			case 2:
				swapKnightWeapon();
				break;
			default:
				System.out.println("Unexpected error occurred");
				break;
		}
	}
	
	@Override
	boolean isChoiceValid(int choice) {
		return choice == 0 || choice == 1 || choice == 2;		
	}
	
	private void swapKnightWeapon() {
		if (selectedWeaponIndex < weapons.length - 1) selectedWeaponIndex++;
		else selectedWeaponIndex = 0;
		System.out.println("\n          -> King weapon swapped to: " + weapons[selectedWeaponIndex] + "\n");
		switch(weapons[selectedWeaponIndex]) {
		 case "Sword":
			king.setWeapon(new SwordBehavior());
			break;
		 case "Axe":
			king.setWeapon(new AxeBehavior());
			break;
		 case "BowAndArrow":
			king.setWeapon(new BowAndArrowBehavior());
			break;
		 case "Knife":
			king.setWeapon(new KnifeBehavior());
			break;
		 default:
			System.out.println("Unexpected error occurred");
			exit();
			break;
		}
	}	
}
