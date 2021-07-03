package com.github.submarine.nova.combat;

import com.github.submarine.nova.common.Piece;

public class Ship extends Piece {
	protected int health;

	public Ship(String name) {
		super(name);
	}

	public void TakeDamage(Weapon weapon) {
		health -= weapon.Damage();
		if (health <= 0) {
			this.Die();
		}
	}

	private void Die() {
		System.out.println(this.name + "has died.");
	}
}
