package com.github.submarine.nova.fleet;

import com.github.submarine.nova.armours.Armour;
import com.github.submarine.nova.weapons.Weapon;
import com.github.submarine.nova.Piece;

public class Ship extends Piece {
	protected int health;
	protected Armour armour;
	protected Weapon weapon;

	public Ship(
		String name,
		int health,
		Armour armour,
		Weapon weapon
	) {
		super(name);
		this.health = health;
		this.armour = armour;
		this.weapon = weapon;
	}

	public void takeDamage(Weapon weapon) {
		if (weapon.getTechLevel() >= this.getArmour().getTechLevel()) {
			int taken;
			if (this.getArmour().getResist() > 0) {
				taken = weapon.getDamage() - this.getArmour().getResist();
				this.getArmour().reduceIntegrity(Math.max(taken, 1));
			} else {
				taken = weapon.getDamage();
			}
			this.health -= taken;
		}
	}

	public int getHealth() { return this.health; }
	public Weapon getWeapon() { return this.weapon; }
	public Armour getArmour() { return this.armour; }
}
