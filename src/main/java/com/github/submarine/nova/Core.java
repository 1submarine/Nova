package com.github.submarine.nova;

import com.github.submarine.nova.combat.Armour;
import com.github.submarine.nova.fleet.Ship;

import java.util.ArrayList;

public class Core {
	public static void main(String[] args) {
		ArrayList<Ship> ships = new ArrayList<>();
		ships.add(new Ship(
			"Enterprise",
			10,
			new Armour(10)
		));
		ships.removeIf(ship -> ship.GetHealth() == 0);
	}
}
