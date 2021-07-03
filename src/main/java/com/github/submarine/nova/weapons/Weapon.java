package com.github.submarine.nova.weapons;

public class Weapon {
	protected final int damage;

	public Weapon(int damage) {
		this.damage = damage;
	}

	public int Damage() {
		return this.damage;
	}
}
