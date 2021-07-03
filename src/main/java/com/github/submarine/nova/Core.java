package com.github.submarine.nova;

import com.github.submarine.nova.combat.Ship;
import com.github.submarine.nova.combat.weapons.Railgun;
import com.github.submarine.nova.common.Piece;

public class Core {
	public static void main(String[] args) {
		Piece foo = new Piece("Hello World");
		foo.die();
		Ship bar = new Ship("USS Enterprise");
		bar.TakeDamage(new Railgun(10));
	}
}
