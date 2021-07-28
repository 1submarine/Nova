package com.github.submarine.nova.weapons;

public class Weapon {
	protected int damage;
	protected int techLevel;

	public Weapon(
		int damage,
		int techLevel
	) {
		this.damage = damage;
		this.techLevel = techLevel;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getTechLevel() {
		return this.techLevel;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;

		return this.getDamage() == ((Weapon) obj).getDamage();
	}
}
