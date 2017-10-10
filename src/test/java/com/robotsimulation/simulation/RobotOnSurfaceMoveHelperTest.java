package com.robotsimulation.simulation;

import com.robotsimulation.robot.Direction;
import com.robotsimulation.robot.Position;
import com.robotsimulation.robot.Robot;
import com.robotsimulation.surface.TableTop;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotOnSurfaceMoveHelperTest {

    @Test
    public void robotOnSurfaceMoveWithNorthFacing() throws Exception {

        int width=5;
        int length=5;
        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.NORTH);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);


        Position expectedPosition=new Position(2,3, Direction.NORTH);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

    @Test
    public void robotOnSurfaceMoveWithSouthFacing() throws Exception {

        int width=5;
        int length=5;
        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.SOUTH);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);


        Position expectedPosition=new Position(2,1, Direction.SOUTH);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

    @Test
    public void robotOnSurfaceMoveWithEastFacing() throws Exception {

        int width=5;
        int length=5;
        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.EAST);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);


        Position expectedPosition=new Position(3,2, Direction.EAST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

    @Test
    public void robotOnSurfaceMoveWithWestFacing() throws Exception {

        int width=5;
        int length=5;
        int x=2;
        int y=2;

        Position placePosition=new Position(2,2, Direction.WEST);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);


        Position expectedPosition=new Position(1,2, Direction.WEST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }

    @Test
    public void robotOnTableTop00MoveWithNorthFacing() throws Exception {

        int width=5;
        int length=5;
        int x=0;
        int y=0;

        Position placePosition=new Position(x,y, Direction.NORTH);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);


        Position expectedPosition=new Position(0,1, Direction.NORTH);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }
    @Test
    public void robotOnTableTop00MoveWithEastFacing() throws Exception {

        int width=5;
        int length=5;
        int x=0;
        int y=0;

        Position placePosition=new Position(x,y, Direction.EAST);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);


        Position expectedPosition=new Position(1,0, Direction.EAST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }
    @Test(expected = SimulationException.class) // Assert
    public void robotOnTableTop00MoveWithSouthFacing() throws Exception {

        int width=5;
        int length=5;
        int x=0;
        int y=0;

        Position placePosition=new Position(x,y, Direction.SOUTH);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);

    }
    @Test(expected = SimulationException.class) // Assert
    public void robotOnTableTop00MoveWithWestFacing() throws Exception {

        int width=5;
        int length=5;
        int x=0;
        int y=0;

        Position placePosition=new Position(x,y, Direction.WEST);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);

    }
    @Test(expected = SimulationException.class) // Assert
    public void robotOnTableTop55MoveWithNorthFacing() throws Exception {

        int width=5;
        int length=5;
        int x=5;
        int y=5;

        Position placePosition=new Position(x,y, Direction.NORTH);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);

    }
    @Test(expected = SimulationException.class) // Assert
    public void robotOnTableTop55MoveWithEastFacing() throws Exception {

        int width=5;
        int length=5;
        int x=5;
        int y=5;

        Position placePosition=new Position(x,y, Direction.EAST);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);

    }
    @Test
    public void robotOnTableTop55MoveWithSouthFacing() throws Exception {

        int width=5;
        int length=5;
        int x=5;
        int y=5;

        Position placePosition=new Position(x,y, Direction.SOUTH);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);

        Position expectedPosition=new Position(5,4, Direction.SOUTH);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }
    @Test
    public void robotOnTableTop55MoveWithWestFacing() throws Exception {

        int width=5;
        int length=5;
        int x=5;
        int y=5;

        Position placePosition=new Position(x,y, Direction.WEST);
        TableTop tableTop = new TableTop(width,length);
        Robot robot = new Robot();
        robot.setPosition(placePosition);

        RobotOnSurfaceMoveHelper.robotOnSurfaceMove(robot,tableTop);

        Position expectedPosition=new Position(4,5, Direction.WEST);
        Position newPosition=robot.getPosition();
        assertEquals(expectedPosition,newPosition);

    }


}