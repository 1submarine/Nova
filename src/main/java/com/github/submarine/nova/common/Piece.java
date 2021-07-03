package com.github.submarine.nova.common;

public class Piece {
	protected String name;
	protected String refer;

	public Piece(String name) {
		assert name != null;
		this.refer = name.toLowerCase().replaceAll("\\w", "");
	}
	public void die() {
		System.out.println(
			this.refer +
			"is" +
			this.name
		);
	}
}
