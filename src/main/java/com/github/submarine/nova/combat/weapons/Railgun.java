package com.github.submarine.nova.combat.weapons;

import com.github.submarine.nova.combat.Weapon;

public class Railgun implements Weapon {
	private final int damage;

	public Railgun(int damage) {
		this.damage = damage;
	}

	public int Damage() {
		return this.damage;
	}
}
