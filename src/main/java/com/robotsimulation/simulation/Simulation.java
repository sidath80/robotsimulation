package com.robotsimulation.simulation;

import com.robotsimulation.robot.Direction;
import com.robotsimulation.surface.TableTop;

public interface Simulation {

	void place(int x, int y, Direction facing);

	void move();

	void left();

	void right();

	void report();

	TableTop getSurface();
}
