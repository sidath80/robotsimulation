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
	private static Logger logger = LoggerFactory.getLogger(ActionHelper.class);

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
			commandsList.add(command);
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandException("Invalid Direction ,Valid direction are NORTH,EAST,WEST and SOUTH only");
		} catch (Exception e) {
			throw new InvalidCommandException("Invalid command,Valid commands are PLACE(eg:PLACE 2,2,NORTH)-MOVE-LEFT-RIGHT");
		}
		if (command == Command.PLACE && args.length != 2) {
			throw new InvalidCommandException("Invalid PLACE command,(Eg: PLACE 2,2,NORTH)");
		}
		if (command == Command.PLACE && params.length != 3) {
			throw new InvalidPlaceCommandException("Invalid PLACE command,(Eg: PLACE 2,2,NORTH)");
		}
		if (command == Command.PLACE && y > simulation.getSurface().getLength()
				|| x > simulation.getSurface().getWidth()) {
			throw new InvalidPlaceCommandException("Invalid PLACE command,(Eg: PLACE 2,2,NORTH)");
		}

		Optional<Command> chkCommand = commandsList.stream().findFirst();
		if (command != Command.PLACE) {
			if (!chkCommand.get().equals(Command.PLACE)) {
				throw new InvalidCommandException("Invalid command,You should place the robot first");
			}
		}
		return command;
	}

	public static void onAction(String userInput, Simulation simulation) {

		switch (getCommand(userInput, simulation)) {
		case PLACE:
			try {
				simulation.place(x, y, direction);
			} catch (Exception e) {
				e.printStackTrace();
				throw new SimulationException("Invalid PLACE command (Eg: PLACE 2,2,NORTH)");
			}
			break;
		case MOVE:
			try {
				simulation.move();
			} catch (Exception e) {
				throw new SimulationException("Invalid MOVE command" + e.getMessage());
			}
			break;
		case LEFT:
			try {
				simulation.left();
			} catch (Exception e) {
				throw new SimulationException("Invalid LEFT command" + e.getMessage());
			}

			break;
		case RIGHT:
			try {
				simulation.right();
			} catch (Exception e) {
				throw new SimulationException("Invalid RIGHT command" + e.getMessage());
			}

			break;
		case REPORT:
			try {
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
