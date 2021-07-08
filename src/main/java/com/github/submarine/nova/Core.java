package com.github.submarine.nova;

import com.github.submarine.nova.fleet.Cruiser;
import com.github.submarine.nova.fleet.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Core {
	public static void main(String[] args) {
		// Create GUI
		// *Extremely* bugged
		// Fix additional print to console
		EventQueue.invokeLater(() -> {
			BattleResult frame = new BattleResult();
			frame.setVisible(true);

			// TODO Create Separate Fleet Object
			HashMap<String, HashMap<String, Ship>> fleets = new HashMap<>();
			fleets.put("fleet1", new HashMap<>());
			fleets.put("fleet2", new HashMap<>());
			ArrayList<Ship> deadShips = new ArrayList<>();
			fleets.get("fleet1").put(
				"enterprise",
				new Cruiser(
					"Enterprise"
				)
			);
			fleets.get("fleet2").put(
				"clark",
				new Cruiser(
					"Clark"
				)
			);
			// TODO check all fleets to see if empty
			// URGENT clean this mess up
			while (!Core.isVictory(fleets)) {
				// ^ Concurrent Modification Exception
				for (Map.Entry<String, HashMap<String, Ship>> entry : fleets.entrySet()) {
					// String fleetKey = entry.getKey();
					HashMap<String, Ship> fleet = entry.getValue();
					for (Map.Entry<String, Ship> e : fleet.entrySet()) {
						String shipKey = e.getKey();
						Ship ship = e.getValue();
// TODO take damage from an active ship
						ship.takeDamage(100);
						// Print Ship Status
						System.out.println(ship.getName() + ":");
						System.out.println("\tHealth: " + ship.getHealth());
						System.out.println("\tArmour: " + ship.getArmour().getResist());
						System.out.println();
						if (ship.getHealth() <= 0) {
							deadShips.add(ship);
							fleet.remove(shipKey);
						}
					}
				}
			}
			System.out.println("Dead:");
			deadShips.forEach(ship -> System.out.println("\t" + ship.getName()));
		});
	}

	public static boolean isVictory(HashMap<String, HashMap<String, Ship>> fleets) {
		AtomicBoolean empty = new AtomicBoolean(false);
		fleets.forEach((fleetKey, fleetValue) -> {
			if (fleetValue.isEmpty()) empty.set(true);
		});
		return empty.get();
	}

}
