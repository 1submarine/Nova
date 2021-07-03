package com.github.submarine.nova.fleet;

import com.github.submarine.nova.combat.Weapon;
import com.github.submarine.nova.combat.Armour;
import com.github.submarine.nova.common.Piece;

public class Ship extends Piece {
	protected int health;
	// protected ArrayList<Armour> armourLayers;
	protected Armour armour;

	public Ship(String name, int health, Armour armour) {
		super(name);
		this.health = health;
		// this.armourLayers = armourLayers;
		this.armour = armour;
	}

	public void TakeDamage(Weapon weapon) {
		health -= weapon.Damage() / armour.getValue();
	}

	public int GetHealth() {
		return health;
	}
}
