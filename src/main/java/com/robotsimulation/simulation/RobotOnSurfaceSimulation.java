package com.robotsimulation.simulation;

import com.robotsimulation.command.InvalidPlaceCommandException;
import com.robotsimulation.robot.Direction;
import com.robotsimulation.robot.Position;
import com.robotsimulation.robot.Robot;
import com.robotsimulation.surface.TableTop;


public class RobotOnSurfaceSimulation implements Simulation {

	private Robot robot;
	private TableTop surface;

	public RobotOnSurfaceSimulation(Robot robot, TableTop surface) {
		this.robot = robot;
		this.surface = surface;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public TableTop getSurface() {
		return surface;
	}

	private boolean isRobotMovable() {

		return surface.getLength() >= robot.getPosition().getY() && surface.getWidth() >= robot.getPosition().getX();
	}

	public void place(int x, int y, Direction facing) throws RuntimeException{

		Position position = new Position(x, y, facing);
		robot.setPosition(position);

		if (!isRobotMovable()) {
			throw new InvalidPlaceCommandException("Invalid command");
		}

	}

	public void move() {

		this.robot = RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot, surface);
	}

	public void left() {

		this.robot = RobotOnSurfaceRotateHelper.robotOnSurfaceRotateLeft(robot);
	}

	public void right() {
		this.robot = RobotOnSurfaceRotateHelper.robotOnSurfaceRotateRight(robot);

	}

	public void report() {
		System.out.println("Current Position : "+robot.getPosition().getX() + "," + robot.getPosition().getY() + ","
				+ robot.getPosition().getDirection());

	}
}
