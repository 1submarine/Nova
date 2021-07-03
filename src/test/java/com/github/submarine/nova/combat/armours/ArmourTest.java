package com.github.submarine.nova.combat.armours;

import org.junit.jupiter.api.Test;

class ArmourTest {

	@Test
	void getValue() {
		assert new Armour(10).getValue() == 10;
	}

	@Test
	void getIntegrity() {
		assert new Armour(10).getIntegrity() == 100;
	}

	@Test
	void getResist() {
		assert new Armour(10).getResist() == 10;
	}

	@Test
	void reduceIntegrity() {
		Armour local = new Armour(10);
		local.reduceIntegrity(10);
		assert local.getIntegrity() == 90;
	}
}