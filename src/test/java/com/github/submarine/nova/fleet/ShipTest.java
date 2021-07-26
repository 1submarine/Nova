package com.github.submarine.nova.fleet;

import com.github.submarine.nova.armours.Armour;
import com.github.submarine.nova.weapons.Weapon;
import org.junit.jupiter.api.Test;

class ShipTest {
	private final String name = "test";
	private final int value = 100;
	private final Weapon weapon = new Weapon(this.value);
	private final Ship local = new Ship(
		this.name,
		this.value,
		new Armour(this.value),
		new Weapon(this.value)
	);

	@Test
	void takeDamage() {
		this.local.takeDamage(weapon);
		assert this.local.getHealth() == 100;
		assert this.local.getArmour().getIntegrity() == 99;
		assert this.local.getArmour().getResist() == 99;
	}

	@Test
	void getHealth() { assert this.local.getHealth() == this.value; }

	@Test
	void getName() { assert this.local.getName().equals(this.name); }

	@Test
	void getWeapon() {
		Weapon tested = new Weapon(this.value);
		assert this.local.getWeapon().equals(tested);
	}

	@Test
	void getArmour() {
		Armour tested = new Armour(this.value);
		assert this.local.getArmour().equals(tested);
	}
}