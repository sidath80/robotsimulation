package com.robotsimulation.simulation;

import com.robotsimulation.robot.Robot;

class RobotOnSurfaceRotateHelper {

	public static Robot robotOnSurfaceRotateLeft(Robot robot) {

		robot.getPosition().setDirection(robot.getPosition().getDirection().left());
		return robot;
	}

	public static Robot robotOnSurfaceRotateRight(Robot robot) {

		robot.getPosition().setDirection(robot.getPosition().getDirection().right());
		return robot;

	}
}
