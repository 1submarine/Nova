package com.github.submarine.nova;

public class Piece {
	protected String name;
	protected String refer;

	public Piece(String name) {
		this.name = name;
		this.refer = name.toLowerCase().replaceAll("\\w", "");
	}
}
