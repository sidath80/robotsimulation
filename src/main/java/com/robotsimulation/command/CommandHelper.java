package com.robotsimulation.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.robotsimulation.robot.Direction;
import com.robotsimulation.simulation.Simulation;
import com.robotsimulation.simulation.SimulationException;
import com.robotsimulation.validation.PlaceCommandValidationRule;
import com.robotsimulation.validation.ValidationRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CommandHelper {

    static List<Command> commandsList = new ArrayList<>();
    private static int x = 0;
    private static int y = 0;
    private static Direction direction;
    private static final Logger logger = LoggerFactory.getLogger(CommandHelper.class);

    private static Command getCommand(String inputString, Simulation simulation) throws RuntimeException {

        logger.info("CommandHelper.getCommand(" + inputString + ")");

        Command command;
        String[] args;
        try {
            args = inputString.split(" ");
            command = Command.valueOf(args[0]);
        } catch (Exception e) {
            throw new InvalidCommandException("Invalid command,Valid commands are PLACE(eg:PLACE 2,2,NORTH)-MOVE-LEFT-RIGHT");
        }
        //validate PLACE command
        if (command == Command.PLACE) {
            List<ValidationRule> rules = getValidationRules();
            for (ValidationRule rule : rules) {
                rule.validate(inputString);
            }
            getPLACECommandParameters(args[1]);
            if (y > simulation.getSurface().getLength()
                    || x > simulation.getSurface().getWidth()) {
                throw new InvalidPlaceCommandException("Invalid PLACE command,(Eg: PLACE 2,2,NORTH)");
            }

        } else {
            //PLACE command should be the first command in this simulation
            Optional<Command> chkCommand = commandsList.stream().findFirst();

            if (!chkCommand.isPresent() || !chkCommand.get().equals(Command.PLACE)) {
                throw new InvalidCommandException("Invalid command,You should place the robot first");
            }
        }

        commandsList.add(command);
        return command;
    }

    private static List<ValidationRule> getValidationRules() {
        List<ValidationRule> rules = new ArrayList<>();
        rules.add(new PlaceCommandValidationRule());

        return rules;
    }

    private static void getPLACECommandParameters(String args) throws RuntimeException {
        String[] params = args.split(",");
        direction = Direction.valueOf(params[2]);
        x = Integer.parseInt(params[0]);
        y = Integer.parseInt(params[1]);
    }

    public static void onAction(String userInput, Simulation simulation) throws RuntimeException {


        switch (getCommand(userInput, simulation)) {
            case PLACE:
                try {
                    //place the robot on the surface
                    simulation.place(x, y, direction);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new InvalidPlaceCommandException("Invalid PLACE command (Eg: PLACE 2,2,NORTH)");
                }
                break;
            case MOVE:
                try {
                    //move robot
                    simulation.move();
                } catch (Exception e) {
                    throw new InvalidCommandException("Invalid MOVE command" + e.getMessage());
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
