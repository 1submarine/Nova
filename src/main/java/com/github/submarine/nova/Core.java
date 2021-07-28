package com.github.submarine.nova;

import com.github.submarine.nova.fleet.Cruiser;
import com.github.submarine.nova.fleet.Fleet;
import com.github.submarine.nova.fleet.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Core {
	public static void main(String[] args) {
		/*
		 Create GUI
		 *Extremely* bugged
		 Fix additional print to console
		*/
		EventQueue.invokeLater(() -> {
			BattleResult frame = new BattleResult();
			frame.setVisible(true);

			HashMap<String, Fleet> fleets = new HashMap<>();
			fleets.put("fleet1", new Fleet());
			fleets.put("fleet2", new Fleet());
			ArrayList<Ship> deadShips = new ArrayList<>();

			Core.addShip("Enterprise", "fleet1", fleets);
			Core.addShip("Clark", "fleet1", fleets);
			Core.addShip("Augustus", "fleet2", fleets);
			Core.addShip("Julius", "fleet2", fleets);

			// TODO clean this mess up
			while (!Core.isVictory(fleets)) {
				for (Map.Entry<String, Fleet> entry : fleets.entrySet()) {
					// String fleetKey = entry.getKey();
					Fleet fleet = entry.getValue();
					for (Map.Entry<String, Ship> e : fleet.entrySet()) {
						String shipKey = e.getKey();
						Ship ship = e.getValue();
						Core.damage(
							ship,
							fleets
						);
						Core.battleResult(ship);
						// TODO, simultaneous combat resolution
						if (ship.getHealth() < 1) {
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

	public static boolean isVictory(HashMap<String, Fleet> fleets) {
		AtomicBoolean empty = new AtomicBoolean(false);
		fleets.forEach((fleetKey, fleetValue) -> {
			if (fleetValue.isEmpty()) empty.set(true);
		});
		return empty.get();
	}

	public static void battleResult(Ship ship) {
		System.out.println(ship.getName() + ":");
		System.out.println("\tHealth: " + ship.getHealth());
		System.out.println("\tArmour: " + ship.getArmour().getResist());
		System.out.println();
	}

	public static void damage(
		Ship target,
		HashMap<String, Fleet> enemy
	) {
		enemy.forEach((localKey, localFleet) -> {
			if (!localKey.equals(target.getFleet()))
				localFleet.forEach((localShipKey, localShip) ->
					target.takeDamage(localShip.getWeapon()));
		});
	}

	public static void addShip(String name, String fleetName, HashMap<String, Fleet> fleets) {
		fleets.get(fleetName).put(
			name.toLowerCase(),
			new Cruiser(
				name,
				fleetName
			)
		);
	}
}
