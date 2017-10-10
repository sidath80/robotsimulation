package com.robotsimulation.simulation;

import com.robotsimulation.robot.Direction;
import com.robotsimulation.robot.Position;
import com.robotsimulation.robot.Robot;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotOnSurfaceRotateHelperTest {

    @Test
    public void robotOnSurfaceFacingNorthRotateLeft() throws Exception {

        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.NORTH);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceRotateHelper.robotOnSurfaceRotateLeft(robot);


        Position expectedPosition=new Position(2,2, Direction.WEST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

    @Test
    public void robotOnSurfaceFacingNorthRotateRight() throws Exception {

        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.NORTH);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceRotateHelper.robotOnSurfaceRotateRight(robot);


        Position expectedPosition=new Position(2,2, Direction.EAST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

    @Test
    public void robotOnSurfaceFacingSouthRotateLeft() throws Exception {

        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.SOUTH);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceRotateHelper.robotOnSurfaceRotateLeft(robot);


        Position expectedPosition=new Position(2,2, Direction.EAST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

    @Test
    public void robotOnSurfaceFacingSouthRotateRight() throws Exception {

        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.SOUTH);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceRotateHelper.robotOnSurfaceRotateRight(robot);


        Position expectedPosition=new Position(2,2, Direction.WEST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

}