package com.github.submarine.nova.armours;

public class Armour {
	protected int value;
	protected int integrity;
	protected int resist;
	protected int techLevel;

	public Armour(int value) {
		this.value = value;
		this.integrity = 100;
		this.resist = value;
	}

	public int getValue() { return this.value; }
	public int getIntegrity() { return this.integrity; }
	public int getResist() { return this.resist; }
	public int getTechLevel() { return this.techLevel; }
	public void reduceIntegrity(int damage) {
		this.integrity -= damage;
		this.resist = this.getValue() * this.getIntegrity() / 100;
		if (this.getResist() < 0) {
			this.resist = 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;

		return
			this.getValue() == ((Armour) obj).getValue() &&
			this.getIntegrity() == ((Armour) obj).getIntegrity()
			;
	}
}
