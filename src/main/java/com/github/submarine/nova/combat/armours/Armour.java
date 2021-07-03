package com.github.submarine.nova.combat.armours;

public class Armour {
	protected int value;
	protected int integrity;

	public Armour(int value) {
		this.value = value;
		this.integrity = 100;
	}

	public int getValue() {
		return value;
	}
}
