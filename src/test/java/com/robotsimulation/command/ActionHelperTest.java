package com.robotsimulation.command;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import com.robotsimulation.robot.Robot;
import com.robotsimulation.simulation.RobotOnSurfaceSimulation;
import com.robotsimulation.surface.TableTop;
import org.junit.Before;
import org.junit.Test;
import com.robotsimulation.simulation.Simulation;
import com.robotsimulation.simulation.SimulationException;

public class ActionHelperTest {
	
	@Before
	public void setUpList() {
		ActionHelper.commandsList= new ArrayList<>();
	}
	

	@Test(expected = InvalidCommandException.class) // Assert
	public void testWithInvalidCommand() {

		// Arrange
		String userInput = "PLACA 2,2,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);

		// Act

		ActionHelper.onAction(userInput, simulation);

	}

	@Test(expected = InvalidCommandException.class) // Assert
	public void testWithInvalidParametersCommand() {

		// Arrange
		String userInput = "PLACA 2,2,5,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act

		ActionHelper.onAction(userInput, simulation);

	}

	@Test(expected = InvalidCommandException.class) // Assert
	public void testWithInvalidMultipleArgumentsCommand() {

		// Arrange
		String userInput = "PLACE MOVE 2,2,5,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act

		ActionHelper.onAction(userInput, simulation);

	}

	@Test(expected = InvalidCommandException.class) // Assert
	public void testWithInvalidDirectionCommand() {

		// Arrange
		String userInput = "PLACE 2,2,WW";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);

		// Act

		ActionHelper.onAction(userInput, simulation);

	}

	@Test(expected = InvalidPlaceCommandException.class)// Assert
	public void testWithoutDirectionPLACE() {

		// Arrange
		String userInput = "PLACE 2,2";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act
		ActionHelper.onAction(userInput, simulation);

	}
	
	@Test(expected = InvalidPlaceCommandException.class)// Assert
	public void testWithRobotPlaceOutSideTheSurface() {

		// Arrange
		String userInput = "PLACE 6,6,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act
		ActionHelper.onAction(userInput, simulation);

	}

	@Test
	public void testWithSuccessMOVE() {

		// Arrange
		String userInput = "PLACE 2,2,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		String userInput2 = "MOVE";
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act

		try {
			ActionHelper.onAction(userInput, simulation);
			ActionHelper.onAction(userInput2, simulation);

		} catch (SimulationException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			fail("Expected an SimulationException to be thrown");// Assert
		}

	}
	
	@Test
	public void testWithSuccessLEFT() {

		// Arrange
		String userInput = "PLACE 2,2,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		String userInput2 = "LEFT";
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act

		try {
			ActionHelper.onAction(userInput, simulation);
			ActionHelper.onAction(userInput2, simulation);

		} catch (SimulationException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			fail("Expected an SimulationException to be thrown");// Assert
		}

	}
	
	@Test
	public void testWithSuccessRIGHT() {

		// Arrange
		String userInput = "PLACE 2,2,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		String userInput2 = "RIGHT";
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act

		try {
			ActionHelper.onAction(userInput, simulation);
			ActionHelper.onAction(userInput2, simulation);

		} catch (SimulationException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			fail("Expected an SimulationException to be thrown");// Assert
		}

	}
	
	@Test
	public void testWithSuccessREPORT() {

		// Arrange
		String userInput = "PLACE 2,2,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		String userInput2 = "REPORT";
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act

		try {
			ActionHelper.onAction(userInput, simulation);
			ActionHelper.onAction(userInput2, simulation);

		} catch (SimulationException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			fail("Expected an SimulationException to be thrown");// Assert
		}

	}
	
	@Test
	public void testWithSuccessPLACE() {

		// Arrange
		String userInput = "PLACE 2,2,NORTH";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act

		try {
			ActionHelper.onAction(userInput, simulation);

		} catch (SimulationException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			fail("Expected an SimulationException to be thrown");// Assert
		}

	}
	
	@Test(expected = InvalidCommandException.class)// Assert
	public void testWithMOVECommand() {

		// Arrange
		String userInput = "MOVE";
		Robot robot = mock(Robot.class);
		TableTop tableTop = mock(TableTop.class);
		when(tableTop.getLength()).thenReturn(5);
		when(tableTop.getWidth()).thenReturn(5);
		Simulation simulation = mock(RobotOnSurfaceSimulation.class);
		when(simulation.getSurface()).thenReturn(tableTop);
		// Act
		ActionHelper.onAction(userInput, simulation);

	}


}
