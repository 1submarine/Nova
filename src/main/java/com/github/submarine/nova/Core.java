package com.github.submarine.nova;

import com.github.submarine.nova.combat.armours.Plasteel;
import com.github.submarine.nova.combat.weapons.Railgun;
import com.github.submarine.nova.fleet.Ship;

import java.util.HashMap;

public class Core {
	public static void main(String[] args) {
		HashMap<String, Ship> ships = new HashMap<>();
		ships.put(
			"enterprise",
			new Ship(
				"Enterprise",
				10,
				new Plasteel(),
				new Railgun()
			)
		);

		ships.put(
			"clark",
			new Ship(
				"Clark",
				10,
				new Plasteel(),
				new Railgun()
			)
		);
		while (true) {
			ships.get("clark").TakeDamage(ships.get("enterprise").getWeapon());
			ships.get("enterprise").TakeDamage(ships.get("clark").getWeapon());
			ships.entrySet().removeIf(stringShipEntry -> stringShipEntry.getValue().GetHealth() == 0);
		}
	}
}
