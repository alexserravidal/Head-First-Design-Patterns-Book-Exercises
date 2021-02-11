package hfdp_exercises.ex1_strategy_pattern;

public class King extends Character {
	public King() {
		this.setWeapon(new SwordBehavior());
	}
	
	public void fight() {
		useWeapon();
	}
}
