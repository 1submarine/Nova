package com.github.submarine.nova.fleet;

import com.github.submarine.nova.combat.armours.Plasteel;
import com.github.submarine.nova.combat.weapons.Railgun;
import com.github.submarine.nova.combat.weapons.Weapon;
import org.junit.jupiter.api.Test;

class ShipTest {
	@Test
	public void TakeDamage() {
		Ship ship = new Ship(
			"Test",
			10,
			new Plasteel(),
			new Railgun()
		);
		ship.TakeDamage(new Weapon(10));
		assert ship.GetHealth() == 9;
	}
}