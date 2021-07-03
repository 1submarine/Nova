package com.github.submarine.nova.fleet;

import com.github.submarine.nova.combat.armours.Armour;
import com.github.submarine.nova.combat.weapons.Weapon;
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
		this.health -= weapon.Damage() / this.getArmour().getResist();
		this.armour.reduceIntegrity(weapon.Damage());
	}

	public int getHealth() {
		return this.health;
	}

	public String getName() {
		return this.name;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public Armour getArmour() {
		return this.armour;
	}
}
