package com.robotsimulation.robot;

public class Position {

	private int x;
	private int y;
	private Direction direction;

	public Position(int x, int y, Direction facing) {
		this.x = x;
		this.y = y;
		this.direction = facing;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Position))
			return false;

		Position position = (Position) o;

		if (x != position.x)
			return false;
		if (y != position.y)
			return false;
		return direction == position.direction;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + direction.hashCode();
		return result;
	}
}
