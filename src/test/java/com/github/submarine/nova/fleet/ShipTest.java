package com.github.submarine.nova.fleet;

import com.github.submarine.nova.armours.Plasteel;
import com.github.submarine.nova.weapons.Railgun;
import com.github.submarine.nova.weapons.Weapon;
import org.junit.jupiter.api.Test;

class ShipTest {
	@Test
	public void takeDamage() {
		Ship ship = new Ship(
			"Test",
			10,
			new Plasteel(),
			new Railgun()
		);
		ship.takeDamage(new Weapon(10));
		assert ship.getHealth() == 9;
	}
}