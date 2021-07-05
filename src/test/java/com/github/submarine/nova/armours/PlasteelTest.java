package com.github.submarine.nova.armours;

import org.junit.jupiter.api.Test;

class PlasteelTest {
	private final Plasteel local = new Plasteel();

	@Test
	public void plasteel() { assert this.local.getValue() == 100; }
}