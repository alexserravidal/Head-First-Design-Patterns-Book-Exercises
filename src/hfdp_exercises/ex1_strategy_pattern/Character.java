package hfdp_exercises.ex1_strategy_pattern;

public abstract class Character {
	
	private WeaponBehavior weapon;
	
	abstract void fight();
	
	public void useWeapon() {
		this.weapon.useWeapon();
	}
	
	public void setWeapon(WeaponBehavior w) {
		this.weapon = w;
	}
}
