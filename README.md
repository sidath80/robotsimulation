 README
							             ======
							
				              Robot Simulation API 0.0.1 release
	    		-------------------------------------------------------------
	    		
Welcome to the robotsimulation API 0.0.1 release!  This release includes versions of the 
robotsimulation API implementation.

JDK Version notes
=============================================================================================

The robotsimulation API supports JDK 1.8 or higher and Maven 3.0 or higher.  Note that I have currently tested this 
implementation with JDK 1.8.

 To Run
==============================================================================================
			
	    1. To run the test, type "mvn test"
	       
	       ActionHelperTest.java : Which will run the test cases which covers all user input validation,
	       RobotOnSurfaceMoveHelperTest.java : Which will run the test cases all simulation move action relate to robot.
	       RobotOnSurfaceRotateHelperTest.java : Which will run the test cases all simulation rotate action relate to robot.
	       
	    2. To run the simulation, type "mvn clean package" and 
	    									java -jar 	target/robotsimulation-0.0.1-SNAPSHOT-jar-with-dependencies.jar
		
		3. Latest version of the code available at the 
		
			Fetch URL: https://github.com/sidath80/robotsimulation.git
  			Push  URL: https://github.com/sidath80/robotsimulation.git
  			HEAD branch: master
  			Remote branch: master tracked
  
