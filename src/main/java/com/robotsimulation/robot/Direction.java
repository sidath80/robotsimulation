package com.robotsimulation.robot;

import com.robotsimulation.simulation.SimulationException;

public enum Direction {
	NORTH, SOUTH, EAST, WEST;

	public Direction left() {
		switch (this) {
		case NORTH:
			return WEST;
		case EAST:
			return NORTH;
		case SOUTH:
			return EAST;
		case WEST:
			return SOUTH;
		default:
			throw new SimulationException("Direction unknown,Valid direction are NORTH,EAST,WEST and SOUTH only " + this);
		}
	}

	public Direction right() {
		switch (this) {
		case NORTH:
			return EAST;
		case EAST:
			return SOUTH;
		case SOUTH:
			return WEST;
		case WEST:
			return NORTH;
		default:
			throw new SimulationException("Direction unknown: " + this);
		}
	}
}
