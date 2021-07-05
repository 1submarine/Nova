package com.github.submarine.nova;

import com.github.submarine.nova.armours.Armour;
import com.github.submarine.nova.weapons.Railgun;
import com.github.submarine.nova.fleet.Cruiser;
import com.github.submarine.nova.fleet.Ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Core {
	public static void main(String[] args) {
		HashMap<String, Ship> ships = new HashMap<>();
		ArrayList<Ship> deadShips = new ArrayList<>();
		ships.put(
			"enterprise",
			new Cruiser(
				"Enterprise"
			)
		);
		ships.put(
			"clark",
			new Cruiser(
				"Clark"
			)
		);
		while (!ships.isEmpty()) {
			Iterator<Ship> i = ships.values().iterator();
			while (i.hasNext()) {
				Ship current = i.next();
				current.takeDamage(new Railgun().getDamage());
				System.out.println(current.getName() + ":");
				System.out.println("\tHealth: " + current.getHealth());
				System.out.println("\tArmour: " + current.getArmour().getResist());
				if (current.getHealth() <= 0) {
					deadShips.add(current);
					i.remove();
				}
				System.out.println();
			}
		}
		System.out.println("Dead:");
		deadShips.forEach(ship -> System.out.println("\t" + ship.getName()));
	}
}
