package com.github.submarine.nova.armours;

import org.junit.jupiter.api.Test;

class ArmourTest {
	private final int value = 10;
	private final Armour local = new Armour(this.value);

	@Test
	void getValue() { assert this.local.getValue() == this.value; }

	@Test
	void getIntegrity() { assert this.local.getIntegrity() == 100; }

	@Test
	void getResist() { assert this.local.getResist() == this.value; }

	@Test
	void reduceIntegrity() {
		Armour local = new Armour(this.value);
		local.reduceIntegrity(this.value);
		assert local.getIntegrity() == 90;
	}
}