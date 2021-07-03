package com.github.submarine.nova.armours;

public class Armour {
	protected int value;
	protected int integrity;

	public Armour(int value) {
		this.value = value;
		this.integrity = 100;
	}

	public int getValue() { return this.value; }
	public int getIntegrity() { return this.integrity; }
	public int getResist() { return this.getValue() * this.getIntegrity() / 100; }

	public void reduceIntegrity(int damage) {
		this.integrity -= damage;
		if (this.integrity < 1) this.integrity = 1;
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
