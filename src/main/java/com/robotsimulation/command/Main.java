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

		int width = 5;
		int length = 5;

		final Logger logger = LoggerFactory.getLogger(Main.class);

		//create the table top with size (5,5)
		TableTop surface = new TableTop(width, length);
		Robot robot = new Robot();

		Simulation simulation = new RobotOnSurfaceSimulation(robot, surface);;
		String userInput;

		logger.info("........WELCOME TO THE WALKING ROBOT SIMULATION....");
		logger.info("........VALID COMMANDS ARE PLACE(eg:PLACE 2,2,NORTH)-MOVE-LEFT-RIGHT.....");
		logger.info("........TYPE EXIT AT ANY MOMENT TO STOP THE SIMULATION............");

		//read the user input
		Scanner scanner = new Scanner(System.in);
		while (true) {
			userInput = scanner.nextLine();
			if (userInput.equals("EXIT")) {
				break;
			} else {
				try {
					
					ActionHelper.onAction(userInput, simulation);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		scanner.close();
	}
}
