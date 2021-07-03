package com.github.submarine.nova.fleet;

import com.github.submarine.nova.combat.armours.Armour;
import com.github.submarine.nova.combat.weapons.Weapon;
import com.github.submarine.nova.common.Piece;

public class Ship extends Piece {
	protected int health;
	protected Armour armour;
	protected Weapon weapon;

	public Ship(String name, int health, Armour armour, Weapon weapon) {
		super(name);
		this.health = health;
		this.armour = armour;
		this.weapon = weapon;
	}

	public void TakeDamage(Weapon weapon) {
		health -= weapon.Damage() / armour.getValue();
	}

	public int GetHealth() {
		return health;
	}

	public Weapon getWeapon() {
		return weapon;
	}
}
