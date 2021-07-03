package com.github.submarine.nova.fleet;

import com.github.submarine.nova.combat.armours.Plasteel;
import com.github.submarine.nova.combat.weapons.Railgun;

public class Cruiser extends Ship {
	public Cruiser(
		String name
	) {
		super(
			name,
			100,
			new Plasteel(),
			new Railgun()
		);
	}
}
