package hfdp_exercises.ex1_strategy_pattern;

public class SwordBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("\n          * Swings a sword *\n");
	}

}