package com.github.submarine.nova.combat.armours;

public class Armour {
	protected int value;
	protected int integrity;

	public Armour(int value) {
		this.value = value;
		this.integrity = 100;
	}

	public int getValue() {
		return this.value;
	}

	public int getIntegrity() {
		return this.integrity;
	}
	public int getResist() { return this.getValue() * this.getIntegrity() / 100; }

	public void reduceIntegrity(int damage) {
		this.integrity -= damage;
		if (this.integrity < 1) this.integrity = 1;
	}
}
