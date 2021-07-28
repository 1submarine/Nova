package com.github.submarine.nova.fleet;

import com.github.submarine.nova.Piece;
import com.github.submarine.nova.armours.Armour;
import com.github.submarine.nova.weapons.Weapon;

public class Ship extends Piece {
	protected final String fleet;
	protected int health;
	protected Armour armour;
	protected Weapon weapon;

	public Ship(
		String name,
		int health,
		Armour armour,
		Weapon weapon,
		String fleet
	) {
		super(name);
		this.health = health;
		this.armour = armour;
		this.weapon = weapon;
		this.fleet = fleet;
	}

	public void takeDamage(Weapon weapon) {
		// techMod is the difference between tech levels
		// It is no affected by armour
		final int techMod = weapon.getTechLevel() - this.getArmour().getTechLevel();
		final int taken;
		if (this.getArmour().getResist() > 0) {
			taken = weapon.getDamage() - this.getArmour().getResist();
			this.getArmour().reduceIntegrity(Math.max(taken, 1));
		} else {
			taken = weapon.getDamage();
		}
		// TODO Negative Values!
		this.health -= taken + techMod;
	}

	public int getHealth() {
		return this.health;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public Armour getArmour() {
		return this.armour;
	}

	public String getFleet() {
		return this.fleet;
	}
}
