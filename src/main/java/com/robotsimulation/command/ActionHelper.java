package com.robotsimulation.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.robotsimulation.robot.Direction;
import com.robotsimulation.simulation.Simulation;
import com.robotsimulation.simulation.SimulationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ActionHelper {

	static List<Command> commandsList = new ArrayList<>();
	private static String[] params;
	private static int x = 0;
	private static int y = 0;
	private static Direction direction;
	private static final Logger logger = LoggerFactory.getLogger(ActionHelper.class);

	private static Command getCommand(String inputString, Simulation simulation) throws RuntimeException {

		logger.info("ActionHelper.getCommand("+inputString+")");

		// validate command
		Command command;
		String[] args;
		try {
			args = inputString.split(" ");
			if (args.length == 2)
				params = args[1].split(",");
			command = Command.valueOf(args[0]);
			if (params != null && params.length == 3) {
				direction = Direction.valueOf(params[2]);

				x = Integer.parseInt(params[0]);
				y = Integer.parseInt(params[1]);
			}

		} catch (IllegalArgumentException e) {
			throw new InvalidCommandException("Invalid command,Valid commands are PLACE(eg:PLACE 2,2,NORTH)-MOVE-LEFT-RIGHT");
		} catch (Exception e) {
			throw new InvalidCommandException("Invalid command,Valid commands are PLACE(eg:PLACE 2,2,NORTH)-MOVE-LEFT-RIGHT");
		}
		//validate the PLACE command with initial arguments
		if (command == Command.PLACE && args.length != 2) {
			throw new InvalidCommandException("Invalid PLACE command,(Eg: PLACE 2,2,NORTH)");
		}
		//validate the PLACE parameters
		if (command == Command.PLACE && params.length != 3) {
			throw new InvalidPlaceCommandException("Invalid PLACE command,(Eg: PLACE 2,2,NORTH)");
		}
		//validate the PLACE command against the surface size
		if (command == Command.PLACE && y > simulation.getSurface().getLength()
				|| x > simulation.getSurface().getWidth()) {
			throw new InvalidPlaceCommandException("Invalid PLACE command,(Eg: PLACE 2,2,NORTH)");
		}
		//PLACE command should be the first command in this simulation
		Optional<Command> chkCommand = commandsList.stream().findFirst();
		if (command != Command.PLACE) {
			if (!chkCommand.get().equals(Command.PLACE)) {
				throw new InvalidCommandException("Invalid command,You should place the robot first");
			}
		}
		commandsList.add(command);
		return command;
	}

	public static void onAction(String userInput, Simulation simulation) {


		switch (getCommand(userInput, simulation)) {
		case PLACE:
			try {
				//place the robot on the surface
				simulation.place(x, y, direction);
			} catch (Exception e) {
				e.printStackTrace();
				throw new SimulationException("Invalid PLACE command (Eg: PLACE 2,2,NORTH)");
			}
			break;
		case MOVE:
			try {
				//move robot
				simulation.move();
			} catch (Exception e) {
				throw new SimulationException("Invalid MOVE command" + e.getMessage());
			}
			break;
		case LEFT:
			try {
				//turn to the left
				simulation.left();
			} catch (Exception e) {
				throw new SimulationException("Invalid LEFT command" + e.getMessage());
			}

			break;
		case RIGHT:
			try {
				//turn to the right
				simulation.right();
			} catch (Exception e) {
				throw new SimulationException("Invalid RIGHT command" + e.getMessage());
			}

			break;
		case REPORT:
			try {
				//get the report
				simulation.report();
			} catch (Exception e) {
				throw new SimulationException("Invalid REPORT command" + e.getMessage());
			}

			break;
		default:
			throw new InvalidCommandException("Invalid command,Valid commands are PLACE(eg:PLACE 2,2,NORTH)-MOVE-LEFT-RIGHT");
		}

	}

}
