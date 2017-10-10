package com.robotsimulation.command;

import java.util.Scanner;

import com.robotsimulation.robot.Robot;
import com.robotsimulation.simulation.RobotOnSurfaceSimulation;
import com.robotsimulation.simulation.Simulation;
import com.robotsimulation.surface.TableTop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Main {
	public static void main(String args[]) {

		final Logger logger = LoggerFactory.getLogger(Main.class);

		TableTop surface = new TableTop(5, 5);
		Robot robot = new Robot();

		Simulation simulation = new RobotOnSurfaceSimulation(robot, surface);
		String userInput;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			logger.info("........WELCOME TO THE WALKING ROBOT....");
			logger.info("........VALID COMMANDS ARE PLACE(eg:PLACE 2,2,NORTH)-MOVE-LEFT-RIGHT.....");
			logger.info("........FOR EXIT TYPE DONE............");
			userInput = scanner.nextLine();
			if (userInput.equals("DONE")) {
				break;
			} else {
				ActionHelper.onAction(userInput, simulation);
			}
		}
		scanner.close();
	}
}
