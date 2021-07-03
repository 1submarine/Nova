package com.github.submarine.nova.fleet;

import com.github.submarine.nova.combat.Weapon;
import com.github.submarine.nova.combat.Armour;
import org.junit.jupiter.api.Test;

class ShipTest {
	@Test
	public void TakeDamage() {
		Ship ship = new Ship("Test", 10, new Armour(10));
		ship.TakeDamage(new Weapon(10));
		assert ship.GetHealth() == 9;
	}
}