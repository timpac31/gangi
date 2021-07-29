package io.timpac.gui;

public class Position {
	private final int x;
	private final int y;

	private Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Position of(int x, int y) {
		return new Position(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Position move(int x, int y) {
		return new Position(this.x + x, this.y + y);
	}
	
	@Override
	public String toString() {
		return x + "-" + y;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = x * prime + result;
		result = y * prime + result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return other.getX() == this.x && other.getY() == this.y;
	}
}
