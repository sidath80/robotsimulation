package com.robotsimulation.validation;

import com.robotsimulation.command.Command;
import com.robotsimulation.command.InvalidCommandException;
import com.robotsimulation.command.InvalidPlaceCommandException;
import com.robotsimulation.robot.Direction;

public class PlaceCommandValidationRule implements ValidationRule{

    public void validate(String inputString) throws RuntimeException {
        Command command;
        String[] args;
        String[] params=null;
        Direction direction;
        int x = 0;
        int y = 0;

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

    }
}
