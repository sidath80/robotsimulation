package com.robotsimulation.simulation;

import com.robotsimulation.robot.Robot;
import com.robotsimulation.surface.TableTop;

class RobotOnSurfaceMoveHelper {

	private static final int ROBOT_MOVING_UNIT = 1;
	private static final int ROBOT_MOVING_UNIT_ZERO = 0;


	public static Robot robotOnSurfaceMove(Robot robot, TableTop surface) {

		switch (robot.getPosition().getDirection()) {
		case NORTH:
			if (surface.getLength() >= robot.getPosition().getY() + ROBOT_MOVING_UNIT) {
				robot.getPosition().setY(robot.getPosition().getY() + ROBOT_MOVING_UNIT);
			} else {
				throw new SimulationException("Invalid command");
			}
			break;
		case EAST:
			if (surface.getLength() >= robot.getPosition().getX() + ROBOT_MOVING_UNIT) {
				robot.getPosition().setX(robot.getPosition().getX() + ROBOT_MOVING_UNIT);
			} else {
				throw new SimulationException("Invalid command");
			}
			break;
		case SOUTH:
			if (ROBOT_MOVING_UNIT_ZERO <= robot.getPosition().getY() - ROBOT_MOVING_UNIT) {
				robot.getPosition().setY(robot.getPosition().getY() - ROBOT_MOVING_UNIT);
			} else {
				throw new SimulationException("Invalid command");
			}
			break;
		case WEST:
			if (ROBOT_MOVING_UNIT_ZERO <= robot.getPosition().getX() - ROBOT_MOVING_UNIT) {
				robot.getPosition().setX(robot.getPosition().getX() - ROBOT_MOVING_UNIT);
			} else {
				throw new SimulationException("Invalid command");
			}
			break;
		default:
			throw new SimulationException("Invalid command");
		}

		return robot;

	}

}
